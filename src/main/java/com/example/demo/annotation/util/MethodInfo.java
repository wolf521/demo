package com.example.demo.annotation.util;

import java.lang.annotation.*;

/**
 * Created by cuizhixiang on 2017/6/1.
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MethodInfo {
    String author() default "cuizhixiang";
    String date();
    String description();
}
