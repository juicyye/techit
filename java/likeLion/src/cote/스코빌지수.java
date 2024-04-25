package cote;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 스코빌지수 {
    public static int solution(int[] scoville, int k) {
        int answer = 0;
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        // 모든 음식이 스코빌 지수가 k 이상이 될때까지 섞는다
        // 모든 음식의 스코빌 지수를 k 이상 만들기 위해 섞어야 하는 최소 횟수 return

        // 우선순위 큐를 이용하여 스코빌 지수를 오름차순으로 정렬
        Queue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) {
            queue.offer(s);
        }

        // 가장 맵지 않은 음식의 스코빌 지수가 K 미만이면 반복하여 섞음
        while (queue.peek() < k) {
            // 가장 맵지 않은 두 음식을 꺼내어 섞음
            int first = queue.poll();
            if (queue.isEmpty()) { // 스코빌 지수가 K 이상인 음식이 없는 경우
                return -1;
            }
            int second = queue.poll();

            int newScoville = first + (second * 2); // 새로운 음식의 스코빌 지수 계산
            queue.offer(newScoville); // 섞은 음식을 큐에 넣음
            answer++; // 섞은 횟수 증가
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution(scoville, k));

    }
}
