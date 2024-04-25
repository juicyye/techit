package pr.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(23,423,5,6,54367,7,25,5423,6,546);

        arr.stream().sorted((a,b)-> Integer.compare(b,a))
                .forEach(System.out::println);

        arr.stream().sorted(Integer::compareTo)
                .forEach(System.out::println);


    }
}
