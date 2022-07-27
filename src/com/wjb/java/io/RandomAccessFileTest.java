package com.wjb.java.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * <b><code>RandomAccessFileTest</code></b>
 * <p/>
 * Description
 * RandomAccessFile 类支持 “随机访问” 的方式，程序可以直接跳到文件的任意
 * 地方来读、写文件
 * 支持只访问文件的部分内容
 * 可以向已存在的文件后追加内容
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
        // seek随机获取文件位置
        randomAccessFile.seek(1);
        // 获取当前文件的记录指针位置
        long filePointer = randomAccessFile.getFilePointer();
        byte[] bytes = new byte[1024];
        int off = 0;
        int len = 6;
        randomAccessFile.read(bytes, off, len);
        String s = new String(bytes, 0, len);
        System.out.println(s);
        randomAccessFile.close();
    }
}
