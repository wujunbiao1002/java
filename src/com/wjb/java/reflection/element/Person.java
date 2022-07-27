package com.wjb.java.reflection.element;

/**
 * <b><code>Person</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/27 11:31.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
@MyAnnotation("类")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {


    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnotation(value = "构造器")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation(value = "私有方法")
    private String show(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests, int age) throws NullPointerException, ClassCastException {
        return interests + age;
    }

    @Override
    public void info() {
        System.out.println("接口方法");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static String showDesc(String s) {
        System.out.println("我是一个可爱的人" + s);

        return " static String showDesc(String s) ";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
