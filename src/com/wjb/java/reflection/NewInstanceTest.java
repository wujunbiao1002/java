package com.wjb.java.reflection;

import org.junit.Test;

import java.util.Random;

/**
 * <b><code>NewIntaceTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/27 11:06.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class NewInstanceTest {
    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < 100; i++) {
            String classPath;
            int anInt = new Random().nextInt(4);
            switch (anInt) {
                case 1:
                    classPath = "java.util.Date";
                    break;
                case 2:
                    classPath = "com.wjb.java.reflection.Person";
                    break;
                case 3:
                    classPath = "java.util.Random";
                    break;
                default:
                    classPath = "java.util.ArrayList";
                    break;
            }
            Object o = newInstance(classPath);
            System.out.println(o);
        }
    }

    private Object newInstance(String classPath) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();
    }


}
