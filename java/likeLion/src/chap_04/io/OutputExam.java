package chap_04.io;

import java.io.*;
import java.util.Scanner;

import static chap_04.io.address.output;

public class OutputExam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(output));
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        while(true){
            String s = scanner.nextLine();
            bw.write(s);
            bw.newLine();
            bw.flush();
            if(s.equals("exit")) break;

        }
    }
}
