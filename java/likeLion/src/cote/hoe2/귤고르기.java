package cote.hoe2;

import java.util.*;

public class 귤고르기 {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        int temp =0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }


        List<Integer> arr = new ArrayList<>(map.values());
        arr.sort(Collections.reverseOrder());

        for (int a : arr) {
            temp += a;
            answer++;
            if (temp >= k) {
                break;
            }
        }

        return answer;
}

public static void main(String[] args) {
    // 귤 중에 k개 골라 판매
    // 서로 다른 종류가 최소일때를 찾아라
    int k = 6;
    int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
    System.out.println(solution(k, tangerine));

}
}
