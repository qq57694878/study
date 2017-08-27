package com.ljl.time;

/**
 * Created by Administrator on 2017/8/21/021.
 */
public class Foo
{
    private String name;
    int age;

    public Foo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
