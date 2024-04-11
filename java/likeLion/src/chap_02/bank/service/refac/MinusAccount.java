package chap_02.bank.service.refac;

import chap_02.bank.exception.InsufficientFundsException;
import chap_02.bank.exception.WrongNumber;

public class MinusAccount implements Account {
    // 통장 객체는 입금과 출금 기능을 가지며, 출금 시 잔액 부족 예외를 발생시킬 수 있어야 합니다.
    private int balance;
    private String name;
    private String accountNumber;

    MinusAccount(int balance, String name, String accountNumber) {
        this.balance = balance;
        this.name = name;
        this.accountNumber = accountNumber;
    }


    @Override
    public Account createAccount(int money, String name, String accountNumber) {
        return null;
    }

    @Override
    public void deposit(int amount) {
        if(amount < 0) throw new WrongNumber("양수를 입력해주세요");
        balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (balance < amount) {
            throw new InsufficientFundsException("보유하신 잔액보다 큰 금액은 출금할 수 없습니다 잔액: "+ balance);
        }
        balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }
}
