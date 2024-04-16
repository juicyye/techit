package chap_03.generic.balpyo;

import java.util.ArrayList;
import java.util.List;

public class Etc {
    // List<? extends Number>를 매개변수로 받아들이는 제네릭 메서드
    public static void printNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }

    // 제네릭 이용
    public static <T extends Number> double sumOfList(List<T> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    // 클래스에서 상한
    public class NumberContainer<T extends Number> {
        private T number;

        public NumberContainer(T number) {
            this.number = number;
        }

        public static void main(String[] args) {

        }
    }

    public static void main(String[] args) {
        List<Number> amber = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();

        amber.add(1);
        sumOfList(amber);

    }
}
