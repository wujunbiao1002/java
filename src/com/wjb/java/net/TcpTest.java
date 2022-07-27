package com.wjb.java.net;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * <b><code>TcpTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/26 15:22.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class TcpTest {

    @Test
    public void client() throws IOException {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.01");
        Socket socket = new Socket(inetAddress, 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好你是客户端？".getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            stream.write(bytes, 0, len);
        }
        System.out.println(stream.toString());
        stream.close();
    }
}
