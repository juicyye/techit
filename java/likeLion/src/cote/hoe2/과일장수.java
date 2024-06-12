package cote.hoe2;

import java.util.Arrays;
import java.util.Collections;

public class 과일장수 {
    public static int solution(int k, int m, int[] score) {
        Integer[] scoreArr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreArr, Collections.reverseOrder());

        int answer = 0;
        // m개씩 묶어서 계산
        for (int i = 0; i + m <= scoreArr.length; i += m) {
            //
            answer += scoreArr[i + m - 1] * m;
        }
        return answer;
    }
    public static void main(String[] args) {
        // 사과 상태에 따라 1 ~k 점수로 분류
        // k점이 최상품 사과
        // 한상자에 사과를 m개식 담아 포장
        // 한 사장에 담은 가장 낮은 점수가 p라고 한다면 한 상자의 가격은 p * m
        // 가능한 많은 사과를 팔았을떄 얻을수있는 최대 이익

        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};  // 1,1,1,2,2,3,3

        System.out.println("solution(k,m,score) = " + solution(k, m, score));

    }
}
