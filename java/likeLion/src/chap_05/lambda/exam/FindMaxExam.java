package chap_05.lambda.exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMaxExam {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5,2435,6534,22,543,36,6475,8,657,5634,345);

        Collections.sort(arr,(a,b) -> Integer.compare(b,a));
        System.out.println("최대 값: " + arr.get(0));
    }
}
