package chap_04.io;

import java.io.*;

import static chap_04.io.address.*;

public class InputExam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(output));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output,true));

        String line;

        while((line=br.readLine())!=null) {
            System.out.println("1 str = " + line);
            if (line.contains("hi")) {
                line = line.replace("hi", "hello");
            }
            bw.write(line);
            bw.newLine();
        }

    }
}
