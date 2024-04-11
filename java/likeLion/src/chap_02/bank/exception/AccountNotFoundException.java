package chap_02.bank.exception;

public class AccountNotFoundException extends RuntimeException{


    public AccountNotFoundException(String message) {
        super(message);

    }

}
