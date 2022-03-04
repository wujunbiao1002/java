package com.wjb.java.basic;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * <b><code>TreeSetTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/2 0:58.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class TreeSetTest {
    @Test
    public void test() {

        Comparator<User> comparator = (o1, o2) -> {
            if (o1 != null && o2 != null) {
                int compare = o1.getName().compareTo(o2.getName());
                if (compare != 0) {
                    return compare;
                } else {
                    return Integer.compare(o1.getAge(), o2.getAge());
                }
            }
            return 0;
        };
        TreeSet<User> set = new TreeSet<>(comparator);
        set.add(new User("test1", 1));
        set.add(new User("test2", 2));
        set.add(new User("test4", 4));
        set.add(new User("test4", 3));
        for (User o : set) {
            System.out.println(o.toString());
        }
    }
}

class User implements Comparable {
    private String name;
    private int age;

    public User(String name, int age) {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            int compare = this.name.compareTo(((User) o).getName());
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age,((User) o).getAge());
            }
        }
        return 0;
    }
}