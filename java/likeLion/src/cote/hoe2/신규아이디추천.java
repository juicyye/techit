package cote.hoe2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class 신규아이디추천 {

    public static String solution(String new_id) {
        String answer = "";
        //1
        answer = new_id.toLowerCase();
        //2
        answer = answer.replaceAll("[^0-9a-z-_.]", "");
        //3
        answer = answer.replaceAll("\\.{2,}", ".");
        //4
        answer = answer.replaceAll("^[.]|[.]$", "");
        //5
        answer = answer.equals("") ? "a" : answer;
        //6-1
        answer = answer.length() >= 16 ? answer.substring(0, 15) : answer;
        //6-2
        answer = answer.replaceAll("[.]$", "");
        //7
        char lastCh = answer.charAt(answer.length() - 1);
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += lastCh;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        // 아이디 길이는 3~15
        // 소문자, 숫자, - , _ , . 만 사용가능
        // 단 마침표는 처음과 끝에 사용할 수 없고 연속적으로 사용할 수 없다
        /* 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.*/
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println("solution(new_id) = " + solution(new_id));

    }
}
