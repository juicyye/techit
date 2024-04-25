package chap_05.lambda.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusExam {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(453,235,24,1234,2456,7534,6345,243,2,1);
        List<Integer> modiArr = new ArrayList<>();

        arr.forEach(a -> modiArr.add(a+10));

        for (Integer i : modiArr) {
            System.out.println("i = " + i);
        }

        List<Integer> list = arr.stream().map(a -> a + 10).toList();
        for (Integer i : list) {
            System.out.println("i = " + i);
        }
    }
}
