package chap_05.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RambdaExam2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });


        names.sort((s1,s2) -> s1.compareTo(s2));

        for (String name : names) {
            System.out.println("name = " + name);
        }

    }
}
