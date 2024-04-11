package chap_02.bank.exception;

public class BlankWrongAnswer extends RuntimeException{
    public BlankWrongAnswer(String message) {
        super(message);
    }
}
