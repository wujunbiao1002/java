package com.wjb.java.net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <b><code>TcpTest2</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/26 15:40.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class TcpClassDemo2 {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File("pic.png"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.close();
        fileInputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;

        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes,0,len);
        }
        Path path = Paths.get("p.png");
        Files.write(path, byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
        inputStream.close();
        serverSocket.close();
    }
}
