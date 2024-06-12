package cote.hoe2;

import java.util.Arrays;

public class 햄버거만들기 {
    public static int solution(int[] ingredient) {
        int answer = 0;
        for (int i = 1; i <= ingredient.length; i++) {
            if (i == 6) {
                System.out.println("hi");
            } else if (i == ingredient.length) {
                System.out.println("heu");
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        // 빵-야채-고기 -빵 순서로 쌓인 햄버거만 포장
        // 순서대로 1,2,3 임
        // 여섯번째 재료가 쌓였을때 3~6 재료를 이용하여 햄버거를 포장하고
        // 9번째 재료가 쌓였을때 2,7~9를 이용하여 햄버거를 포장
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        System.out.println("Arrays.toString(solution(ingredient)) = " + solution(ingredient));

    }
}
