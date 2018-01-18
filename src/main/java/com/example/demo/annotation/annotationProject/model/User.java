package com.example.demo.annotation.annotationProject.model;

import com.example.demo.annotation.annotationProject.util.Column;
import com.example.demo.annotation.annotationProject.util.Table;

/**
 * Created by cuizhixiang on 2017/6/22.
 **/
@Table("User")
public class User {

    @Column("id")
    private int id;

    @Column("name")
    private String name;

    @Column("tel")
    private String tel;

    @Column("age")
    private Integer age;

    @Column("city")
    private String city;

    public User() {
    }

    public User(String name, String tel, Integer age) {
        this.name = name;
        this.tel = tel;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
