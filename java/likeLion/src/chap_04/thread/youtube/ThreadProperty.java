package chap_04.thread.youtube;

public class ThreadProperty {

    public static void main(String[] args) {
        // 객체 가져오기 + 쓰레드 수
        Thread curThread = Thread.currentThread();
        System.out.println("현재 쓰레드 이름: " + curThread.getName());
        System.out.println("쓰레드 수: " + Thread.activeCount());

        // 쓰레드 이름 직접 설정
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread();
            thread.setName(i + "번째 쓰레드");
            System.out.println(thread.getName());
            thread.start();
        }

        // cpu core수 가져오기
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 우선순위 지정
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread();
            thread.setName(i + "번째 스레드");
            if (i == 9) {
                thread.setPriority(Thread.MAX_PRIORITY);
                thread.start();
            }
        }

        Thread thread = new Thread();
        // 데몬스레드 설정, false가 기본 설정
        thread.setDaemon(true);
    }

}
