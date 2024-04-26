package cote;

import java.util.*;

public class 신입사원교육 {
    static int solution(int[] ability, int number) {
        int answer= 0;
        Queue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(ability).forEach(queue::add);

        for (int i = 0; i < number; i++) {
            Integer first = queue.poll();
            Integer second = queue.poll();
            int temp = first + second;
            queue.offer(temp);
            queue.offer(temp);
        }
        Optional<Integer> reduce = queue.stream().reduce((a, b) -> a + b);
        answer = reduce.orElse(0);
        return answer;
    }
    public static void main(String[] args) {
        int[] ability = {10, 3, 7, 2};
        int number = 2;

        System.out.println(solution(ability, number));

    }
}
