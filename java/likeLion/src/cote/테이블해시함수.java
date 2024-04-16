package cote;

import java.util.Arrays;

public class 테이블해시함수 {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        // col 번째 컬럼을 기준으로 오름차순으로 정렬하되, 동일한 경우에는 기본키를 내림차순으로 정렬
        // 순회해서 비교함
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] != b[col - 1]) {
                return Integer.compare(a[col - 1], b[col - 1]); // 반환값이 음수일때 오름차순
            } else {
                return Integer.compare(b[0], a[0]); // 반환값이 양수일때 내림차순
            }
        });

        int answer = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int s_i = 0;
            for (int j = 0; j < data[i - 1].length; j++) {
                // 각 컬럼 값에 대해 해당 행의 번호로 나눈 나머지를 구하여 합산
                s_i += data[i - 1][j] % i;
            }
            answer ^= s_i; // XOR 연산
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] data = {
                {2, 2, 6},
                {1, 5, 10},
                {4, 2, 9},
                {3, 8, 3}
        };
        int col = 2;
        int row_begin = 2;
        int row_end = 3;

        System.out.println(solution(data, col, row_begin, row_end)); // 예상 출력: 4
    }
}
