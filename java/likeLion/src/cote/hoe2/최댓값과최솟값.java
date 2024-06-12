package cote.hoe2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 최댓값과최솟값 {
    public static String solution(String s) {
        String answer = "";

        List<Integer> temp = Arrays.stream(s.split(" ")).map(str -> Integer.valueOf(str)).collect(Collectors.toList());
        String max = String.valueOf(Collections.max(temp));
        String min = String.valueOf(Collections.min(temp));

        return min+" "+max;
    }
    public static void main(String[] args) {
        String s = "1 2 3 4";
        String s2 = "-1 -1";
        String s3 = "-1 -2 -3 -4";
        System.out.println(solution(s2));
        System.out.println(solution(s));
        System.out.println(solution(s3));



    }
}
