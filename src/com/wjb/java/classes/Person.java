package com.wjb.java.classes;

import java.io.Serializable;

/**
 * <b><code>person</code></b>
 * <p/>
 * description
 * <p/>
 * <b>creation time:</b> 2022/2/7 15:25.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class Person implements Serializable {

//    private final static long serialVersionUID = 12312313L;

    private int age;
    private String name;


    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void add(int a, int... b) {
        System.out.println("父类");
    }

    public void add1(int a, int... b) {
        System.out.println("父类");
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

    protected Person eat() {
        System.out.println("Person 吃饭");
        return null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
