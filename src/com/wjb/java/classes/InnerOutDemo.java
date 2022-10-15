package com.wjb.java.classes;

/**
 * <b><code>InnerOut</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/10 21:04.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class InnerOutDemo {

    public static void main(String[] args) {
        P p = new P();
        Inter display = p.display();
        display.show();
        p.show();
//        P.Dog dog = new P.Dog();
//        dog.show();
//        P.Bird bird = p.new Bird();
//        bird.fly();
//        bird.show();
    }
}

interface Inter {
    void show();
}

class P {
    String name = "Pname";
    static String name2 = "name2";
    Inter inter;

    {
//        class T implements Inter {
//            @Override
//            public void show() {
//                System.out.println("T");
//            }
//        }
//        inter = new T();
        inter = new Inter() {
            @Override
            public void show() {
                System.out.println("T");
            }
        };
    }

    public void show() {
        inter.show();
    }

    public Inter display() {
        final int i = 1;
//        class Te implements Inter {
//            @Override
//            public void show() {
//                System.out.println("T");
//            }
//        }
//        return new Te();
        return new Inter() {
            @Override
            public void show() {
                System.out.println(i);
            }
        };
    }

    static class Dog {
        public void show() {
            System.out.println("dog");
            System.out.println(name2);
        }
    }

    class Bird {
        String name = "Birdname";

        public void fly() {
            System.out.println("fly");
        }

        public void show() {
            System.out.println("Bird");
            System.out.println(P.this.name);
            System.out.println(name);
            P.this.show();
        }


    }
}
