package pr.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class 생성자메서드참조 {
    public static void main(String[] args) {

        Function<String, Integer> f = (String s) -> Integer.parseInt(s);

        Function<String, Integer> f1 = Integer::parseInt;

        Function<Integer, Data> f3 = i -> new Data(i);
        Function<Integer, Data> f2 = Data::new;

        Supplier<Data> s1 = () -> new Data();
        Supplier<Data> s = Data::new;


    }
}
