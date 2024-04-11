package chap_02.bank.service.refac;

import chap_02.bank.service.refac.acount.Account;
import chap_02.bank.service.refac.acount.MinusAccount;
import chap_02.bank.service.refac.acount.NormalAccount;

public class Config {

    private Account account(){
        return new NormalAccount();
    }
    public Banker banker(String name){
        return new Banker(name,account());
    }
}
