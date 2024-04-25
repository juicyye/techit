package chap_04.io.bankExam.service;

import chap_04.io.bankExam.Account.Account;
import chap_04.io.bankExam.Account.AccountRepository;

import java.util.List;

public class PrintService {
    private AccountRepository repository = new AccountRepository();

    public void print(){
        List<Account> list = repository.findAll();
        if(list.isEmpty()) System.out.println("계좌가 없습니다.");
        System.out.println("통장내역을 출력합니다.");
        System.out.println("=========================================");
        for (Account account : list) {
            System.out.print("아이디: " +account.getId());
            System.out.println(" | 이름: " + account.getName() + " | 계좌번호: " + account.getBankbook() + " | 잔액: "+ account.getBalance()+"원");

        }


    }
}
