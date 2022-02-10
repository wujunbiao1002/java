package com.wjb.java.abstracts;

/**
 * <b><code>Car</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/10 15:05.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public abstract class Vehicle {

    /**
     * 计算燃料效率
     * @return double
     */
    public abstract double calcFuelEfficiency();

    /**
     * 计算行驶距离抽象方法
     * @return double
     */
    public abstract double calcTripDistance();
}
