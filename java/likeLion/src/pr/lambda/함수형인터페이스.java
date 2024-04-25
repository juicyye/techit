package pr.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class 함수형인터페이스 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1; // 랜덤값을 공급
        Consumer<Integer> c = i -> System.out.print(i + ","); // 주어진 값을 출력
        Predicate<Integer> p = i -> i % 2 == 0; // 짝수인지 확인
        Function<Integer, Integer> f = i -> i * 2; // i -> i *2로 변경
        BiFunction<String,Integer, Data> f2 = (a,b) -> new Data(a,b);
        BiFunction<String,Integer, Data> f3 = Data::new;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        printEvenNum(p,c,list);
        CheckBooleanList(s,p,list);

    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if(p.test(i)) {
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    private static <T> void CheckBooleanList(Supplier<T> s, Predicate<Integer> p, List<T> list) {
        for (int i = 0; i < 50; i++) {
            if (p.test(i)) {
                list.add(s.get());
            }
        }

    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
