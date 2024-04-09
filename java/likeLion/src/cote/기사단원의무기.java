package cote;

public class 기사단원의무기 {
    public static void main(String[] args) {
        int result = solution(10, 3, 2);
        System.out.println("무기를 만들기 위해 필요한 철의 무게: " + result + "kg");

    }

    static int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int tmp = sqrt(i);
            answer += (tmp > limit) ? power : tmp;
        }
        return answer;
    }

    static int sqrt(int num){
        int count = 0;
        double sqrt = Math.sqrt(num);

        for (int i = 1; i <= sqrt; i++) {
            if(num % i ==0){
                if(i==sqrt){
                    count++;
                } else{
                    count +=2;
                }
            }
        }
        return count;
    }
}
