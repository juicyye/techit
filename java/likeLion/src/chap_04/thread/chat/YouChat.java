package chap_04.thread.chat;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

import static chap_04.thread.chat.ChatMain.address;

public class YouChat extends Thread{
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try(BufferedWriter dos = new BufferedWriter(new FileWriter(address))) {
            while(true){
                System.out.print("YOU: ");
                String next = scanner.next();
                if(next.equals("exit"))break;
                dos.write("YOU: "+next);
                dos.write("\n");
                dos.flush();
            }
        } catch (Exception e) {

        }

    }
}
