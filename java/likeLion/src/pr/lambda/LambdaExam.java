package pr.lambda;

import java.util.HashMap;
import java.util.Map;

public class LambdaExam {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        map.put("2", "3");
        map.put("3", "4");
        map.put("4", "5");
        map.put("5", "6");

        map.forEach((k, v) -> System.out.println("키는: " + k +" 밸류는: " + v));
    }
}
