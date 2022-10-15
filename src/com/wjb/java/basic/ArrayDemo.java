package com.wjb.java.basic;

import java.util.Arrays;

/**
 * <b><code>ArrayList</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/5 15:32.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class ArrayDemo {
    public static void main(StringClassDemo[] args) {
        test1();
    }

    public static void test1() {
        int[] num = new int[]{5, 1, 2, 3, 4};
        int[] num3 = new int[]{5, 1, 2, 3, 4};
        System.out.println(Arrays.equals(num,num3));

        System.out.println(num);
        Arrays.sort(num);
        for (int j : num) {
            System.out.println(j);
        }

        int[][] num2 = new int[][]{{5, 1}, {2, 3}, {4}};
        System.out.println(num2);
        System.out.println(num2[0]);

    }
}
