package chap_04.thread.youtube;

public class synchronizedExam {
    // 공유객체
    static class MyData{
        synchronized void abc(){
            for (int i = 0; i < 3; i++) {

                System.out.println("i = " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        synchronized void bcd(){
            for (int i = 0; i < 3; i++) {
                System.out.println("초 = " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        void cde(){
            synchronized(new Object()){
                for (int i = 0; i < 3; i++) {
                    System.out.println(i + "번째");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }

        }
    }

    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(){
            @Override
            public void run() {
                myData.abc();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                myData.bcd();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                myData.cde();
            }
        }.start();



    }
}
