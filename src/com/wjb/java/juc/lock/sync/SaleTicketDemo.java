package com.wjb.java.juc.lock.sync;

/**
 * 卖票
 */
class Ticket //资源类，模拟3个售票员卖完50张票
{
    private int number = 50;

    final Object lockObject = new Object();

    public void sale()
    {
        synchronized (lockObject) {
            if(number > 0)
            {
                System.out.println(Thread.currentThread().getName()+"卖出第：\t"+(number--)+"\t 还剩下:"+number);
            }
        }
    }
}

public class SaleTicketDemo
{
    public static void main(String[] args)//一切程序的入口
    {
        Ticket ticket = new Ticket();

        new Thread(() -> { for (int i = 0; i <55; i++)  ticket.sale(); },"a").start();
        new Thread(() -> { for (int i = 0; i <55; i++)  ticket.sale(); },"b").start();
        new Thread(() -> { for (int i = 0; i <55; i++)  ticket.sale(); },"c").start();
    }
}
