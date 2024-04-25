package chap_05;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetWorkExam {
    public static void main(String[] args) throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost = " + localHost);
        InetAddress google = InetAddress.getByName("www.google.com");
        System.out.println("google = " + google);
        String hostAddress = google.getHostAddress();
        System.out.println("hostAddress = " + hostAddress);



    }
}

