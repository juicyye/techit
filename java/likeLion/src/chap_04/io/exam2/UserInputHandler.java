package chap_04.io.exam2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputHandler {
    public List<String> getUserInput() {
        List<String> userInput = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("문자: ");
            String next = scanner.next();
            if (next.equals("exit")) break;
            userInput.add(next);
        }
        return userInput;
    }
}
