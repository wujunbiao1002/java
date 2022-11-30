package com.wjb.java.reflection;

import com.wjb.java.reflection.element.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <b><code>OthierTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/27 12:05.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java
 */
public class OtherClassDemo {
    /**
     * 获取构造器
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    @Test
    public void test1() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.wjb.java.reflection.element.Person");
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("----");
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }

    /**
     * 获取运行时类的父类
     */
    @Test
    public void test2() {
        Class<com.wjb.java.reflection.element.Person> personClass = com.wjb.java.reflection.element.Person.class;
        Class<? super com.wjb.java.reflection.element.Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);

        Method[] methods = superclass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }


    /**
     * 获取运行时类的带泛型的父类
     */
    @Test
    public void test3() {
        Class clazz = com.wjb.java.reflection.element.Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /**
     * 获取运行时类的带泛型的父类的泛型类型
     * 代码：逻辑性代码  vs 功能性代码
     */
    @Test
    public void test4() {
        Class clazz = com.wjb.java.reflection.element.Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class) actualTypeArguments[0]).getName());
    }

    /**
     * 获取运行时类实现的接口
     */
    @Test
    public void test5() {
        Class clazz = com.wjb.java.reflection.element.Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c : interfaces1) {
            System.out.println(c);
        }
    }

    /**
     * 获取运行时类所在的包
     */
    @Test
    public void test6() {
        Class clazz = com.wjb.java.reflection.element.Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /**
     * 获取运行时类声明的注解
     */
    @Test
    public void test7() {
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annos : annotations) {
            System.out.println(annos);
        }
    }
}
