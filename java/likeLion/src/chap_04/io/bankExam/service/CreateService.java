package chap_04.io.bankExam.service;

import chap_04.io.bankExam.Account.AccountRepository;

import java.util.Scanner;

public class CreateService {
    private final AccountRepository repository = new AccountRepository();



    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름: ");
        String name = scanner.next();

        System.out.print("잔고: ");
        long balance = Long.parseLong(scanner.next());

        System.out.print("계좌번호: ");
        String Bankbook = scanner.next();
        scanner.nextLine();

        repository.save(name,balance,Bankbook);
        System.out.println("통장이 만들어졌습니다");

    }
}
