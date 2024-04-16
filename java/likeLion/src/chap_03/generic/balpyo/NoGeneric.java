package chap_03.generic.balpyo;

import java.util.ArrayList;
import java.util.List;

public class NoGeneric {
    // 정수형 리스트의 합을 구하는 메서드
    public static int calculateSumInt(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    // 실수형 리스트의 합을 구하는 메서드
    public static double calculateSumDouble(List<Double> list) {
        double sum = 0.0;
        for (double num : list) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        int sumInt = calculateSumInt(intList);
        System.out.println("정수형 리스트의 합: " + sumInt);

        List<Double> doubleList = List.of(1.1, 2.2, 3.3, 4.4, 5.5);
        double sumDouble = calculateSumDouble(doubleList);
        System.out.println("실수형 리스트의 합: " + sumDouble);
    }
}
