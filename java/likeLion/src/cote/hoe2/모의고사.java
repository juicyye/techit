package cote.hoe2;

import java.util.*;
import java.util.stream.Collectors;

public class 모의고사 {

    public static int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] p1= {1,2,3,4,5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == p1[i%p1.length]) answer[0]++;
            if(answers[i] == p2[i%p2.length]) answer[1]++;
            if(answers[i] == p3[i%p3.length]) answer[2]++;
        }


        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (answer[i] == max) {
                temp.add(i + 1);
            }
        }


        // List를 int[] 배열로 변환
        int[] result = temp.stream().mapToInt(i -> i).toArray();

        return result;
    }


    public static void main(String[] args) {
        int[] answer1 = {1,2,3,4,5};
        int[] answer2= {1,3,2,4,2};

        System.out.println(Arrays.toString(solution(answer1))); // [1]

    }
}
