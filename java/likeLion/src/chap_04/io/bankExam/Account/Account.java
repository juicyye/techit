package chap_04.io.bankExam.Account;

import java.io.Serializable;

public class Account implements Serializable {
    private Long id;
    private String name;
    private long balance;
    private String Bankbook;


    public Account(Long id, String name, long balance, String bankbook) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        Bankbook = bankbook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getBankbook() {
        return Bankbook;
    }

    public void setBankbook(String bankbook) {
        Bankbook = bankbook;
    }
}
