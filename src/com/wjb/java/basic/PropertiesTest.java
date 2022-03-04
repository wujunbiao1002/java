package com.wjb.java.basic;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <b><code>PropertiesTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/3 12:52.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class PropertiesTest {
    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc.properties"));
        System.out.println(properties.getProperty("name"));
    }
}
