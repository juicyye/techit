package chap_05.lambda.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class RambdaExam4 {
    public static void main(String[] args) {
        // 임의 객체의 메서드 참조
        List<String> list = Arrays.asList("hello", "world", "java", "spring");
        List<Integer> lengths = new ArrayList<>();

        Function<String, Integer> lengthFunc = String::length;

        for (String s : list) {
            lengths.add(lengthFunc.apply(s));
        }
        System.out.println("lengths = " + lengths);

        // 생성자 참조
        Supplier<List<String>> listSupplier = ArrayList::new;

        List<String> list2 = listSupplier.get();
        list2.add("hello");
        list2.add("world");
        list2.add("java");

        System.out.println("list2 = " + list2);
    }
}
