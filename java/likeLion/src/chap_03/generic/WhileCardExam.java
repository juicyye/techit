package chap_03.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WhileCardExam {
    static void print(List<? super Integer> list){
        int a = 3;
        Number b= 3;

        for (Object object : list) {
            System.out.println("object = " + object);
        }


    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Number> list2 = new ArrayList<>(Arrays.asList(1,3,4,5,6,7,9));
        print(list);
        print(list2);

    }
}
