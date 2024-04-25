package chap_04.io;

import java.io.*;

import static chap_04.io.address.*;

public class IOExam2 {
    public static void main(String[] args) throws IOException {
        // 키보드로부터 한줄씩 입력 받아서 콘솔에 출력하고 싶다
        // 키보드의 System.in
        // 한줄씩 읽기 위해서 BufferedReader

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2 = new BufferedReader(new FileReader(output));
        BufferedWriter bw = new BufferedWriter(new FileWriter(output,true));

        char[] chars = new char[1024];
        int n;

        try {
            while (true) {
                String s = br2.readLine();
                System.out.println("s = " + s);

                String str = br.readLine();
                bw.write(str);
                bw.newLine();
                System.out.println("str = " + str);
                bw.flush();
                if(str.equals("exit")) break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {


            br.close();

        }


    }
}
