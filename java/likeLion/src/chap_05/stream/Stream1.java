package chap_05.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");


        // 글자수가 5이상인 것만 필터링하고, 중복은 제거해서 새로운 리스트로 받아온다
        Predicate<String> p = a -> a.length() >= 5;
        List<String> list = words.stream().filter(p)
                .distinct().toList();

        words.stream().map(m -> m+10).peek(System.out::println)
                .map(m -> m+"hi")
                        .forEach(System.out::println);

        list.forEach(System.out::println);

    }
}
