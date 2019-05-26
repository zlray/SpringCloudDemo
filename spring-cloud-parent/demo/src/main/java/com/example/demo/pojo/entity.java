package com.example.demo.pojo;

import java.io.Serializable;

/**
 * Copyright (C)，XX
 * FileName: entity
 * Author: zl
 * Date: 2019/5/23  21:34
 * Description: entity
 **/

public class entity implements Serializable {

    private int age;
    private String name;

    public entity() {
    }
    public entity(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
