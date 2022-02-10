package com.wjb.java.basic;

/**
 * <b><code>Sort</code></b>
 * <p/>
 * Description 排序
 * <p/>
 * <b>Creation Time:</b> 2022/2/5 16:39.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class Sort {
    public static void main(String[] args) {
        test1();
    }

    // 冒泡排序
    public static void test1() {
        int[] ints = new int[]{3, 5, 6, 1, 2, 7, 8, 9, 4, 10};

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    // 快速排序
    public static void test2() {

    }

    // 堆排序
    public static void test3() {

    }

    // 归并排序
    public static void test4() {

    }

}
