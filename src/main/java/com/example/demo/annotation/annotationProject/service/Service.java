package com.example.demo.annotation.annotationProject.service;

import com.example.demo.annotation.annotationProject.model.User;
import com.example.demo.annotation.annotationProject.util.Column;
import com.example.demo.annotation.annotationProject.util.Table;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/1/18.
 */
public class Service {
    public static void main(String[] agrs) {
        User user = new User();
        user.setName("夏明");
        user.setAge(12);
        try {
            String sql = new Service().query(user);
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String query(User user)throws Exception {
        StringBuffer sb = new StringBuffer();
        Class aClass = user.getClass();
        if (aClass.isAnnotationPresent(Table.class)) {
            // 获取到表名
            Table table = (Table) aClass.getAnnotation(Table.class);
            String value = table.value();
            sb.append("select * from ").append(value).append(" where 1 = 1");
            // 获取字段名
            Field[] fields = aClass.getDeclaredFields();
            for(Field field:fields){
                // 拿到字段名及值
                if(field.isAnnotationPresent(Column.class)){
                    Column column = field.getAnnotation(Column.class);
                    String columnName = column.value();
                    String fieldName = field.getName();
                    // 获得get方法名称
                    String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                    Method method = aClass.getMethod(getMethodName);
                    Object fieldValue = method.invoke(user,null);
                    if(fieldValue == null || (fieldValue instanceof Integer && (Integer)fieldValue == 0)){
                        continue;
                    }
                    sb.append(" AND ").append(fieldName).append(" = ");
                    if(fieldValue instanceof Integer){
                        sb.append(fieldValue);
                    } else {
                        sb.append("'").append(fieldValue).append("'");
                    }
                }
            }
            return sb.toString();
        } else {
            return null;
        }
    }
}
