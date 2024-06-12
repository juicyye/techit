package cote.hoe2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class 성격유형검사하기2 {
    public static String solution(String[] survey, int[] choices) {
        // 점수표: choices 배열의 인덱스가 선택지에 대응
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

        // 성격 유형 지표
        String[] indicators = {"RT", "CF", "JM", "AN"};

        // 각 성격 유형의 점수를 저장할 Map
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        // 설문조사 결과를 바탕으로 점수를 계산
        for (int i = 0; i < choices.length; i++) {
            char disagreeType = survey[i].charAt(0);
            char agreeType = survey[i].charAt(1);
            int choice = choices[i];

            if (choice > 4) {
                map.put(agreeType, map.get(agreeType) + score[choice]);
            } else if (choice < 4) {
                map.put(disagreeType, map.get(disagreeType) + score[choice]);
            }
        }
        System.out.println("map = " + map);

        // 최종 성격 유형을 결정
        StringBuilder result = new StringBuilder();
        for (String pair : indicators) {
            char type1 = pair.charAt(0);
            char type2 = pair.charAt(1);

            int score1 = map.get(type1);
            int score2 = map.get(type2);

            if (score1 > score2) {
                result.append(type1);
            } else if (score2 > score1) {
                result.append(type2);
            } else {
                // 사전순으로 빠른 것을 선택
                result.append(type1 < type2 ? type1 : type2);
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {
        // 성격유형 검사 유형은 총 4가지, 각 지표에서 두 유형중 하나로 결정
        // 1번지표 라이언형 R,튜브형 T
        // 2번지표 콘형 C,프로도형 F
        // 3번지표 제이지형 J,무지형 M
        // 4번지표 어치피형 A,네오형 N
        //매우 비동의	네오형 3점
        //비동의	네오형 2점
        //약간 비동의	네오형 1점
        //모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
        //약간 동의	어피치형 1점
        //동의	어피치형 2점
        //매우 동의	어피치형 3점
        /*choices	뜻
        1	매우 비동의
        2	비동의
        3	약간 비동의
        4	모르겠음
        5	약간 동의
        6	동의
        7	매우 동의*/

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println("solution(survey) = " + solution(survey, choices));

    }
}
