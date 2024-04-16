package chap_03.generic.balpyo;

import java.util.List;

public class GenericMain {
    public static <T extends Number> double calculateSum(List<T> list) {
        double sum = 0.0;
        for (T num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        double sumInt = calculateSum(intList);
        System.out.println("정수형 리스트의 합: " + sumInt);

        List<Double> doubleList = List.of(1.1, 2.2, 3.3, 4.4, 5.5);
        double sumDouble = calculateSum(doubleList);
        System.out.println("실수형 리스트의 합: " + sumDouble);
    }
}
