package chap_05.lambda.ex2;

import java.util.Arrays;
import java.util.List;

public class ForEachExam {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("하이", "방가방가", "뉴뉴", "이히", "하하");

        list.forEach(a -> System.out.println(a));
    }
}
