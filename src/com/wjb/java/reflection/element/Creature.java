package com.wjb.java.reflection.element;

import java.io.Serializable;

/**
 * <b><code>Creature</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/27 11:31.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }

}
