package chap_02.bank.service.refac;

public interface Account {
    Account createAccount(int money, String name, String accountNumber);
    void deposit(int amount);

    void withdraw(int amount);

}
