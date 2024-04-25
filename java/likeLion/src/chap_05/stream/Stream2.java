package chap_05.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Stream2 {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,45,24,2,542,65,6534,234,5,6,542);

        Optional<Integer> reduce = arr.stream().reduce(Integer::max);

        reduce.ifPresent(System.out::println);
    }
}
