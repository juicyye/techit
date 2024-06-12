package cote.hoe2;

import java.util.*;

public class 완주하지못한선수 {

    public static String solution3(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> part = new HashMap<>();

        for (String string : participant) {
            part.put(string, part.getOrDefault(string, 0) + 1);
        }

        for (String string : completion) {
            part.put(string,part.get(string) -1);
        }

        for (String string : part.keySet()) {
            if (part.get(string) != 0) {
                answer = string;
                break;
            }
        }



        return answer;
    }

    public static String solution2(String[] participant, String[] completion) {
        String answer = "";

        Set<String> com = new HashSet<>();
        for (String string : completion) {
            if(com.contains(string)) {
                com.add(string+1);
            } else if (com.contains(string+1)) {
                com.add(string+2);
            }
            else{
                com.add(string);
            }
        }

        for (String string : participant) {
            if (com.contains(string)) {
                com.remove(string);
                com.remove(string+1);
            } else{
                answer= string;
            }
        }


        return answer;
    }



    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> participant1 = new ArrayList<>(List.of(participant));
        List<String> completion1 = new ArrayList<>(List.of(completion));
        for (String string : participant1) {
            if(completion1.contains(string)) {
                completion1.remove(string);
            } else{
                answer = string;
            }
        }
        return answer;
    }
    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println("solution(participant,completion) = " + solution2(participant, completion));

    }
}
