package com.example.demo.annotation.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cuizhixiang on 2017/6/1.
 **/
@RestController
public class AnnotionController{

/**
 * 元数据：又称中介数据、中继数据，为描述数据的数据，主要是描述数据属性的信息，用来支持如指示存储位置、历史数据、资源查找、文件记录等功能。
 * java注解概念：Java提供了一种原程序中的元素关联任何信息和任何元数据的途径和方法
 * Java中常见注解：
 *      1：JDK自带注解：@Override：覆盖标志、@Deprecated：设置方法过时、@Suppvisewaraing：忽略某警告
 * 注解分类：
 *   1：按照运行机制分；生命周期
 *      源码注解：只在源码中存在，编译成.class文件时不存在
 *      编译时注解：在源码中和.class都存在，例如；@Override、@Deprecated、@Suppvisewaraing
 *      运行时注解：在运行时还起作用的，例如；@Autowired
 *   2：按照来源分
 *      JDK注解：例如；@Override、@Deprecated、@Suppvisewaraing
 *      第三方注解：例如；@Autowired
 *      自定义注解：自己定义的注解
 *   3：元注解：即注解的注解：例如；@Target、@Retention、@Documented、@Inherited
 * 自定义注解：
 *  语法要求：
 *   @Target({ElementType.METHOD，ElementType.TYPE})--------注解作用域：设置此注解可以在哪里使用，例如；ElementType.METHOD；指可以在方法上使用
 *   @Retention(RetentionPolicy.RUNTIME)-------注解生命周期
 *   @Documented----标识注解，允许子类继承
 *   @Inherited-----标识注解，生成javadoc的时候包含注解
 *   public @interface ClassInfo {-------------使用@interface来标识注解
 *   String author() default "cuizhixiang";-------成员以无参无异常方式定义，用default来设置默认值
 *   String date();                               注解成员类型包含所有基本类型及String、Class、Annotation、Enumeration
 *   int version();                               如果成员只有一个，则成员名必须为Value,使用时可以忽略成员名及赋值=
 *   String description();                        无成员的注解为标识注解
 *   }
 *
 *   Target 注解的作用域   CONSTRUCTOR 构造方法声明， FIELD 字段声明，LOCAL_VARIABLE 局部变量声明 ，METHOD 方法声明，PACKAGE 包声明，PARAMETER 参数声明，TYPE 类接口。
 *   Retention 生命周期 SOURCE 只在源码显示，编译时会丢弃，CLASS 编译时会记录到class中，运行时忽略，RUNTIME 运行时存在，可以通过反射读取。
 *   Inherited 允许子类继承
 *   Documented 生成javadoc的时候包含注解
 */
}
