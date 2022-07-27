package com.wjb.java.net;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <b><code>UrlTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/26 16:29.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class UrlTest {

    @Test
    public void test() throws IOException {

        URL url = new URL("https://img03.sogoucdn.com/app/a/100520093/d71a6360ba8601ff-07d87d56d0ad1ec6-af67799e651c19123d91f0d857352aef.jpg");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = new byte[2];
        int len;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        Path path = Paths.get("p.jpg");
        Files.write(path, byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
        inputStream.close();
    }
}

