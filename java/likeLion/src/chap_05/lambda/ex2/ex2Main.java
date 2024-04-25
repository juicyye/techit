package chap_05.lambda.ex2;

interface A{
    void abc(B b,int k);
}
class B{
    void bcd(int k){
        System.out.println("k = " + k);
    }
}
public class ex2Main {
    public static void main(String[] args) {

        A a2 = new A() {
            @Override
            public void abc(B b, int k) {
                b.bcd(k);
            }
        };

        A a1 = (B b, int k) -> {
            k = 3;
            b.bcd(k);
        };

        A a = B::bcd;


        a.abc(new B(),3);





    }
}
