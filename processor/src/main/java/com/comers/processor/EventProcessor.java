package com.comers.processor;

import com.comers.annotation.annotation.OnEvent;
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
import javax.lang.model.element.TypeElement;

@AutoService(EventProcessor.class)
public class EventProcessor extends AbstractProcessor {
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
        for (Element element : roundEnvironment.getElementsAnnotatedWith(OnEvent.class)) {
            OnEvent annotation= element.getAnnotation(OnEvent.class);
            String[] from=annotation.from();
        }
        return false;
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        //添加支持的注解库
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(OnEvent.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }
}
