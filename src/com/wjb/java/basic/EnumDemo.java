package com.wjb.java.basic;

/**
 * <b><code>EnumTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/23 21:32.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class EnumDemo {
    public static void main(String[] args) {

        for (SeasonEnum value : SeasonEnum.values()) {
            System.out.println(value.getName());
        }

        SeasonEnum.SPRING.show();
        SeasonEnum.SUMMER.show();
        SeasonEnum.AUTUMN.show();
        SeasonEnum.WINTER.show();
    }
}

interface Info {
    void show();
}

enum SeasonEnum implements Info {
    SPRING("春天", 1) {
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", 2) {
        @Override
        public void show() {
            System.out.println("夏天在哪里");
        }
    },
    AUTUMN("秋天", 3) {
        @Override
        public void show() {
            System.out.println("秋天在哪里");
        }
    },
    WINTER("冬天", 4) {
        @Override
        public void show() {
            System.out.println("冬天在哪里");
        }
    };

    private final String name;
    private final int code;

    SeasonEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
