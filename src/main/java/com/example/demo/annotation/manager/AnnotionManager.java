package com.example.demo.annotation.manager;

import com.example.demo.annotation.util.ClassInfo;
import com.example.demo.annotation.util.MethodInfo;
import org.springframework.stereotype.Component;

/**
 * Created by cuizhixiang on 2017/6/1.
 **/
@Component
@ClassInfo(author="小华",date="07-6-17",version=1,description="注解测试类")
public class AnnotionManager {
    @MethodInfo(author="小明",date="01-6-17",description="注解测试方法")
    public void method(){
    }
}


