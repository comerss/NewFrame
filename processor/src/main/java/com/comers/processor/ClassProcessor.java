package com.comers.processor;

import com.comers.annotation.MainThread;
import com.comers.annotation.Swordsman;
import com.google.auto.service.AutoService;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@AutoService(ClassProcessor.class)
public class ClassProcessor extends AbstractProcessor {
    ProcessingEnvironment mProcessingEnvironment;
    Filer mFiler;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        mProcessingEnvironment = processingEnvironment;
        mFiler = processingEnvironment.getFiler();
        super.init(processingEnvironment);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Messager messager = mProcessingEnvironment.getMessager();
        for (Element element : roundEnvironment.getElementsAnnotatedWith(Swordsman.class)) {
            //作用域的判断
            //成员变量
            if (element.getKind() == ElementKind.FIELD) {
                messager.printMessage(Diagnostic.Kind.NOTE, element.toString());
            }
        }
        for (Element element : roundEnvironment.getElementsAnnotatedWith(MainThread.class)) {
            MainThread main = element.getAnnotation(MainThread.class);
            if (main != null && main.isMainThread()) {

            }
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        //添加支持的注解库
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(Swordsman.class.getCanonicalName());
        annotations.add(MainThread.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }
}
