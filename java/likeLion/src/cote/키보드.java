package cote;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] keypad = {
                {3, 1}, // 0
                {0, 0}, // 1
                {0, 1}, // 2
                {0, 2}, // 3
                {1, 0}, // 4
                {1, 1}, // 5
                {1, 2}, // 6
                {2, 0},
                {2, 1},
                {2, 2}
        };



        int[] leftHand = {3, 0}; // 왼손의 초기 위치 (* 키패드)
        int[] rightHand = {3, 2}; // 오른손의 초기 위치 (# 키패드)


        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                leftHand = keypad[number]; //
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                rightHand = keypad[number];
            } else {
                //
                int leftDistance = Math.abs(leftHand[0] - keypad[number][0]) + Math.abs(leftHand[1] - keypad[number][1]);
                int rightDistance = Math.abs(rightHand[0] - keypad[number][0]) + Math.abs(rightHand[1] - keypad[number][1]);

                if (leftDistance < rightDistance || (leftDistance == rightDistance && hand.equals("left"))) {
                    answer.append("L");
                    leftHand = keypad[number];
                } else {
                    answer.append("R");
                    rightHand = keypad[number];
                }
            }
        }

        return answer.toString();
    }
}

public class 키보드 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(solution.solution(numbers1, "right")); // "LRLLLRLLRRL"
        System.out.println(solution.solution(numbers2, "left")); // "LRLLRRLLLRR"
        System.out.println(solution.solution(numbers3, "right")); // "LLRLLRLLRL"
    }
}
