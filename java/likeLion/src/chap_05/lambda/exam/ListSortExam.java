package chap_05.lambda.exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSortExam {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("hello", "spring", "java", "isverygood", "language");
        Collections.sort(arr, (a, b) -> Integer.compare(b.length(), a.length()));

        for (String s : arr) {
            System.out.println("s = " + s);
        }
    }
}
