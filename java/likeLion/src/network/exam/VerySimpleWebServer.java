package network.exam;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class VerySimpleWebServer {
    public static void main(String[] args) throws IOException {
        // 9090 port로 대기한다
        ServerSocket ss = new ServerSocket(9090);

        // 클라이언트를 대기한다
        // 클라이언트가 접속하는 순간, 클라이언트와 통신할 수 있는 socket을 반환한다
        System.out.println("클라이언트 접속을 기다립니다.");
        // socket은 클라이언트와 통신할 수 있는 객체다
        Socket socket = ss.accept();

        // client와 읽고 쓸 수 있는 inputStream, outputStream이 반환된다
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String firstLine = br.readLine();
        ArrayList<String> headers = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()).equals("")) {
            headers.add(line);
        }
        // 요청정보 읽기 끝
        System.out.println("firstLine: " + firstLine);
        for (int i = 0; i < headers.size(); i++) {
            System.out.println("headers.get(i) = " + headers.get(i));

        }
        System.out.println("socket: " + socket.toString());

        ss.close();
        System.out.println("서버가 종료됩니다.");

    }
}
