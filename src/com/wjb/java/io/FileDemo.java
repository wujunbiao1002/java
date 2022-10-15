package com.wjb.java.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * <b><code>FileTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/3 15:40.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        System.out.println(File.separator);
        File file = new File("C:\\Users\\村镇\\Desktop\\1.txt");
//        File file = new File("C:\\Users\\村镇\\Desktop");

        System.out.println(file.getName());
        System.out.println(file.getParentFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getTotalSpace());
        System.out.println(file.getUsableSpace());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getName());
        }
    }

    @Test
    public void test2() throws IOException {
        File file = new File("C:\\Users\\村镇\\Desktop");
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getName());
        }
    }

    @Test
    public void test3() throws IOException {
        File file = new File("C:\\Users\\村镇\\Desktop\\1\\2");
        File file2 = new File("C:\\Users\\村镇\\Desktop\\2.txt");
        File file3 = new File("C:\\Users\\村镇\\Desktop\\1\\2\\3.txt");
        System.out.println(file.mkdirs());
        System.out.println(file2.createNewFile());
        file2.renameTo(file3);
    }
}
