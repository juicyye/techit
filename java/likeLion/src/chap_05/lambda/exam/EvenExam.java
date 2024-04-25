package chap_05.lambda.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EvenExam {
    public static void main(String[] args) {
        List<Integer> arr = List.of(123,4542,245,2345,134,6567,3546,245);
        List<Integer> arr2 = new ArrayList<>();

        Predicate<Integer> condition = a -> a % 2== 0;

        arr.forEach(a -> {
            if (condition.test(a)) {
                arr2.add(a);
            }
        });


        arr.forEach(a -> {
            if(a % 2 ==0){
                arr2.add(a);
            }
        });

        System.out.println("arr2 = " + arr2);

        arr.stream().map(i -> {
            if (i % 2 == 0) return i;
            else return null;
        }).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
