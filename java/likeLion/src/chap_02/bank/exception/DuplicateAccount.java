package chap_02.bank.exception;

public class DuplicateAccount extends RuntimeException{
    public DuplicateAccount(String message) {
        super(message);
    }

}
