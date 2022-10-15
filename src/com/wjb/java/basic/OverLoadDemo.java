package com.wjb.java.basic;

/**
 * <b><code>OverLoad</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/7 10:08.
 *
 * @author Arjun
 * @version 0.1.0
 * @since java
 */
public class OverLoadDemo {
    public static void main(StringClassDemo[] args) {
        test(1,2,3,4);
    }

    public static void test(int ...i){
        for (int i1 : i) {
            System.out.println(i1);
        }
    }
}
