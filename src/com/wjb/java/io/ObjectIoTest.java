package com.wjb.java.io;

import com.wjb.java.classes.Person;
import org.junit.Test;

import java.io.*;

/**
 * <b><code>ObjectIoTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/4 16:14.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class ObjectIoTest {
    @Test
    public void test() throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("object.bat"));

        outputStream.writeObject(new Person(20,"小新"));
        outputStream.flush();
        outputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.bat"));
        Person o = (Person) objectInputStream.readObject();
        System.out.println(o.toString());
    }
}
