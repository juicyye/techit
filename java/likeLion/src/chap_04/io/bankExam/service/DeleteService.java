package chap_04.io.bankExam.service;

import chap_04.io.bankExam.Account.AccountRepository;

import java.util.Scanner;

public class DeleteService {
    private AccountRepository repository = new AccountRepository();

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정리하고 싶은 통장 아이디: ");
        Long next = Long.parseLong(scanner.next());

        repository.delete(next);
    }
}
