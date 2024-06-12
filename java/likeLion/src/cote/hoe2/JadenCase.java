package cote.hoe2;

public class JadenCase {

    public static String solution2(String s) {
        String[] split = s.split("");
        StringBuilder answer = new StringBuilder();
        answer.append(split[0].toUpperCase());
        for (int i = 1; i <split.length; i++) {
            if (split[i - 1].equals(" ")) {
                answer.append(split[i].toUpperCase());
            } else{
                answer.append(split[i].toLowerCase());
            }
        }
        return answer.toString();
    }
    public static String solution(String s) {
        String[] s1 = s.split(" ");
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s1.length; i++) {
            String upperCase = s1[i].substring(0, 1).toUpperCase();
            answer.append(upperCase + s1[i].substring(1).toLowerCase());
            if(i < s1.length - 1) {
                answer.append(" ");
            }
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        // 모든 단어의 첫 문자가 대문자
        String s = "3people unFollowed me";
        System.out.println(solution2(s));

    }
}
