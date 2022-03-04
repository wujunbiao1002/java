package com.wjb.java.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <b><code>IOTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/3 16:41.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class FileIoTest {
    @Test
    public void fileReader() {
        FileReader fileReader = null;
        try {
            File file = new File("text.txt");
            fileReader = new FileReader(file);

            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null : "文件未找到";
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fileReader2() {
        FileReader fileReader = null;
        try {
            File file = new File("text.txt");
            fileReader = new FileReader(file);
            char[] chars = new char[5];

            int len;
            while ((len = fileReader.read(chars)) != -1) {
                // 方式1
/*                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                }*/

                // 方式2
                System.out.print(new String(chars, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null : "文件未找到";
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fileWrite() {
        FileWriter fileWriter = null;

        File file = new File("text2.txt");
        try {
//            fileWriter = new FileWriter(file, true);
            fileWriter = new FileWriter(file);
            fileWriter.write("测试一下123456");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void fileReadWrite() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        File fileSrc = new File("text.txt");
        File fileDest = new File("text2.txt");
        try {
            fileReader = new FileReader(fileSrc);
            fileWriter = new FileWriter(fileDest, true);

            char[] chars = new char[5];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                fileWriter.write(new String(chars, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
