package chap_01.figure;

public interface Inter {
    default void abc(){
        System.out.println("인터.print");
    }

    static void light(){
        System.out.println("불을 밝히다");
    }


}
