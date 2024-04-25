package chap_05.lambda.ex1;

public class FunctionMain {
    public static void main(String[] args) {
        MyFunction myFunction = ((a, b) -> {
            System.out.println(a + b);
        });
    }
}
