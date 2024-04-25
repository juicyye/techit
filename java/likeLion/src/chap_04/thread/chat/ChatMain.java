package chap_04.thread.chat;

public class ChatMain {
    public static final String address = "C:/Users/yd634/OneDrive/Desktop/techit/java/test/chatTest.txt";
    public static void main(String[] args) {
        System.out.println("=====채팅 프로그램========");
        ChatApp app = new ChatApp();
        app.start();

    }
}
