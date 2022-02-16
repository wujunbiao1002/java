package com.wjb.java.exception;

/**
 * <b><code>ExceptionTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/11 13:59.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.10
 */
public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test(){
        String a = "asd";
        try {
            int i = Integer.parseInt(a);
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }finally {
//            return 1;
        }
        return 1;
    }
}
