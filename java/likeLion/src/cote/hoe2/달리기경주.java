package cote.hoe2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 달리기경주 {
    public static String[] solution2(String[] players, String[] callings) {
        Map<String, Integer> map = IntStream.range(0, players.length).boxed().collect(Collectors.toMap(i -> players[i], i -> i));

        for (String calling : callings) {
            if(map.containsKey(calling)) {
                int ranking = map.get(calling);
                map.put(players[ranking - 1], ranking);
                map.put(players[ranking],  ranking-1);

                String previous = players[ranking-1];
                players[ranking-1] = players[ranking];
                players[ranking] = previous;
            }
        }
        return players;
    }
    public static String[] solution(String[] players, String[] callings) {
        List<String> list = new LinkedList<>(List.of(players));

        for (String calling : callings) {
            for (int i = 0; i < list.size(); i++) {
                if(calling.equals(list.get(i))) {
                    list.add(i-1, list.get(i));
                    list.remove(i+1);
                }
            }
        }
        return list.toArray(new String[0]);
    }
    public static void main(String[] args) {
        // 1. palyer 순서가 현재 순위이다
        // 2. callings에서 한번 불릴때마다 앞에 있는 등수를 제쳤다
        // 3. kai가 2번 불렸으므로 kai는 4등에서 2등이 됐다
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println("solution(players,callings) = " + Arrays.toString(solution2(players, callings)));

    }

}
