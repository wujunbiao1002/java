package com.wjb.java.reflection;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <b><code>RefectionTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/26 18:08.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class RefectionTest {

    /**
     * 通过反射创建实例方式
     *
     * @date 2022/7/26 18:17
     **/
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        // 方式1 已知具体的类，通过类的Class属性获取，该方式最为安全可靠
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person tom = constructor.newInstance("Tom1", 10);
        System.out.println(tom.getName());
        tom.showInfo();

        // 方式2 已知某个类的实列，调用该实列的getClass()方式获取Class对象
        Person tom2 = new Person("Tom2", 11);
        Class<? extends Person> aClass = tom2.getClass();
        Constructor<? extends Person> constructor1 = aClass.getConstructor(String.class, int.class);
        Person tom2Copy = constructor1.newInstance("tom2Copy", 12);
        System.out.println(tom2Copy.getName());
        tom2Copy.showInfo();

        // 方式3 已知一个类的全类名，且该类在类路径下，可以通过Class类额静态方法forName()获取，可能抛出ClassNotFoundException
        Class<?> aClass1 = Class.forName("com.wjb.java.reflection.Person");
        Constructor<?> constructor2 = aClass1.getConstructor(String.class, int.class);
        Person tom3 = (Person) constructor2.newInstance("Tom3", 13);
        System.out.println(tom3.getName());
        tom3.showInfo();


        // 方式4 其他方式（不做要求）
        ClassLoader classLoader = RefectionTest.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("com.wjb.java.reflection.Person");
        System.out.println(aClass2);

        // 结果为true
        System.out.println(personClass == aClass);
        System.out.println(personClass == aClass1);
    }

    @Test
    public void test2() throws Exception {
        // 创建类
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person tom = constructor.newInstance("Tom1", 10);
        tom.showInfo();

        // 调用属性 public
        Field height = personClass.getField("height");
        height.set(tom, 120);
        tom.showInfo();
        // 调用方法 public
        Method showInfo = personClass.getMethod("showInfo");
        showInfo.invoke(tom);
    }

    @Test
    public void test3() throws Exception {
        // 创建类
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person tom = constructor.newInstance("Tom1");
        tom.showInfo();

        // 调用属性 private
        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(tom, 12);
        tom.showInfo();
        // 调用方法 private
        Method showSecret = personClass.getDeclaredMethod("showSecret");
        showSecret.setAccessible(true);
        showSecret.invoke(tom);
    }

    @Test
    public void test4() {
        /*
        1.不单单class有Class类，
        2.interface：接口
        3.[]：数组
        4.enum：枚举
        5.annotation：注解
        6.primitive type：基本数据类型
        7.void
         */
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
// 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

    @Test
    public void test5() throws Exception {
        ClassLoader classLoader = RefectionTest.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("com.wjb.java.reflection.Person");
        Constructor<?>[] constructors = aClass2.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.toString());
        }
    }
}
