package com.daojia.study.domain;

import java.io.Serializable;

/**
 * Created by xiachao on 2018/8/22 14:24
 */
public class User implements Serializable {

    private static final long serialVersionUID = 6562154519722126669L;
    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
