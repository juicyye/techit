package chap_05.lambda.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindConditionExam {
    public static void main(String[] args) {
        List<String> arr= Arrays.asList("adf","afgafgasg","xzcbxbb","af","dawe"," ","dafef");
        List<String> modiArr = new ArrayList<>();



        arr.forEach(a -> {
            if (a.length() >= 5) {
                modiArr.add(a);
            }
        });

        for (String s : modiArr) {
            System.out.println("s = " + s);
        }

        List<String> collect = arr.stream().filter(m -> m.length() >= 5).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println("s = " + s);
        }
    }
}
