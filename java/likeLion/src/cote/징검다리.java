package cote;

import java.util.*;

public class 징검다리 {
    static class Data {
        private int index;
        private int value;

        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }

    // 배열에서 주어진 조건에 따라 최대값을 찾고 이전 최대값과 비교하여 조건에 따라 진행하는 함수
    public int solution(int[] stones, int k) {
        int answer = 0;
        int max = stones[0];
        Data data = new Data(0, stones[0]);

        for (int j = 0; j < k; j++) {
            if (stones[j] > max) {
                max = stones[j];
                data = new Data(j, stones[j]);
            }
        }

        for (int i = data.getIndex(); i <= stones.length - k; i += k) {

            Data findAnswer = findMax(stones, i, k, data);
            if (findAnswer.getValue() == -1) {

            }
            i = findAnswer.getIndex();

        }

        return answer;
    }

    // 배열에서 주어진 범위 내의 최대 값을 찾는 함수
    public Data findMax(int[] arr, int start, int k, Data data) {
        Data temp = new Data(start + 1, arr[start + 1]);
        int max = arr[start + 1];

        for (int i = start + 1; i <= start + k; i++) {
            if (arr[i] > max) {
                max = arr[i];
                temp = new Data(i, arr[i]);
            }
        }
        if (data.getValue() > temp.getValue()) {
            data = new Data(start, -1);
            return data;
        } else {
            return temp;
        }

    }

    public static void main(String[] args) {
        징검다리 solution = new 징검다리();
        int stones[] = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        System.out.println(solution.solution(stones, 3));
    }

}
