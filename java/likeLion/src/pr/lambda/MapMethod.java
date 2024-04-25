package pr.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapMethod {
    public static void main(String[] args) {

        List<Integer> arr = List.of(1,35,2436,65,3456,423,552,765,75,7645,2345);
        List<String> arr2 = Arrays.asList("하이", "방가방가", "니니", "후후", "하하");
        Map<Integer, String> map = new HashMap<>();

        IntStream.range(0, arr.size())
                .boxed()
                .collect(Collectors.toMap(arr::get, i -> i));

        Map<Integer, Integer> collect = arr.stream().collect(Collectors.toMap(arr::get, i -> i));


        IntStream.range(0, Math.min(arr.size(), arr2.size()))
                .forEach(i -> map.put(arr.get(i), arr2.get(i)));


        map.forEach((k,v) -> System.out.println("Key: " + k + " Value: " + v));


    }
}
