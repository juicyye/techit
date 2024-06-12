package cote;


import java.util.*;


public class 최고의집합 {
    static int[] solution(int n, int s) {
        // s를 n으로 나눴을 때 몫이 0보다 작거나 같으면 불가능한 경우이므로 -1을 반환
        if (s / n <= 0) {
            return new int[]{-1};
        }

        // 결과를 담을 배열
        int[] answer = new int[n];

        // 일단 평균 값을 모든 원소에 할당
        Arrays.fill(answer, s / n);

        // 나머지 값을 앞쪽 원소들에 더해주기
        for (int i = n - 1; i >= n - (s % n); i--) {
            answer[i]++;
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(2, 9)[0]);
        System.out.println(solution(2, 9)[1]);
        System.out.println(solution2(2, 9));

        System.out.println(solution(2, 1)[0]);

    }

    public static ArrayList<Integer> solution2(int n, int s) {
        // s를 n으로 나눴을 때 몫이 0보다 작거나 같으면 불가능한 경우이므로 -1을 반환
        if (s / n <= 0) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(-1);
            return result;
        }

        // 결과를 담을 배열
        ArrayList<Integer> answer = new ArrayList<>();

        // 일단 평균 값을 모든 원소에 할당
        int average = s / n;
        for (int i = 0; i < n; i++) {
            answer.add(average);
        }

        // 나머지 값을 앞쪽 원소들에 더해주기
        int remainder = s % n;
        for (int i = 0; i < remainder; i++) {
            answer.set(i, answer.get(i) + 1);
        }

        return answer;
    }
}
