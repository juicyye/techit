package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PServer {
    private static final int PORT = 12345;
    static final Map<String, PrintWriter> users = new HashMap<>();
    public static final List<String> chatRooms = new ArrayList<>();
    public static final Map<String, List<ClientHandler>> roomClients = new HashMap<>(); // 방에 속한 클라이언트 목록
    private static int roomNumber = 1;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("서버 동작중..");
            while (true) {
                Socket socket = serverSocket.accept(); // 클라이언트의 연결을 기다림
                System.out.println("새로운 손님: " + socket);

                // 클라이언트가 보낸 닉네임을 읽음
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String nickname = reader.readLine();

                // 클라이언트와 통신하기 위한 스레드 시작
                Thread thread = new Thread(new ClientHandler(socket, nickname));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 새 클라이언트를 추가하고 대화방으로 이동하는 메서드
    static void addClient(String nickname, PrintWriter out) {
        users.put(nickname, out);
        sendToAll(nickname + " 님이 접속했습니다.");
    }

    // 모든 클라이언트에게 메시지를 보내는 메서드
    static void sendToAll(String message) {
        for (PrintWriter writer : users.values()) {
            writer.println(message);
        }
    }

    // 클라이언트가 대화방을 생성하는 메서드
    static void createChatRoom(PrintWriter out) {

        chatRooms.add("Room " + roomNumber);
        out.println(roomNumber + "번 방을 생성했습니다.");
        roomNumber++;
    }

    // 생성된 대화방 목록을 클라이언트에게 보내는 메서드
    static void listChatRooms(PrintWriter out) {
        if (chatRooms.isEmpty()) {
            out.println("채팅 가능한 방이 없습니다.");
        } else {
            out.println("입장 가능한 채팅방 목록: ");
            for (String room : chatRooms) {
                out.println(room);
            }
        }
    }

    // 특정 방에 있는 클라이언트에게 메시지를 보내는 메서드
    static void sendToRoom(String room, String message, PrintWriter sender) {
        List<ClientHandler> clients = roomClients.get(room);
        for (ClientHandler client : clients) {
            if (!client.getPrintWriter().equals(sender)) {
                client.getPrintWriter().println(message);
            }
        }
    }

    // 클라이언트를 해당 방에 추가하는 메서드
    static void addClientToRoom(ClientHandler client) {
        String room = client.getCurrentRoom();
        if (room != null) {
            roomClients.computeIfAbsent(room, k -> new ArrayList<>()).add(client);
        }
    }

    // 클라이언트를 해당 방에서 제거하는 메서드
    static void removeClientFromRoom(ClientHandler client) {
        String room = client.getCurrentRoom();
        if (room != null) {
            List<ClientHandler> clients = roomClients.get(room);
            clients.remove(client);
            if (clients.isEmpty()) {
                roomClients.remove(room);
            }
        }
    }

    // 클라이언트가 방에 입장했음을 서버에 전달하는 메서드
    static void joinRoom(String room, ClientHandler client) {
        addClientToRoom(client);
    }

    // 클라이언트가 방을 나갔음을 서버에 전달하는 메서드
    static void leaveRoom(String room, ClientHandler client) {
        removeClientFromRoom(client);
    }
}