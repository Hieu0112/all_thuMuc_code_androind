package com.example.inten_demo;

import java.io.Serializable;

public class Student implements Serializable {
    private int imgs;
    private String name;
    private int age;

    public Student(int imgs, String name, int age) {
        this.imgs = imgs;
        this.name = name;
        this.age = age;
    }

    public int getImgs() {
        return imgs;
    }

    public void setImgs(int imgs) {
        this.imgs = imgs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
