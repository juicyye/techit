package chap_04.io.exam1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class PhoneNumberOutput {
    private static final String phone = "C:/Users/yd634/OneDrive/Desktop/techit/java/test/phone.txt";
    public void outputPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(phone))) {
            System.out.print("이름: ");
            String name = scanner.next();
            bw.write(name+ " ");


            System.out.print("전화번호: ");
            String phoneNumber = scanner.next();
            bw.write(phoneNumber);
            bw.write("\n");

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }
}
