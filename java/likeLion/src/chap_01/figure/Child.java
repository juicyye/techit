package chap_01.figure;

public class Child extends Parent{
    @Override
    public void print(int x, int y) {
        System.out.println("x * y * 0.5 = " + x * y * 0.5);
    }
}
