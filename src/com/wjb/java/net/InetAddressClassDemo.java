package com.wjb.java.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <b><code>InetAddressTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/25 17:22.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class InetAddressClassDemo {

    @Test
    public void test1() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }

    @Test
    public void test2() throws UnknownHostException {
        InetAddress localHost1 = InetAddress.getByName("8.8.8.8");
        InetAddress localHost2 = InetAddress.getByName("google.com");
        System.out.println(localHost1.getHostName());
        System.out.println(localHost2.getHostAddress());
    }
}
