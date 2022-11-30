package com.wjb.java.oom;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GCDemo {

    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "mogu blog";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}

