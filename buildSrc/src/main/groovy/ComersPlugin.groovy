

import com.android.build.api.transform.*
import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.pipeline.TransformManager
import com.comers.buildsrc.ComersClassVisitor
import jdk.internal.org.objectweb.asm.MethodVisitor
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter

import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.zip.ZipEntry

public class ComersPlugin extends Transform implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def android = project.extensions.getByType(AppExtension)
        android.registerTransform(this)
        MethodVisitor
    }

    @Override
    String getName() {
        return "ComersPlugin"
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        //插件作用时机
        return TransformManager.CONTENT_CLASS
    }

    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        //插件作用范围
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        //是否支持增量更新
        return false
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        def inputs = transformInvocation.inputs
        TransformOutputProvider provider = transformInvocation.getOutputProvider()
        //如果不是增量更新则删除之前生成的文件
        if (!transformInvocation.incremental) {
            provider.deleteAll()
        }
        inputs.forEach({
            it.directoryInputs.forEach {
                handleDirectory(it, provider)
            }
            it.jarInputs.forEach {
                handleJar(it, provider)
            }

        })

    }

    void handleDirectory(DirectoryInput input, TransformOutputProvider provider) {
        if (input.file.isDirectory()) {
            input.file.eachFileRecurse {
                def fileName = it.name
                if (checkClassFile(fileName)) {
                    ClassReader reader = new ClassReader(it.bytes)
                    ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS)
                    ComersClassVisitor visitor = new ComersClassVisitor(writer)
                    reader.accept(visitor, ClassReader.EXPAND_FRAMES)
                }

            }
        }
        //处理完输入文件之后，要把输出给下一个任务
        def dest = outputProvider.getContentLocation(directoryInput.name,
                directoryInput.contentTypes, directoryInput.scopes,
                Format.DIRECTORY)
        FileUtils.copyDirectory(directoryInput.file, dest)
    }

    void handleJar(JarInput input, TransformOutputProvider provider) {
        if (input.name.endsWith(".jar")) {
            def jarName = input.name
            def md5Name = DigestUtils.md5Hex(input.file.getAbsolutePath())
            if (jarName.endsWith(".jar")) {
                jarName = jarName.substring(0, jarName.length() - 4)
            }
            def jarFile = new JarFile(input.file)
            def enumeration = jarFile.entries()
            def tempFile = new File(input.file.getParent() + File.separator + "temp.jar")
            if (tempFile.exists()) {
                tempFile.delete()
            }
            def outputStream = new JarOutputStream(new FileOutputStream(tempFile))
            while (enumeration.hasMoreElements()) {
                def jarEntry = enumeration.nextElement()
                def entryName = jarEntry.name
                def zipEntry = new ZipEntry(entryName)
                def inputStream = jarFile.getInputStream(zipEntry)
                if (checkClassFile(entryName)) {
                    outputStream.putNextEntry(zipEntry)
                    def classReader = new ClassReader(IOUtils.toByteArray(inputStream))
                    def classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
                    def visitor = new ComersClassVisitor(classWriter)
                    classReader.accept(visitor, ClassReader.EXPAND_FRAMES)
                    outputStream.write(classWriter.toByteArray())
                }
                outputStream.closeEntry()
            }
            outputStream.close()
            jarFile.close()
            def dest = provider.getContentLocation(jarName + md5Name, input.contentTypes, input.scopes, Format.JAR)
            FileUtils.copyDirectory(tempFile, dest)
            tempFile.delete()
        }
    }

    /**
     * 检查class文件是否需要处理
     * @param fileName
     * @return
     */
    boolean checkClassFile(String name) {
        //只处理需要的class文件
        return (name.endsWith(".class") && !name.startsWith("R\$")
                && !"R.class".equals(name) && !"BuildConfig.class".equals(name))
    }
}

