package chap_05.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RambdaExam1 {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("a", "B", "c", "D", "e", "F", "g", "H", "i", "J");

        items.forEach(a -> System.out.println("a = " + a));


        Consumer<String> rambdaTest = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> test = ((s) -> {
            System.out.println("하이하이");
        });

        Consumer<String> test1 = s -> System.out.println("s = " + s);

        new Thread(() ->{
            System.out.println("test1 = " + test1);
        }).start();
    }
}
