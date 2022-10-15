package com.wjb.java.io;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * <b><code>FilesAndPathsTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/25 15:26.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class FilesAndPathsDemo {

    @Test
    public void test1(){
        Path path = Paths.get("text.txt");
        System.out.println(path.getFileName());
        System.out.println(path.getFileSystem());
        System.out.println(path.getParent());
    }

    @Test
    public void test2() throws IOException {
        Path path = Paths.get("text.txt");
        Files.copy(path, Paths.get("text.txt2"));
    }

    @Test
    public void test3(){
        Path path = Paths.get("text.txt");
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.exists(path));
    }

    @Test
    public void test4() throws IOException {
        Path path = Paths.get("text.txt");
        System.out.println(Arrays.toString(new List[]{Files.readAllLines(path)}));
    }
}
