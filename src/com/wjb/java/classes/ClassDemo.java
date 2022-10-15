package com.wjb.java.classes;

import java.io.Serializable;

/**
 * <b><code>Test</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/7 17:21.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class ClassDemo {
    public static void main(String[] args) {
//        Person person = new Person();
//        Student student = new Student();
        // 多态性
//        person.eat();
//        student.eat();
//        if (person instanceof Student) {
//            System.out.println("1");
//        }
//        if (student instanceof Student) {
//            System.out.println("2");
//        }
//        if (student instanceof Person) {
//            System.out.println("3");
//        }
        Person person = new Student();
        person.add(1, 2, 3);
        person.add1(1, 2, 3);

        Student student = new Student();
        student.add(1, 2, 3);
    }
}

class Person implements Serializable {

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

class Student extends Person {
    private String school;
    private String ctiy;

    public Student() {
    }

    public Student(String school) {
        super();
        this.school = school;
    }

    public Student(int age, String name, String school) {
        super(age, name);
        this.school = school;
    }

    @Override
    public void add(int a, int[] b) {
        System.out.println("子类1");
    }

    public void add(int a, int b, int c) {
        System.out.println("子类2");
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public Student eat() {
        System.out.println("student吃饭");
        return null;
    }
}