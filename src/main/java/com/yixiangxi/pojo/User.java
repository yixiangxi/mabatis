/**
 * 功能：
 * 作者：yixiangxi
 * 日期：2024/1/27 19:53
 **/
package com.yixiangxi.pojo;

//alt + 鼠标左键拖动选择多列进行同时操作
//ctrl + alt + L 格式化代码
//alt + insert 快速生成getter和setter方法
public class User {
    private String name;
    private Integer id;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
