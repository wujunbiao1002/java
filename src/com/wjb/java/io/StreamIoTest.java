package com.wjb.java.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <b><code>StreamIoTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/4 11:37.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class StreamIoTest {
    @Test
    public void fileInputOutputStream() {

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            File src = new File("pic.png");
            File dest = new File("pic2.png");
            inputStream = new FileInputStream(src);
            outputStream = new FileOutputStream(dest);

            byte[] bytes = new byte[5];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
