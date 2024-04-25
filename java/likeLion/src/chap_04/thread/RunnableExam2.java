package chap_04.thread;

public class RunnableExam2 {
    public static void main(String[] args) {
        Runnable runnable = (() -> {
            System.out.println("러너블");

        });

        new Thread(runnable).start();
    }
}
