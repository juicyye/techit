package chap_04.thread.chat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import static chap_04.thread.chat.ChatMain.address;

public class MeChat extends Thread {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try(BufferedWriter dos = new BufferedWriter(new FileWriter(address))) {
            while(true){
                System.out.print("ME: ");
                String next = scanner.next();
                if(next.equals("exit"))break;
                dos.write("ME: "+next);
                dos.write("\n");
                dos.flush();

            }
        } catch (Exception e) {

        }

    }
}