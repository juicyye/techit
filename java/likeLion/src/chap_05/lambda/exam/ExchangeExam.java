package chap_05.lambda.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExchangeExam {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(12,52,622,421,34,21,5,2245);
        List<Integer> modiArr = new ArrayList<>();



        arr.forEach(a -> modiArr.add(a*a));
        for (Integer i : modiArr) {
            System.out.println("i = " + i);
        }

        List<Integer> collect = arr.stream().map(i -> i * i).collect(Collectors.toList());
        for (Integer i : collect) {
            System.out.println("a = " + i);
        }
    }
}
