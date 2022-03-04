package com.wjb.java.basic;

import java.lang.annotation.*;

/**
 * <b><code>MyAnnotation</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/23 23:02.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

@MyAnnotation(value = "展示人口1")
@MyAnnotation(value = "展示人口2")
class Person {
    private String name;

    Person() {
    }

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("show");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

@Target(ElementType.TYPE)
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value() default "MyAnnotation";
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotations {
    MyAnnotation[] value();
}