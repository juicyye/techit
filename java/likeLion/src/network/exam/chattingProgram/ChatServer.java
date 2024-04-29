package network.exam.chattingProgram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);
        // 공유객체에서 쓰레드에 안전한 리스트를 만든다
        List<PrintWriter> outList = Collections.synchronizedList(new ArrayList<>());
        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("접속 : " +socket);

            ChatThread chatThread = new ChatThread(socket, outList);
            chatThread.start();
        }


    }
}

class ChatThread extends Thread{
    private Socket socket;
    private List<PrintWriter> outList;
    private PrintWriter out;
    private BufferedReader in;

    public ChatThread(Socket socket, List<PrintWriter> outList) {
        this.outList = outList;
        this.socket = socket;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            outList.add(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 1. socket으로부터 읽어들일 수 있는 객체를 얻는다
        // 2. socket에게 쓰기 위한 객체를 얻는다 (현재 연결된 클라이언트에게 쓰는 객체)
    }

    @Override
    public void run() {
        String line = null;

        while (true) {
            try {
                if ((line = in.readLine()) != null){
                    for (PrintWriter printWriter : outList) { // 접속한 모든 클라이언트에게 메시지를 전송한다.
                        PrintWriter pw = printWriter;
                        pw.println(line);
                        pw.flush();
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {// 접속이 끊어질때
                try{
                    outList.remove(out);
                } catch (Exception e){
                    e.printStackTrace();
                }
                for (PrintWriter printWriter : outList) {
                    PrintWriter o = printWriter;
                    o.println("어떤 클라이언트가 접속이 끊어졌어요");
                    o.flush();
                }
                try {
                    outList.remove(out);
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }


        // 3. client가 보낸 메시지를 읽는다
        // 4. 접속된 모든 클라이언트에게 메세지를 보낸다 (현재 접속된 모든 클라이언트에게 쓸 수 있는 객체가 필요하다)
    }
}