package chap_04.thread;

public class ThreadExam {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadExam.main");
        }

    }

}
