package com.wjb.java.java8;

import org.junit.Test;

import java.util.Comparator;

/**
 * <b><code>LambdaTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/27 13:58.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java
 */
public class LambdaTest {

    @Test
    public void test1() {
        // 原始 匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        };
        runnable.run();

        // lambda
        Runnable runnable2 = () -> System.out.println("runnable");
        runnable2.run();

        System.out.println("------------");

        // 原始
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        System.out.println(comparator.compare(21, 2));
        // lambda
        //1
        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(21, 2));

        //2
        Comparator<Integer> comparator3 = ((o1, o2) -> {
            System.out.println("test");
            return Integer.compare(o1, o2);
        });
        System.out.println(comparator3.compare(1, 2));

        //3
        Comparator<Integer> comparator4 = (o1, o2) -> Integer.compare(o1, o2);

        System.out.println(comparator4.compare(1, 2));

        System.out.println("------------");
        FunctionalInterface functionalInterface = (s) -> {
            System.out.println(s);
            return "执行了";
        };
        System.out.println(functionalInterface.info("开始"));
    }

    @Test
    public void test2() {
        Person person = new Person("name",1);
        PersonShow personShow = person::getName;
        System.out.println(personShow.show());
    }
}
interface PersonShow{
    String show();
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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