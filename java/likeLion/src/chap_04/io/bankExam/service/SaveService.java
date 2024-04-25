package chap_04.io.bankExam.service;

import chap_04.io.bankExam.Account.Account;
import chap_04.io.bankExam.Account.AccountRepository;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import static chap_04.io.address.output;

public class SaveService {
    private final AccountRepository repository = new AccountRepository();

    public void save(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output));){
            List<Account> list = repository.findAll();
            oos.writeObject(list);
            System.out.println("저장이 완료되었습니다.");
            oos.flush();


        } catch (Exception e){
            throw new RuntimeException(e);
        }


    }

}
