package com.wjb.java.thread;

/**
 * <b><code>ProductTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/17 23:41.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Product product = new Product(clerk);
        Consumer consumer = new Consumer(clerk);

        product.start();
        consumer.start();
    }
}

class Clerk {
    private int product = 0;

    public synchronized void consumerProduct() {
        while (true) {
            if (product > 0) {
                System.out.println("开始消费第" + product + "产品");
                product--;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void produceProduct() {
        while (true) {
            if (product < 20) {
                product++;
                System.out.println("开始生产第" + product + "产品");
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Product extends Thread {
    private Clerk clerk;

    Product(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产");
        clerk.produceProduct();
    }
}

class Consumer extends Thread {
    private Clerk clerk;

    Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费");
        clerk.consumerProduct();
    }
}