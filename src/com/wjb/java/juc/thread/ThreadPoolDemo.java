package com.wjb.java.juc.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 *
 */
public class ThreadPoolDemo {
    @Test
    public void executors() {
        /**
         * 不可以用Executors提供的线程方法，需要手动创建
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadScheduledExecutor();
        Executors.newScheduledThreadPool(1);
        Executors.newCachedThreadPool();

        Future submit = executorService.submit(new NumberCallable());
        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.execute(new NumberRunnable());
        executorService.shutdown();
    }

    @Test
    public void myThreadPool() {
        ExecutorService executorService = MyThreadPool.getExecutorService();
        try {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 给用户" + finalI + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}


class MyThreadPool {
    private final static Integer corePoolSize = 2;
    private final static Integer maximumPoolSize = 5;
    private final static Long keepAliveTime = 1L;
    private static final ExecutorService executorService = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSize,
            keepAliveTime,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy() // 默认抛出异常
//                new ThreadPoolExecutor.CallerRunsPolicy() // 退回给主线程执行
//                new ThreadPoolExecutor.DiscardOldestPolicy() // 淘汰队列最久的任务
//                new ThreadPoolExecutor.DiscardPolicy() // 直接放弃任务
            (r, executors) -> {
                //自定义饱和策略
                //记录一下无法处理的任务
                System.out.println("无法处理的任务：" + r.toString());
            }) {
        protected void beforeExecute(Thread t, Runnable r) {
            System.out.println(System.currentTimeMillis() + "," + t.getName()
                    + ",开始执行任务:" + r.toString());
        }

        protected void afterExecute(Runnable r, Throwable t) {
            System.out.println(System.currentTimeMillis() + "," +
                    Thread.currentThread().getName() + ",任务:" + r.toString() + "，执行完毕!");
        }

        protected void terminated() {
            System.out.println(System.currentTimeMillis() + "," +
                    Thread.currentThread().getName() + "，关闭线程池!");
        }
    };

    public static ExecutorService getExecutorService() {
        return executorService;
    }

}

class NumberCallable implements Callable {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}

class NumberRunnable implements Runnable {

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
    }
}