package cote.hoe2;

import java.util.Arrays;

public class 분수의덧셈 {

    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};

        return answer;
    }

    // 최대공약수를 구하는 메서드 (재귀 방식)
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 최대공약수를 구하는 메서드 (반복 방식)
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        // 첫번째 분수의 분자와 분모를 뜻하는 number1 denom1
        // 두번째 분수의 분자와 분모를 뜻하는 number2 denom2

        // 두 분수를 더한 값을 기약분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록
        int number1= 1;
        int denom1= 2;
        int number2= 3;
        int denom2= 4;

        System.out.println("Arrays.toString(solution(number1,number2,number3,number4)) = " + Arrays.toString(solution(number1, denom1, number2, denom2)));

    }
}
