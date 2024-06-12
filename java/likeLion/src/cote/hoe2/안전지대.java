package cote.hoe2;

public class 안전지대 {
    public static int solution(int[][] board) {
        int answer = 0;
        // 동서남북, 대각선
        int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        // 지뢰지역여부
        boolean[][] danger = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 지뢰매설구역 찾기
                if(board[i][j] == 1) {
                    danger[i][j] = true;

                    for (int[] dir : directions) {
                        int ni = i +dir[0];
                        int nj = j + dir[1];
                        // 지뢰 매설을 기준으로 동서남북, 대각선이다
                        if( ni >= 0 && ni < board.length && nj>= 0 && nj <board.length){
                            danger[ni][nj] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!danger[i][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 지뢰가 매설된 지역 1
        // 지뢰가 없는 지역 0
        // 안전한 지역 칸수 return
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        System.out.println("solution(board) = " + solution(board));

    }
}
