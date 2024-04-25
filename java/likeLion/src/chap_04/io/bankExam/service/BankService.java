package chap_04.io.bankExam.service;

import chap_04.io.bankExam.Account.Account;
import chap_04.io.bankExam.Account.AccountRepository;

import java.util.Scanner;

public class BankService {
    private final AccountRepository repository = new AccountRepository();


    public void deposit() {
        Long id = findId();
        long price = findPrice();
        Account account = repository.findById(id);
        account.setBalance(account.getBalance() + price);
        System.out.println("입금완료 잔액: " + account.getBalance());
    }

    public void withdraw() {
        Long id = findId();
        long price = findPrice();
        Account account = repository.findById(id);
        if(account.getBalance() < price) {
            throw new IllegalArgumentException("잔고가 부족합니다");
        }
        account.setBalance(account.getBalance() - price);
        System.out.println("출금완료 잔액: " + account.getBalance());
    }

    private Long findId(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("통장 아이디: ");
        Long next = Long.parseLong(scanner.next());
        return next;
    }

    private long findPrice(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("금액: ");
        Long next = Long.parseLong(scanner.next());
        return next;
    }
}
