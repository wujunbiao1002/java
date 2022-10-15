package com.wjb.java.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <b><code>StreamTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/7/27 16:02.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java
 */
public class StreamClassDemo {
    // 创建对象
    @Test
    public void test() {

        // 1.通过集合
        ArrayList<String> strings = new ArrayList<>();
        // 顺序流
        Stream<String> stream = strings.stream();
        // 并行流
        Stream<String> stringStream = strings.parallelStream();


        // 2.通过数组
        int[] ints = new int[5];
        IntStream stream1 = Arrays.stream(ints);


        // 3.通过Stream.of
        Stream<int[]> stream2 = Stream.of(new int[5]);

        // 4.创建无限流
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
        stream3.limit(10).forEach(System.out::println);

        Stream<Double> stream4 = Stream.generate(Math::random);
        stream4.limit(10).forEach(System.out::println);
    }

    @Test
    public void test2() {
        int[] ints = {5, 2, 3, 6, 4, 6};

        IntStream stream = Arrays.stream(ints);
        // filter接收Lambda ，从流中排除某些元素
        stream.filter(e -> e > 5).forEach(System.out::print);
        System.out.println();

        // limit断流，使其元素不超过给定数量
        Arrays.stream(ints).limit(2).forEach(System.out::print);
        System.out.println();

        // skip 跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit互补
        Arrays.stream(ints).skip(2).forEach(System.out::print);
        System.out.println();

        // distinct筛选，通过所生成元素的hashCode()和equals()去除重复的元素
        Arrays.stream(ints).distinct().forEach(System.out::print);
        System.out.println();
    }

    @Test
    public void test3() {
        ArrayList<String> list = new ArrayList<String>() {{
            add("aa");
            add("bb");
            add("cc");
        }};

        ArrayList<String> list2 = new ArrayList<String>() {{
            add("ee");
            add("ff");
            add("gg");
        }};
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println();
        Stream<Stream<Character>> streamStream = list.stream().map(this::fromStringToStream);
        streamStream.forEach(e -> e.forEach(System.out::println));

        System.out.println();
        Stream<Character> characterStream = list.stream().flatMap(this::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    public Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test4() {
        int[] ins = {5, 6, 9, 4, 1, 58};

        IntStream stream = Arrays.stream(ins);
        Arrays.stream(ins).sorted().forEach(System.out::println);

        System.out.println("------------");
        long count = Arrays.stream(ins).filter(e -> e > 5).count();
        System.out.println(count);

        System.out.println("------------");
        OptionalInt first = Arrays.stream(ins).findFirst();
        System.out.println(first.getAsInt());

        System.out.println("------------");
        OptionalInt first1 = Arrays.stream(ins).findAny();
        System.out.println(first1.getAsInt());

        System.out.println("------------");
        OptionalInt max = Arrays.stream(ins).max();
        System.out.println(max.getAsInt());

        System.out.println("------------");
        OptionalInt min = Arrays.stream(ins).min();
        System.out.println(min.getAsInt());
    }

    @Test
    public void test5(){
        Integer[] ins = {5, 6, 9, 4, 1, 58};
        Integer reduce = Arrays.stream(ins).reduce(10, Integer::sum);
        System.out.println(reduce);

        Optional<Integer> reduce2 = Arrays.stream(ins).reduce(Integer::sum);
        System.out.println(reduce2);
    }
    @Test
    public void test6(){
        Integer[] ins = {5, 6, 9, 4, 1, 58};
        List<Integer> collect = Arrays.stream(ins).sorted().collect(Collectors.toList());
        for (Integer integer : collect) {
            System.out.println(integer);
        }
    }
}
