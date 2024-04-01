package cote;


import java.util.Arrays;


public class 옹알이2 {
    public static int solution(String[] babbling) {
        String[] babbling2 = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        String[] word = {"aya", "ye", "woo", "ma"};

        return  (int) Arrays.stream(babbling)
                .map(str -> {
                    for (String w : word) {
                        if (str.contains(w)) { // babbling이 돌며 w가 포함되어 있으면 공백으로 반환
                            str = str.replace(w, " ");
                        }
                    }
                    return str;
                })
                .filter(str -> str.trim().isEmpty()) // 공백을 제거하고 empty인지 확인
                .count();
    }





    public static void main(String[] args) {

        String[] babbling1 = {"aya", "yee", "u", "maa", "wyeoo"};
        String[] babbling2 = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        System.out.println(solution(babbling1)); // 출력: 1
        System.out.println(solution(babbling2)); // 출력: 3


    }
}
