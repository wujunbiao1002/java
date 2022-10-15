package com.wjb.java.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <b><code>GenericTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/3 13:34.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class GenericClassDemo {

    @Test
    public void test() {
        Order<Object> objectOrder = new Order<>();
        objectOrder.setId(3);
        SubOrder<Object, Object, Object> order = new SubOrder<>();
        order.setId(1);
        SubOrder2<Object, Object, Object> order2 = new SubOrder2<>();
        order2.setId(2);

        show(Collections.singletonList(objectOrder));
        show(Collections.singletonList(order));
        show(Collections.singletonList(order2));

        show2(objectOrder);
        show2(order);
        show2(order2);

//        show3(objectOrder);
//        show3(order);
//        show3(order2);
    }

    public void show(List<? extends Order> o) {
        System.out.println(o.toString());
    }

    public void show2(Order<? super Order> o) {
        System.out.println(o.toString());
    }

    public void show3(Order<? extends Order<Object> > o) {
        System.out.println(o.toString());
    }
}

class Order<T> {
    Integer id;
    String name;
    T orderT;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderT=" + orderT +
                '}';
    }

    public Order(Integer id, String name, T orderT) {
        this.id = id;
        this.name = name;
        this.orderT = orderT;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public <E> ArrayList<E> show(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        return list;
    }

    public <E> E show(E e) {
        return e;
    }
}

class SubOrder<E, T, V> extends Order<E> {
    T t;
    V v;

    public <E> E show2(E e) {
        return e;
    }
}

class SubOrder2<E, T, V> extends SubOrder<E, T, V> {
    T t;
    V v;
}