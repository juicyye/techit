package pr.lambda;

import java.util.List;

interface Inter{
    int method1(int a, int b);
}
public class 생략 {
    public static void main(String[] args) {

        Inter inter = new Inter() {
            @Override
            public int method1(int a, int b) {
                return a + b;
            }
        };

        Inter inter2 = (int a, int b) -> {
            return a + b;
        };

        Inter inter3 = (a, b) -> a + b;

        List<Integer> list = List.of(234, 224, 312, 3454, 55, 66, 377, 18, 49, 10);

        list.forEach((Integer i) -> {
            System.out.println("i = " + i);
        });

        list.forEach( i -> System.out.println("a = " + i));

        list.forEach(System.out::println);




    }
}
