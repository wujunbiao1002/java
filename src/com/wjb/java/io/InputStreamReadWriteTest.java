package com.wjb.java.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * <b><code>InputStreamReadTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/4 14:51.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class InputStreamReadWriteTest {

    @Test
    public void inputStreamReadWrite() throws IOException {

//        InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream("text.txt")));
        InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream("text.txt")), StandardCharsets.UTF_8);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("text2.txt")), "GBK");

        char[] chars = new char[5];
        int len;


        while ((len = inputStreamReader.read(chars)) != -1){
            System.out.print(new String(chars,0,len));
            outputStreamWriter.write(chars,0,len);
        }
        outputStreamWriter.flush();
        inputStreamReader.close();
        outputStreamWriter.close();
    }
}
