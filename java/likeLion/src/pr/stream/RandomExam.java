package pr.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomExam {
    public static void main(String[] args) {
        IntStream ints = new Random().ints(10,5,10);
        IntStream range = IntStream.range(1, 5);

        Stream<Double> generate = Stream.generate(Math::random);
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);


        ints.forEach(System.out::println);
    }
}
