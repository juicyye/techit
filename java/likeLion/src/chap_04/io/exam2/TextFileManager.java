package chap_04.io.exam2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileManager {
    private String filePath;


    public TextFileManager(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(List<String> userInput) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : userInput) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<String> readFromFile() {
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.add(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return fileContent;
    }
}