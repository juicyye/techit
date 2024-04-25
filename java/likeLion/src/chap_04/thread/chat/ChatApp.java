package chap_04.thread.chat;

import java.util.List;

public class ChatApp {
    private MeChat meChat = new MeChat();
    private YouChat youChat = new YouChat();
    private RoadChat roadChat = new RoadChat();

    public void start(){
        List<String> road = roadChat.road();
        System.out.println("road = " + road);
        try {
            meChat.start();
            Thread.sleep(2000);
            youChat.start();
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
