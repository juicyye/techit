package cote;

import java.util.*;

public class 프로세스 {

    static class Process {
        int priority;
        int index;

        public Process(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();

        // 프로세스를 큐에 추가
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(priorities[i], i));
        }

        while (!queue.isEmpty()) {
            Process current = queue.poll();
            boolean isBig = false;


            for (Process process : queue) { // 우선순위가 더 높은게 있는지 확인
                if (process.priority > current.priority) {
                    isBig = true;
                    break;
                }
            }

            if (isBig) { // 우선순위가 더 높은 프로세스가 있으면 다시 큐 추가
                queue.add(current);
            } else {
                answer++;
                if (current.index == location) {
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] priorites = {2, 1, 3, 2};
        int location = 2;

        int[] priorites2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        System.out.println(solution(priorites, location));
        System.out.println(solution(priorites2, location2));

    }
}
