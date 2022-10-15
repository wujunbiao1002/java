package com.wjb.java.basic;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <b><code>MapTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/2 22:19.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class MapClassDemo {
    @Test
    public void test1() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 1);
        map.put("A", 2);

        System.out.println(map.size());

        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + "" + entry.getValue());
        }
        System.out.println("------------------");
        Set<Object> keySet = map.keySet();
        for (Object o : keySet) {
            System.out.println(o);
        }
        System.out.println("------------------");
        Collection<Object> values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }

    }
}
