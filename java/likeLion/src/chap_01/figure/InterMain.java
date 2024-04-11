package chap_01.figure;

public class InterMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.print(3,4);

        InterImpl impl = new InterImpl();
        impl.abc();

        Inter.light();

    }
}
