package cote;

public class 푸드파이트 {

    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) { // 0번은 물이니까 패스
            if (food[i] >= 2) { // 1이하면 나눠먹을 수 없음
                int tmp = food[i] / 2; // 반으로 쪼개서
                for (int j = 0; j < tmp; j++) { // food[i]를 반으로 쪼갠만큼 돌리면
                    sb.append(i); // 두명이서 먹을 양이 나옴
                }
            }

        }

        StringBuilder tmp = new StringBuilder(sb); // 새로운 객체에 sb를 넣고

        // System.out.println("sb = " +sb.append(0).append(sb.reverse()).toString());


        return tmp.append(0).append(sb.reverse()).toString(); // 0과 sb를 거꾸로한걸 넣는다
    }

    public static void main(String[] args) {
        int[] food1 = {1, 3, 4, 6};



        int[] food2 = {1, 7, 1, 2};
        System.out.println(solution(food2));



    }
}
