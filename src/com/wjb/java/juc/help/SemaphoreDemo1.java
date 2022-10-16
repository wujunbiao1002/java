package com.wjb.java.juc.help;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *比如有个停车场，有5个空位，门口有个门卫，手中5把钥匙分别对应5个车位上面的锁，来一辆车，门卫会给
 * 司机一把钥匙，然后进去找到对应的车位停下来，出去的时候司机将钥匙归还给门卫。停车场生意比较好，同
 * 时来了100两车，门卫手中只有5把钥匙，同时只能放5辆车进入，其他车只能等待，等有人将钥匙归还给门卫
 * 之后，才能让其他车辆进入。
 * 上面的例子中门卫就相当于Semaphore，车钥匙就相当于许可证，车就相当于线程。
 */
public class SemaphoreDemo1 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟3个停车位

        for (int i = 1; i <= 6; i++) //模拟6部汽车
        {
            new Thread(() -> {
                boolean acquireSuccess = false;
                try {
                    semaphore.acquire();
                    acquireSuccess = true;
                    System.out.println(Thread.currentThread().getName() + "\t 抢到了车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + "\t------- 离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (acquireSuccess) {
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName() + ",释放许可!");
                    }
                }
            }, String.valueOf(i)).start();
        }
    }
}
