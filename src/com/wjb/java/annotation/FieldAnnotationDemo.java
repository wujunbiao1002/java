package com.wjb.java.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * <b><code>FieldAnnoationDemo</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/10/18 1:24.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java
 */
public class FieldAnnotationDemo {
    public static void main(String[] args) {
        Entity entity = new Entity("12345", "12", "123");
        try {
            EntityUtils.check(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class EntityUtils {
    public static void check(Object o) throws IllegalAccessException {
        Class<?> c = o.getClass();
        // 如果当前类被@Entity注解
        if (c.isAnnotationPresent(EntityCheck.class)) {
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                // 如果当前field被@FiledCheck注解
                if (field.isAnnotationPresent(FieldCheck.class)) {
                    field.setAccessible(true);
                    FieldCheck fieldCheck = field.getAnnotation(FieldCheck.class);
                    if (field.getGenericType().toString().equals("class java.lang.String")) {
                        String s = (String) field.get(o);
                        if (s != null && (s.length() < fieldCheck.min() || s.length() > fieldCheck.max())) {
                            System.out.println(fieldCheck.error());
                        }
                    }
                }
            }
        }
    }
}

@EntityCheck("Entity")
class Entity {
    @FieldCheck(min = 4, max = 10, error = "f1 not in range")
    private String field1;
    @FieldCheck(min = 8, max = 12, error = "f2 not in range")
    private String field2;
    private String field3;

    public Entity(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface FieldCheck {
    int min() default 0;

    int max() default 0;

    String error();
}

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface EntityCheck {
    String value();
}