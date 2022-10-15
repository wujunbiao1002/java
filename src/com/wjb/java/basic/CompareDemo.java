package com.wjb.java.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <b><code>Compare</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/23 13:53.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class CompareDemo {

    public static void main(String[] args) {
        // 1
        String [] arr = {"aa","cc","ee","bb"};
        Arrays.sort(arr, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                String o11 = (String) o1;
                String o22 = (String) o2;
                return -o11.compareTo(o22) ;
            }
        });
        for (String s : arr) {
            System.out.println(s);
        }


        // 2 自定义
        Goods goods = new Goods("商品1", 21);
        Goods goods1 = new Goods("商品3", 1);
        Goods goods2 = new Goods("商品2", 10);

        ArrayList<Goods> array = new ArrayList<Goods>();
        array.add(goods);
        array.add(goods1);
        array.add(goods2);

        Goods[] goods3 = array.toArray(new Goods[3]);
        Arrays.sort(goods3, new Comparator<Goods>(){
            @Override
            public int compare(Goods o1, Goods o2) {
                return Double.compare(o1.pcie, o2.pcie);
            }
        });
        for (Goods object : array) {
            System.out.println(object.toString());
        }
        for (Goods object : goods3) {
            System.out.println(object.toString());
        }
    }
}

class Goods {
    String name;
    double pcie;

    Goods(String name, double pcie){
        this.name=name;
        this.pcie=pcie;
    }
    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", pcie=" + pcie +
                '}';
    }


//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Goods) {
//            return Double.compare(this.pcie, ((Goods) o).pcie);
//        }
//        throw new IllegalArgumentException("参数错误");
//    }
}
