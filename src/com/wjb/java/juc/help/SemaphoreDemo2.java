package com.wjb.java.juc.help;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class SemaphoreDemo2 {
    static Semaphore semaphore = new Semaphore(1);

    public static class T extends Thread {
        public T(String name) {
            super(name);
        }

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            //获取许可是否成功
            boolean acquireSuccess = false;
            try {
//                semaphore.acquire();
//                acquireSuccess = true;
                acquireSuccess = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                System.out.println(System.currentTimeMillis() + "," +
                        thread.getName() + ",获取许可,当前可用许可数量:" + semaphore.availablePermits());
                //休眠100秒
                TimeUnit.SECONDS.sleep(5);
                System.out.println(System.currentTimeMillis() + "," +
                        thread.getName() + ",运行结束!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (acquireSuccess) {
                    semaphore.release();
                    System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + ",释放许可!");
                }
            }
            System.out.println(System.currentTimeMillis() + "," + thread.getName()
                    + ",当前可用许可数量:" + semaphore.availablePermits());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t1 = new T("t1");
        t1.start();//休眠1秒
        TimeUnit.SECONDS.sleep(1);
        T t2 = new T("t2");
        t2.start();
        //休眠1秒
        TimeUnit.SECONDS.sleep(1);
        T t3 = new T("t3");
        t3.start();
        //给t2和t3发送中断信号
//        t2.interrupt();
//        t3.interrupt();
    }
}
