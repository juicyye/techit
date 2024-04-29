package network.netProject.psign;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class PClient {
    public static void main(String[] args) throws Exception {
        String hostName = "localhost"; // 서버가 실행 중인 호스트의 이름 또는 IP 주소
        int portNumber = 12345; // 서버와 동일한 포트 번호 사용

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            socket = new Socket(hostName, portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
            out.println(nickname); // 서버에 닉네임을 전송

            // 방 목록을 요청
            out.println("/list");

            // 서버로부터 메시지를 읽어 화면에 출력하는 별도의 스레드
            Thread readThread = new Thread(new ServerMessageReader(in));
            readThread.start(); // 메시지 읽기 스레드 시작

            // 사용자 입력 처리
            String userInput;
            boolean inRoom = false; // 사용자가 방에 입장했는지 여부를 나타내는 플래그
            while (true) {
                userInput = stdIn.nextLine();

                // 사용자 입력 처리
                if ("/bye".equals(userInput)) {
                    out.println(userInput); // 종료 명령을 서버에 전송
                    break;
                } else if ("/list".equals(userInput)) {
                    out.println(userInput); // 방 목록 보기 명령을 서버에 전송
                } else if ("/create".equals(userInput)) {
                    out.println(userInput); // 방 생성 명령을 서버에 전송
                } else if (userInput.startsWith("/join")) {
                    out.println(userInput); // 방 입장 명령을 서버에 전송
                    inRoom = true; // 방에 입장했음을 표시
                } else if ("/exit".equals(userInput)) {
                    out.println(userInput); // 방 나가기 명령을 서버에 전송
                    inRoom = false; // 방에서 나왔음을 표시
                } else {
                    if (inRoom) {
                        // 사용자가 방에 입장한 경우에만 메시지 전송
                        out.println(userInput);
                    } else {
                        System.out.println("방에 입장한 후에 메시지를 보낼 수 있습니다.");
                    }
                }
            }

            // 클라이언트와 서버는 명시적으로 close를 합니다. close를 할 경우 상대방쪽의 readLine()이 null을 반환됩니다. 이 값을 이용하여 접속이 종료된 것을 알 수 있습니다.
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("오류가 발생했습니다. [" + hostName + "] 포트번호: " + portNumber);
            e.printStackTrace();
        }
    }
}