package cote.hoe2;

import java.util.*;

public class 최빈값구하기 {
    public static int solution(int[] array) {
        int max = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();


        for (int index : array) {
            map.put(index, map.getOrDefault(index, 0) + 1);
        }

        HashSet<Integer> key = new HashSet<>(map.keySet());

        for (Integer integer : key) {
            if (map.get(integer) > max) {
                max = map.get(integer);
                answer = integer;
            }
        }

        for (Integer integer : key) {
            if (answer != integer && map.get(integer) == max) {
                return -1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4};
        System.out.println("solution(array) = " + solution(array));

    }
}
