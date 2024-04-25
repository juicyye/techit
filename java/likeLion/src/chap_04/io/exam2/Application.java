package chap_04.io.exam2;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String filePath = "C:/Users/yd634/OneDrive/Desktop/techit/java/test/texts.txt";
        TextFileManager fileManager = new TextFileManager(filePath);
        UserInputHandler inputHandler = new UserInputHandler();

        try {
            List<String> userInput = inputHandler.getUserInput();
            fileManager.writeToFile(userInput);

            List<String> fileContent = fileManager.readFromFile();
            System.out.println("Content of the file:");
            fileContent.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}