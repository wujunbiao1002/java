package com.wjb.java.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * <b><code>RandomAccessFileTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/6/10 15:48.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class RandomAccessFileTest {

    @Test
    public void test() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("text.txt"),"r");
        randomAccessFile.seek(1);
        byte[] bytes = new byte[1024];
        int off = 0;
        int len = 6;
        randomAccessFile.read(bytes, off, len);
        String s = new String(bytes, 0, len);
        System.out.println(s);
        randomAccessFile.close();
    }
}
