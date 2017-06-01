package com.example.demo.annotation.util;

import java.lang.annotation.*;

/**
 * Created by cuizhixiang on 2017/6/1.
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ClassInfo {
    String author() default "cuizhixiang";
    String date();
    int version();
    String description();
}
