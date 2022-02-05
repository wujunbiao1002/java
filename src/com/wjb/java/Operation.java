package com.wjb.java;

/**
 * <b><code>Operation</code></b>
 * <p/>
 * Description 运算符
 * <p/>
 * <b>Creation Time:</b> 2022/2/5 12:03.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class Operation {

    public static void main(String[] args) {
        test4();
    }

    // 跳出指定层次循环label
    public static void test4() {
        label:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 2)
                    continue label;
                System.out.println(j);
            }
        }
    }

    // break,continue
    public static void test3() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5)
                    continue;
                System.out.println(j);
            }
        }
    }

    // break,continue
    public static void test2() {

        // >> 右移
        System.out.println(">>");
        System.out.println(8 >> 3);
        System.out.println(-8 >> 3);

        System.out.println("~^|&");
        System.out.println(~1);
        System.out.println(12 ^ 5);
        System.out.println(12 | 5);
        System.out.println(12 & 5);
    }

    // 左移
    public static void test1() {
        // <<左移
        // 左移了2的n次幂
        System.out.println("<<");
        System.out.println(4 << 3);
        System.out.println(-4 << 3);
    }
}
