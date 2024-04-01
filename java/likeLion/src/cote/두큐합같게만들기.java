package cote;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    static  int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long total = 0;
        long sum = 0; // 한곳만 타겟이면 가능

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            total += queue1[i] + queue2[i];
            sum += queue1[i];
            que1.add(queue1[i]);
            que2.add(queue2[i]);
        }

        // 두 큐의 합이 홀수이면 같아지도록 만들 수 없음
        if (total % 2 != 0) return -1;

        long target = total / 2;

        // 두 큐의 합이 같아질 때까지 작업을 수행
        while (sum != target) {
            // 한바퀴 돌아도 안되면 안됨
            if (answer > queue1.length * 4) return -1;

            // 큐1의 합이 목표 값보다 크면 큐1에서 원소를 추출하여 큐2에 삽입
            if (sum > target) {
                sum -= que1.peek();
                que2.add(que1.poll());
            } else { // 큐1의 합이 목표 값보다 작으면 큐2에서 원소를 추출하여 큐1에 삽입
                sum += que2.peek();
                que1.add(que2.poll());
            }
            answer++;
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 7, 2};
        int[] arr2 = {4, 6, 5, 1};

        int[] arr3 = {1, 2, 1, 2};
        int[] arr4 = {1, 10, 1, 2};

        System.out.println("solution(arr1,arr2) = " + solution(arr1, arr2));
        System.out.println("solution(arr1,arr2) = " + solution(arr3, arr4));

    }
}
