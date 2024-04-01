package chap_01;

public class MathBean {
    public void printClassName() {
        System.out.println("MathBean.class = " + MathBean.class);
    }
    public void printNumber(int x) {
        System.out.println("x = " + x);
    }

    public int getOne() {
        return 1;
    }

    public int plus(int x, int y) {
        return x+y;
    }
}
