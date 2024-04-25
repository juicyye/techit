package chap_04.io.bankExam.service;

import chap_04.io.bankExam.Account.Account;
import chap_04.io.bankExam.Account.AccountRepository;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import static chap_04.io.address.output;

public class LoadService {
    private AccountRepository repository = new AccountRepository();

    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(output))) {
            List<Account> accountList = new ArrayList<>(); // ArrayList를 사용하여 객체를 읽어올 List 생성
            while (true) {
                try {
                    // 파일에서 읽어온 객체가 ArrayList인 경우에 대비하여 List로 읽어옴
                    List<Account> accounts = (List<Account>) ois.readObject();
                    accountList.addAll(accounts); // 읽어온 객체들을 List에 추가

                } catch (EOFException e) {
                    // 파일의 끝에 도달하면 EOFException이 발생하고 루프를 종료합니다.
                    break;
                }
            }

            // 읽어온 Account 객체들을 repository에 추가
            for (Account account : accountList) {
                repository.load(account);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}