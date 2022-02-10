package com.wjb.java.classes;

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
public class Test {
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
        person.add1(1,2,3);

        Student student = new Student();
        student.add(1, 2, 3);
    }
}
