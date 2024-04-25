package chap_04.io.bankExam.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {
    private static Map<Long, Account> store = new HashMap<>();
    private static Long sequence = 0L;

    public Long save(String name, long balance, String bankbook) {
        Account account = new Account(++sequence, name, balance, bankbook);
        store.put(account.getId(), account);
        return account.getId();
    }

    public Account findById(Long id) {
        return store.get(id);
    }

    public List<Account> findAll(){
        return new ArrayList<>(store.values());
    }
    public void modify(Long id, String name){
        Account account = store.get(id);
        account.setName(name);
    }

    public void delete(Long id) {
        store.remove(id);
    }

    public void load(Account account) {
        Account loadAccount = new Account(account.getId(), account.getName(), account.getBalance(), account.getBankbook());
        store.put(loadAccount.getId(), loadAccount);
        sequence = loadAccount.getId();

    }
}
