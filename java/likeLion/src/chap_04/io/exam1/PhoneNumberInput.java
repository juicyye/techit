package chap_04.io.exam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PhoneNumberInput {
    private static final String phone = "C:/Users/yd634/OneDrive/Desktop/techit/java/test/phone.txt";
    public void inputPhoneNumber() {

        try (BufferedReader br = new BufferedReader(new FileReader(phone))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }
}
