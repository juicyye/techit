package chap_02.bank.exception;

public class WrongNumber extends RuntimeException{
    public WrongNumber(String message) {
        super(message);
    }
}
