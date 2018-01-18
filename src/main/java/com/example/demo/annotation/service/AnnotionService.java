package com.example.demo.annotation.service;


import com.example.demo.annotation.manager.Annotion;
import com.example.demo.annotation.manager.AnnotionManager;
import com.example.demo.annotation.util.ClassInfo;
import com.example.demo.annotation.util.MethodInfo;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by cuizhixiang on 2017/6/1.
 * 反射解析注解
 **/
public class AnnotionService {
    public static void main(String agrs[]){
        analysisClass();
        analysisMethod();
        analysisFatherClass();
    }

    /**
     * 解析类
     */
    private static void analysisClass(){
        Class classes = AnnotionManager.class;
        // 判断注解是否存在
        boolean boo = classes.isAnnotationPresent(ClassInfo.class);
        if (boo){
            Annotation annotation = classes.getAnnotation(ClassInfo.class);
            System.out.println(annotation);
        }
    }

    /**
     * 解析类继承自父类的注解
     */
    private static void analysisFatherClass(){
        Class classes = Annotion.class;
        // 判断注解是否存在
        boolean boo = classes.isAnnotationPresent(ClassInfo.class);
        if (boo){
            Annotation annotation = classes.getAnnotation(ClassInfo.class);
            System.out.println(annotation);
        }
    }

    /**
     * 解析方法
     */
    private static void analysisMethod(){
        Class classes = AnnotionManager.class;
        Method[] method = classes.getMethods();
        for(Method method1:method){
            MethodInfo methodInfo = method1.getAnnotation(MethodInfo.class);
            if(methodInfo != null){
                System.out.println(methodInfo);
            }
        }
    }
}
