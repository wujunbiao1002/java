package com.wjb.java.basic;

import org.junit.Test;

import java.io.*;

/**
 * <b><code>BufferIoTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/4 12:00.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class BufferIoTest {

    @Test
    public void bufferFileReadWrite() {
        BufferedReader fileReader = null;
        BufferedWriter fileWriter = null;
        File src = new File("text.txt");
        File dest = new File("text2.txt");

        try {
            fileReader = new BufferedReader(new FileReader(src));
            fileWriter = new BufferedWriter(new FileWriter(dest));
            char[] chars = new char[5];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, len);
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void bufferFileInputOutput() {
        BufferedInputStream fileReader = null;
        BufferedOutputStream fileWriter = null;
        File src = new File("pic.png");
        File dest = new File("pic2.png");

        try {
            fileReader = new BufferedInputStream(new FileInputStream(src));
            fileWriter = new BufferedOutputStream(new FileOutputStream(dest));

            byte[] bytes = new byte[5];
            int len;
            while ((len = fileReader.read(bytes)) != -1) {
                fileWriter.write(bytes, 0, len);
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
