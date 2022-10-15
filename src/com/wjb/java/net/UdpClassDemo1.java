package com.wjb.java.net;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * <b><code>UdpTest1</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/26 16:07.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class UdpClassDemo1 {

    @Test
    public void client() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String data = "你好";
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"), 8888);
        socket.send(packet);
        socket.close();
    }

    @Test
    public void server() throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();

    }
}
