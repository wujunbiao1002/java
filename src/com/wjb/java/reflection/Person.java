package com.wjb.java.reflection;

import java.io.Serializable;

/**
 * <b><code>Person</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/26 18:03.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class Person<T> implements Serializable {
    private String name;
    private int age;
    public int height = 0;

    public Person() {

    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println(getName() + " - " + getAge() + " - " + this.height);
    }

    private void showSecret() {
        System.out.println("秘密");
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
