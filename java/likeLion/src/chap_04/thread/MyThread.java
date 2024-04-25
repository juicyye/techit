package chap_04.thread;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyThread.run");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        DataOutputStream adf = new DataOutputStream(new FileOutputStream("adf"));
    }



}
