package network.netProject.psign.refac;

import network.netProject.psign.ServerMessageReader;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ReClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 12345);

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner stdIn = new Scanner(System.in);

            // 클라이언트 화면에 명령어 목록 출력
            System.out.println("명령어:");
            System.out.println("방 목록 보기 : /list");
            System.out.println("방 생성 : /create");
            System.out.println("방 입장 : /join [방번호]");
            System.out.println("방 나가기 : /exit");
            System.out.println("접속종료 : /bye");

            System.out.print("닉네임을 입력해주세요: ");
            String nickname = stdIn.nextLine();
            pw.println(nickname); // 서버에 닉네임을 전송

            // 방 목록을 요청
            pw.println("/list");

            // 서버로부터 메시지를 읽어 화면에 출력하는 별도의 스레드
            // 메시지 읽기 스레드 시작
            new Thread(new ServerMessageReader(br)).start();


            // 사용자 입력 처리
            String userInput;
            boolean inRoom = false; // 사용자가 방에 입장했는지 여부를 나타내는 플래그
            while (true) {
                userInput = stdIn.nextLine();

                // 사용자 입력 처리
                if ("/bye".equals(userInput)) {
                    pw.println(userInput); // 종료 명령을 서버에 전송
                    break;
                } else if ("/list".equals(userInput)) {
                    pw.println(userInput); // 방 목록 보기 명령을 서버에 전송
                } else if ("/create".equals(userInput)) {
                    pw.println(userInput); // 방 생성 명령을 서버에 전송
                } else if (userInput.startsWith("/join")) {
                    pw.println(userInput); // 방 입장 명령을 서버에 전송
                    inRoom = true; // 방에 입장했음을 표시
                } else if ("/exit".equals(userInput)) {
                    pw.println(userInput); // 방 나가기 명령을 서버에 전송
                    inRoom = false; // 방에서 나왔음을 표시
                } else {
                    if (inRoom) {
                        // 사용자가 방에 입장한 경우에만 메시지 전송
                        pw.println(userInput);
                    } else {
                        System.out.println("방에 입장한 후에 메시지를 보낼 수 있습니다.");
                    }
                }
            }
            try {
                br.close();
                pw.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}