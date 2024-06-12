package cote.hoe2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class 문자열밀기 {
    public static int solution(String A, String B) {
        int answer = 0;

        Deque<Character> queue = new ArrayDeque<>();
        for (char c : A.toCharArray()) {
            queue.add(c);
        }

        for (int i = 0; i < A.length(); i++) {

            StringBuilder sb = new StringBuilder();
            for (char c : queue) {
                sb.append(c);
            }
            String current = sb.toString();

            if (current.equals(B)) {
                return answer;
            }


            Character c = queue.pollLast();
            queue.offerFirst(c);
            answer++;
        }
        return -1;

    }
    public static void main(String[] args) {
        // 각문자를 오른쪽으로 한칸씩 밀고 마지막 문자는 맨앞으로 이동
        // a를 밀어서 b가 될수있다면 밀어야하는 최소횟수 return
        String A = "hello";
        String B = "ohell";

        System.out.println("solution(A,B) = " + solution(A,B));

    }

}
