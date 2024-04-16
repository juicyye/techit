package cote;

import java.util.Stack;

public class 인형뽑기2 {
    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int pos : moves){
            pos--;
            for(int i =0; i<board.length; i++){
                if(board[i][pos] !=0){
                    int temp = board[i][pos];
                    board[i][pos] = 0;
                    if (!stack.isEmpty() && temp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else{
                        stack.push(temp);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }
}
