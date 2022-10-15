package com.wjb.java.basic;

import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/**
 * <b><code>TreeMap</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/3 12:28.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class TreeMapClassDemo {
    @Test
    public void test() {
        TreeMap<User1, String> treeMap = new TreeMap<>();
        User1 user1 = new User1("AA", 1);
        User1 user2 = new User1("BB", 10);
        User1 user3 = new User1("CC", 8);
        User1 user4 = new User1("DD", 5);
        treeMap.put(user1, "10");
        treeMap.put(user2, "100");
        treeMap.put(user3, "80");
        treeMap.put(user4, "50");

        Set set = treeMap.entrySet();
        for (Object o : set) {
            System.out.println(o.toString());
        }

        System.out.println("---------------------");

        Comparator<User2> comparator = Comparator.comparingInt(User2::getAge);

        TreeMap<User2, String> treeMap2 = new TreeMap<>(comparator);
        User2 user21 = new User2("AA", 1);
        User2 user22 = new User2("BB", 10);
        User2 user23 = new User2("CC", 8);
        User2 user24 = new User2("DD", 5);
        treeMap2.put(user21, "10");
        treeMap2.put(user22, "100");
        treeMap2.put(user23, "80");
        treeMap2.put(user24, "50");

        Set set2 = treeMap2.entrySet();
        for (Object o : set2) {
            System.out.println(o.toString());
        }
    }
}

class User1 implements Comparable<User1> {
    private String name;
    private int age;

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User1 o) {
        if (o != null) {
            return Integer.compare(this.age, o.getAge());
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User1 user1 = (User1) o;
        return age == user1.age && Objects.equals(name, user1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class User2 {
    private String name;
    private int age;

    public User2(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User2 user2 = (User2) o;
        return age == user2.age && Objects.equals(name, user2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}