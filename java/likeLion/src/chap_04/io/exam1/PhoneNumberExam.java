package chap_04.io.exam1;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class PhoneNumberExam {

    public static void main(String[] args) {
        PhoneNumberOutput no = new PhoneNumberOutput();
        PhoneNumberInput ni = new PhoneNumberInput();

        no.outputPhoneNumber();
        ni.inputPhoneNumber();
    }
}
