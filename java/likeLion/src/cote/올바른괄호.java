package cote;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        // 테스트를 위한 문자열
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        List arr = new ArrayList();

        // 각 문자열에 대한 결과 출력
        System.out.println(solution(s1)); // true
        System.out.println(solution(s2)); // true
        System.out.println(solution(s3)); // false
        System.out.println(solution(s4)); // false
    }

    static boolean solution(String s) {
        // 스택을 사용하여 괄호의 짝을 확인합니다.
        Stack<Character> stack = new Stack<>();

        // 문자열을 순회하면서 '('를 만나면 스택에 push하고, ')'를 만나면 스택에서 pop하여 짝이 맞는지 확인합니다.
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                // 스택이 비어있거나 pop한 괄호가 '('가 아니면 올바르지 않은 괄호입니다.
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        // 스택이 비어있어야 모든 괄호의 짝이 맞습니다.
        return stack.isEmpty();
    }

    static boolean solution2(String s) {
        boolean answer = true;
        int open = 0; // ( 의 수
        int close = 0; // ) 의 수
        for(int i=0; i<s.length(); i++){
            String c = s.substring(i,i+1);
            switch(c){
                case "(":
                    open++;
                    break;
                case ")":
                    if(open<=close){
                        return false;
                    } else {
                        close++;
                    }
                    break;
            }
        }
        if(open!=close)
            answer = false;
        return answer;


    }

}




