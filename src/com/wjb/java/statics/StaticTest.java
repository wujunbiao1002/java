package com.wjb.java.statics;

/**
 * <b><code>Person</code></b>
 * <p/>
 * Description static执行顺序
 * <p/>
 * <b>Creation Time:</b> 2022/2/10 14:58.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class StaticTest {
    public static void main(String[] args) {
        Student student = new Student();
    }
}
class Person{
    int age = 10;
    static {
        System.out.println("Person的静态代码块");
    }
    {
        System.out.println("Person的普通代码块");
    }

    Person(){
        System.out.println("Person的构造函数");
        age = 11;
    }
}

class Student extends Person{
    String name = "学生";

    static {
        System.out.println("Student的静态代码块");
    }
    {
        System.out.println("Student的普通代码块");
    }

    Student(){
        System.out.println("Student的构造函数");
        name = "学生2";
    }
}
