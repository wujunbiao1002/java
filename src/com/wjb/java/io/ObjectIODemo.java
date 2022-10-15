package com.wjb.java.io;

import org.junit.Test;

import java.io.*;

/**
 * <b><code>ObjectIoTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/4 16:14.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class ObjectIODemo {
    @Test
    public void test() throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("object.bat"));

        outputStream.writeObject(new P(20,"小新"));
        outputStream.flush();
        outputStream.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.bat"));
        P o = (P) objectInputStream.readObject();
        System.out.println(o.toString());
    }
}

class P implements Serializable {

//    private final static long serialVersionUID = 12312313L;

    private int age;
    private String name;


    public P() {
    }

    public P(int age, String name) {
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

    protected Object eat() {
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