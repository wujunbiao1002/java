package com.wjb.java.basic;

/**
 * <b><code>Search</code></b>
 * <p/>
 * Description 查找
 * <p/>
 * <b>Creation Time:</b> 2022/2/5 16:38.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class Search {
    public static void main(String[] args) {
        test2();
    }

    // 线性查找
    public static void test1() {

    }

    // 二分查找
    public static void test2() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int dest = 5;
        int head = 0;
        int end = ints.length - 1;
        boolean isFind = false;
        do {
            int middle = (head + end) / 2;
            if (dest == ints[middle]) {
                System.out.println("find:" + middle);
                isFind = true;
                break;
            } else if (dest > ints[middle]) {
                head = middle;
            } else {
                end = middle;
            }
        } while (head <= end);

        if (!isFind) {
            System.out.println("no find");
        }
    }
}
