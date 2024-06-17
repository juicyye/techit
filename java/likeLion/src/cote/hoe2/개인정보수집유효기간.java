package cote.hoe2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class 개인정보수집유효기간 {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);

        // 약관 종류와 유효기간을 저장하는 맵
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }

        // 파기해야 할 개인정보 번호를 저장할 리스트
        List<Integer> expiredPrivacies = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            LocalDate collectedDate = LocalDate.parse(splitPrivacy[0], formatter);
            String termType = splitPrivacy[1];
            int validMonths = termMap.get(termType);

            LocalDate expiryDate = collectedDate.plusMonths(validMonths);

            if (!expiryDate.isAfter(todayDate)) {
                expiredPrivacies.add(i + 1);  // 개인정보 번호는 1번부터 시작
            }
        }

        // 결과를 int 배열로 변환하여 반환
        return expiredPrivacies.stream().mapToInt(Integer::intValue).toArray();

    }
    public static void main(String[] args) {
        // 1~n번으로 분류되는 개인정보 n개
        // 각 약관마다 유효기간이 정해져있고 유효기간이 지나면 파기
        // A - 6달
        // B - 12달
        // C - 3달
        // 오늘날짜, 유효기간 담은배열, 개인정보 정보

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3" };
        String[] privacies = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };
        System.out.println("Arrays.toString(solution(today, terms, privacies)) = " + Arrays.toString(solution(today, terms, privacies)));
    }
}
