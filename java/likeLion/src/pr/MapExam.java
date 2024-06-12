package pr;

import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class MapExam {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        Map<String, String> store = Map.of("hi", now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")) + " 날씨는 나이스");

    }
        
}
