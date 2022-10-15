package com.wjb.java.juc.base;

import java.util.concurrent.TimeUnit;

/**
 * @auther Arjun
 * @create 2022-01-12 16:23
 */
public class DaemonDemo
{
    public static void main(String[] args)//一切方法运行的入口
    {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 开始运行, "+
                    (Thread.currentThread().isDaemon() ? "守护线程":"用户线程"));
            while(true)
            {

            }
        },"t1");
        // 设置守护进程
        t1.setDaemon(true);
        t1.start();

        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println(Thread.currentThread().getName()+"\t ----end 主线程");
    }
}
