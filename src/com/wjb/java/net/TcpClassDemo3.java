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
 * <b><code>TcpTest3</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/26 15:52.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class TcpClassDemo3 {

    @Test
    public void clinet() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
        // 发送数据
        OutputStream os = socket.getOutputStream();
        os.write("你好美女".getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();

        // 接受回复
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0 , len);
        }
        System.out.println(byteArrayOutputStream);

        inputStream.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();

        // 接受数据
        InputStream inputStream = accept.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        System.out.println(byteArrayOutputStream.toString());

        // 进行回复
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("你好帅哥".getBytes(StandardCharsets.UTF_8));

        byteArrayOutputStream.close();
        inputStream.close();
        serverSocket.close();
    }
}
