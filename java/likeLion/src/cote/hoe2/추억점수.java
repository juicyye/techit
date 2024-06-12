package cote.hoe2;

import java.util.*;
import java.util.stream.Collectors;

public class 추억점수 {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answerTemp = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            int temp =0;
            for (int j = 0; j < photo[i].length; j++) {
                if(map.get(photo[i][j]) != null) {
                    temp += map.get(photo[i][j]);
                }

            }
            answerTemp.add(temp);
        }
        return answerTemp.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        // 사진별로 추억 점수 매기기
        // 사진속에 나오는 인물의 그리움 점수를 모두 합산한 값이 추억점수
        // ["may", "kein", "kain"]이고 각 인물의 그리움 점수가 [5점, 10점, 1점]일 때 해당 사진의 추억 점수는 16(5 + 10 + 1)


        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};


        System.out.println("Arrays.toString(solution(name,yearning)) = " + Arrays.toString(solution(name, yearning,photo)));


    }
}
