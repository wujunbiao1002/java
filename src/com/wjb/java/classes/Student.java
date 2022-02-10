package com.wjb.java.classes;

/**
 * <b><code>Student</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/7 15:25.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class Student extends Person {
    private String school;
    private String ctiy;

    public Student(){}

    public Student(String school) {
        super();
        this.school = school;
    }

    public Student(int age, String name, String school) {
        super(age, name);
        this.school = school;
    }

    @Override
    public void add(int a, int[] b){
        System.out.println("子类1");
    }

    public void add(int a, int b, int c){
        System.out.println("子类2");
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public Student eat() {
        System.out.println("student吃饭");
        return null;
    }
}
