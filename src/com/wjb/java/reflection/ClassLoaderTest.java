package com.wjb.java.reflection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <b><code>ClassLoaderTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/26 21:15.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class ClassLoaderTest {

    @Test
    public void test(){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader parent2 = parent1.getParent();
        System.out.println(parent2);

    }

    @Test
    public void test2(){
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);
    }

    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        // 方式1
//        InputStream inputStream = Files.newInputStream(Paths.get("jdbc,properties"));
//        properties.load(inputStream);

        // 方式2
        ClassLoader classLoader = properties.getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc,properties");
        properties.load(resourceAsStream);

        String key = properties.getProperty("key");
    }
}
