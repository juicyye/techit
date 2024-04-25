package chap_04.thread;

public class RunnableExam {
    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("쓰레드1 시작");
            for (int i = 0; i < 10; i++) {
                System.out.println("쓰레드1의 반복값 = " + i);
            }
        }).start();

        new Thread(() -> {
            System.out.println("쓰레드2 시작");
            for (int i = 0; i < 10; i++) {
                System.out.println("쓰레드2의 반복값 = " + i);
            }
        }).start();

        Thread thread = new Thread(() -> {
            System.out.println("쓰레드3 시작");
            try {
                System.out.println("출발~");
                Thread.sleep(2000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("쓰레드4 시작");
            try {
                System.out.println("언제 실행될까?");
                thread.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread2.start();



    }
}
