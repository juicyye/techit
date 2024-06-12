package cote.hoe2;

import java.util.*;
import java.util.stream.Collectors;

public class 최솟값만들기 {
    public static int solution2(int []A, int []B) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> q2 = new PriorityQueue<>();

        for (int i = 0; i < A.length; i++) {
            q.offer(A[i]);
            q2.offer(B[i]);
        }
        while (!q.isEmpty()) {
            int temp = q.poll() * q2.poll();
            answer += temp;
        }

        return answer;
    }
    public static int solution(int []A, int []B) {
        int answer = 0;

        List<Integer> arr = Arrays.stream(A).boxed().collect(Collectors.toList());
        arr.sort(Comparator.reverseOrder());
        Arrays.sort(B);

        int length = A.length-1;

        for (int i =length; i >= 0; i--) {
            int temp = arr.get(i) * B[i];
            answer += temp;
        }

        return answer;
    }
    public static void main(String[] args) {

        // 길이가 같은 배열 a,b에서 각각 한 개의 숫자르 뽑아 두수를 곱한다
        // 배열의 길이만큼 반복되며 누적된 값이 최소가 되도록 만드는 것이 목표


        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println("solution(A, B) = " + solution2(A, B));

    }
}
