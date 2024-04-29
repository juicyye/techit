package network.exam.chat2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatThread extends Thread {
    private String name;
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    List<ChatThread> list;

    public ChatThread(Socket socket, List<ChatThread> list) throws Exception {
        this.socket = socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.name = br.readLine();
        this.list = list;
        this.list.add(this);
    }

    public void sendMessage(String message) {
        pw.println(message);
        pw.flush();
    }

    @Override
    public void run() {
        // chatThread는 사용자가 보낸 메시지를 읽어들여서
        // 접속된 모든 클라이언트에게 메시지를 보낸다
        // 나를 제외한 모든 사용자에게 "00님이 연결되었습니다."
        // 현재 chatThread를 제외하고 보낸다
        try {
            broadcast(name + "님이 연결되었습니다.", false);
            String line = null;
            while ((line = br.readLine()) != null) {
                if("/quit".equals(line)) break;
                broadcast(name + ": " + line, false);
            }
        } catch (Exception e) { // chatThread가 연결이 끊어졌다.
            e.printStackTrace();
        } finally {
            broadcast(name + "님이 연결이 끊어졌습니다.", false);
            this.list.remove(this);
            try {
                br.close();
                pw.close();
                socket.close();
            } catch (Exception e) {}
        }
    }
    private void broadcast(String message, boolean includeMe) {
        List<ChatThread> chatThreads = new ArrayList<>();
        for (int i = 0; i < this.list.size(); i++) {
            chatThreads.add(list.get(i));
        }
        Collections.copy(chatThreads, this.list);
        try {
            for (int i = 0; i < chatThreads.size(); i++) {
                ChatThread ct = chatThreads.get(i);
                if (!includeMe && ct==this)  continue;// 나를 포함하지 않으면

                ct.sendMessage(message);
            }


        } catch (Exception e) {
            System.out.println("///");
        }
    }
}
