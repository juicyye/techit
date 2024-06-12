package cote.hoe2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 같은숫자는싫어 {
    public static int[] solution(int []arr) {
        Deque<Integer> temp = new ArrayDeque<>();

        for (int index : arr) {
            if (!temp.contains(index) || temp.peekLast() != index) {
                temp.offer(index);
            }
        }

        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println("solution(arr) = " + Arrays.toString(solution(arr)));

    }
}
