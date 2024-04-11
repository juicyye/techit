package chap_02.bank.service.refac.acount;

import java.util.Map;

public interface Account {
    Account createAccount(long money, String name, String accountNumber);
    void deposit(long amount);

    void withdraw(long amount);

    String getName();
    long getBalance();
    String getAccountNumber();

}
