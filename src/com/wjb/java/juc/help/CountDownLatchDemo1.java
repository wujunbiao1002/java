package com.wjb.java.juc.help;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 1.假如有这样一个需求，当我们需要解析一个Excel里多个sheet的数据时，可以考虑使用多线程，每个线程解析一
 * 个sheet里的数据，等到所有的sheet都解析完之后，程序需要统计解析总耗时。分析一下：解析每个sheet耗时可能不一样，总耗时就是最长耗时的那个操作。
 *
 * 2.等待指定的时间
 * 还是上面的示例，2个线程解析2个sheet，主线程等待2个sheet解析完成。主线程说，我等待2秒，你们还是无法处理完成，就不等待了，直接返回。
 */
public class CountDownLatchDemo1 {
    public static class T extends Thread {
        //休眠时间（秒）
        int sleepSeconds;
        CountDownLatch countDownLatch;

        public T(String name, int sleepSeconds, CountDownLatch countDownLatch) {
            super(name);
            this.sleepSeconds = sleepSeconds;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread ct = Thread.currentThread();
                long startTime = System.currentTimeMillis();
                System.out.println(startTime + "," + ct.getName() + ",开始处理!");
                //模拟耗时操作，休眠sleepSeconds秒
                TimeUnit.SECONDS.sleep(this.sleepSeconds);
                long endTime = System.currentTimeMillis();
                System.out.println(endTime + "," + ct.getName() + ",处理完毕,耗时:" + (endTime - startTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown(); // 执行完成计数减1
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "线程 start!");
        CountDownLatch countDownLatch = new CountDownLatch(2);
        long starTime = System.currentTimeMillis();
        T t1 = new T("解析sheet1线程", 2, countDownLatch);
        t1.start();

        T t2 = new T("解析sheet2线程", 5, countDownLatch);
        t2.start();

//        countDownLatch.await(); // 等待替代 t1.join()
        boolean result = countDownLatch.await(2, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "线程 end!");
        long endTime = System.currentTimeMillis();
//        System.out.println("主线程耗时:" + (endTime - starTime));
        System.out.println("主线程耗时:" + (endTime - starTime) + ",result:" + result);
    }
}
