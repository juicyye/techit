package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;
    private final String nickname;
    private String currentRoom; // 클라이언트가 현재 속한 방의 정보를 유지

    public ClientHandler(Socket socket, String nickname) throws IOException {
        this.socket = socket;
        this.nickname = nickname;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            System.out.println(nickname + "님이 접속했습니다. 연결된 IP: " + socket.getInetAddress());

            // 채팅 서버에 새 클라이언트 추가
            PServer.addClient(nickname, out);

            String input;
            while ((input = in.readLine()) != null) {
                if ("/bye".equals(input)) {
                    break;
                } else if ("/create".equals(input)) {
                    PServer.createChatRoom(out);
                } else if ("/list".equals(input)) {
                    PServer.listChatRooms(out);
                } else if (input.startsWith("/join")) {
                    // 클라이언트가 방에 입장하는 경우, 해당 방에 입장했음을 플래그로 표시
                    String[] parts = input.split(" ");
                    if (parts.length == 2) {
                        String newRoom = parts[1]; // 새로운 방 정보 저장
                        if (currentRoom != null) {
                            // 이전 방에서 클라이언트 제거
                            PServer.leaveRoom(currentRoom, this);
                        }
                        currentRoom = newRoom; // 클라이언트가 입장한 방 설정
                        out.println("방 " + currentRoom + "에 입장하였습니다.");
                        PServer.joinRoom(currentRoom, this); // 서버에 해당 클라이언트가 방에 입장했음을 전달
                    } else {
                        out.println("잘못된 명령입니다.");
                    }
                } else if ("/exit".equals(input)) {
                    if(currentRoom != null) {
                        // 클라이언트가 방에서 나가는 경우, 해당 방에서 나왔음을 플래그로 표시
                        currentRoom = null; // 현재 방 정보 초기화
                        out.println("방에서 나왔습니다.");
                    } else{
                        out.println("나갈 수 있는 상태가 아닙니다.");
                    }

                } else {
                    // 클라이언트가 방에 입장한 경우에만 해당 방의 다른 클라이언트에게 메시지 전송
                    if (currentRoom != null) {
                        PServer.sendToRoom(currentRoom, nickname + ": " + input, out); // 해당 방의 모든 클라이언트에게 메시지 전송
                    } else {
                        out.println("방에 입장한 후에 메시지를 보낼 수 있습니다.");
                    }
                }
            }

            // 클라이언트 연결 종료
            System.out.println("User " + nickname + " 연결이 종료됩니다.");
            PServer.sendToAll("User " + nickname + " 연결이 종료되었습니다..");
            PServer.leaveRoom(currentRoom, this); // 클라이언트가 방을 나갔음을 서버에 전달
            PServer.users.remove(nickname);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 현재 클라이언트가 속한 방의 정보 반환
    public String getCurrentRoom() {
        return currentRoom;
    }

    // 현재 클라이언트의 PrintWriter 반환
    public PrintWriter getPrintWriter() {
        return out;
    }
}