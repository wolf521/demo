package com.example.demo.parameter.model;

/**
 * Created by cuizhixiang on 2017/6/16.
 *  user实体
 **/
public class User {
    /**
     * 姓名
     */
    private String name;
    /**
     * 电话号码
     */
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
