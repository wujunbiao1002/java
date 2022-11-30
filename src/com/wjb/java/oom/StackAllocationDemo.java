package com.wjb.java.oom;

/**
 * 逃逸分析
 * 栈上分配
 */
public class StackAllocationDemo {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + " ms");
        // 为了方便查看堆内存中对象个数，线程sleep
        Thread.sleep(100000);
    }

    private static void alloc() {
        // 未发生逃逸
        User user = new User();
    }
}

class User {
    private String name;
    private String age;
    private String gender;
    private String phone;
}