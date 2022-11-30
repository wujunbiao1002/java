package com.wjb.java.basic;

/**
 * <b><code>Operator</code></b>
 * <p/>
 * Description 变量
 * <p/>
 * <b>Creation Time:</b> 2022/2/5 11:33.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class VariableDemo {
    public static void main(String[] args) {
        // byte
        byte a = 127;
        byte b = 1;
        int c = a + b;
        System.out.println(c);

        // char
        char d = '1';
        char e = ' ';

//        Integer a1 = new Integer(1);
        Integer a1 = Integer.parseInt("1");
        Integer a2 = 1;
        System.out.println(a1 == a2);

        Integer a3 = 200;
        Integer a4 = 200;
        System.out.println(a3 == a4);

//        long a5 = 1L;
//        long a6 = 1L;
        Long a5 = 128L;
        Long a6 = 128L;
        System.out.println(a5 == a6);
    }
}
