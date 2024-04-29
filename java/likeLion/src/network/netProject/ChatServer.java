package network.netProject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static network.netProject.HostAndPort.*;

public class ChatServer {
    public static void main(String[] args) {
        System.out.println("Chat Server");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
        } catch (IOException e) {
            System.out.println("해당 포트를 열수 없습니다.");
            System.exit(0);
        }
        System.out.println("== Client 접속 대기 ==");
        while(true){
            try {
                Socket socket = serverSocket.accept();
                System.out.println("접속 client 주소: " + socket.getInetAddress() + ":" + socket.getPort());

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

                String str = br.readLine();
                System.out.println("str: " + str);
                pw.write("어서오세요");
                pw.flush();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
