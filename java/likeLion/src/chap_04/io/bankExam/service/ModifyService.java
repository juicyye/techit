package chap_04.io.bankExam.service;

import chap_04.io.bankExam.Account.AccountRepository;

public class ModifyService {
    private AccountRepository repository = new AccountRepository();

    public void modify(Long id, String name) {
        repository.modify(id,name);
    }
}
