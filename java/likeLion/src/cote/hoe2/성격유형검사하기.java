package cote.hoe2;

import java.util.*;

public class 성격유형검사하기 {
    public static String solution(String[] survey, int[] choices) {
        // 1~3은 왼쪽 5~7번은 오른쪽에 1~3점 점수를 준다
        // map으로 해당 유형을 키로 밸류로는 점수를 한다음 비교하면 되지 않을까
        String answer = "";
        // choices는 1~7까지 이니까 score[0]에는 의미없는 숫자를 넣고 나머지에 점수를 넣는다
        int[] score = {0,3, 2, 1, 0, 1, 2, 3};
        String[] temp = {"AN", "CF", "MJ", "RT", "NA"};
        Map<Character, Integer> map = new LinkedHashMap<>();

        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);

        for (int i = 0; i < choices.length; i++) {
            char[] charArray = survey[i].toCharArray();
            if (choices[i] > 4) {
                map.put(charArray[1], score[choices[i]] + map.get(charArray[1]));
            } else if (choices[i] < 4) {
                map.put(charArray[0], score[choices[i]] + map.get(charArray[0]));

            }
        }

        for (String sur : temp) {
            char[] charArray = sur.toCharArray();
            if(Objects.equals(map.get(sur.charAt(0)), map.get(sur.charAt(1)))) {
                if (charArray[0] - charArray[1] < 0) {
                    map.remove(charArray[1]);
                    map.put(charArray[0], map.get(sur.charAt(0)));
                } else{
                    map.remove(charArray[0]);
                    map.put(charArray[1], map.get(sur.charAt(1)));
                }
            }
        }
        System.out.println("map = " + map);

        return answer;
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

        String[] survey2 = {"TR", "RT", "TR"};
        int[] choices2 = {7, 1, 3};
        System.out.println("solution(survey) = " + solution(survey, choices));
        System.out.println("solution(survey2,choices2) = " + solution(survey2, choices2));

    }
}
