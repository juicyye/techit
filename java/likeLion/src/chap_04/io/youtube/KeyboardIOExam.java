package chap_04.io.youtube;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardIOExam {
    public static void main(String[] args) throws Exception{
        // 텍스트를 한줄씩 입력받고, 한줄씩 화면에 출력하시오
        // 키보드 System.in
        // 키보드로 입력받는다는건 문자를 입력받는 것: char 단위 입출력
        // char단위 입출력 클래스는 ReaDer, Writer
        // 한줄 읽기 : bufferedReader라는 클래스는 readLine이라는 메소드를 가지고 있다, 더이상 읽어들일 것이 없으면 null을 반환
        // 장식
        // 한줄 쓰기 : PrintStream, PrintWriter

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while((line=br.readLine())!=null){

        }
    }

}
