package com.wjb.java.basic;

import org.junit.Test;

/**
 * <b><code>String</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/18 11:17.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class StringTest {

    /**
     * 可变序列，线程安全
     */
    @Test
    public void stringBuffer(){
        StringBuffer buffer = new StringBuffer();
        System.out.println(buffer.length());

    }

    /**
     * 可变序列，线程不安全
     */
    @Test
    public void stringBuild(){
        StringBuilder builder = new StringBuilder();
        System.out.println(builder.length());
    }

    /**
     * 不可变序列
     */
    @Test
    public void string(){
        // 字面赋值，方法区
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        // new 堆
        String s3 = new String("abc");
        String s4 = new String("abc");
        s1.intern();
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);


        String s = "bad";
        char[] c = {'t', 'e', 's', 't'};
        char ch = 'N';
        change(s, c, ch);
        System.out.println(s.hashCode());
        System.out.println(c.hashCode());
        System.out.println(ch);
    }

    public static void change(String s, char[] c, char ch) {
        s = "good";
        c[0] = 'b';
        ch = 'Y';
        System.out.println(s.hashCode());
        System.out.println(c.hashCode());
        System.out.println(ch);
    }
}
