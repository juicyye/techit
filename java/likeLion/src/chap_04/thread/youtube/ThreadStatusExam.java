package chap_04.thread.youtube;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ThreadStatusExam {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] allByName = InetAddress.getAllByName("www.google.com");
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost = " + localHost);
        System.out.println("localHost = " + localHost.getHostAddress());

        for (InetAddress inetAddress : allByName) {
            System.out.println("inetAddress.getHostAddress() = " + inetAddress.getHostAddress());

        }

    }
}
