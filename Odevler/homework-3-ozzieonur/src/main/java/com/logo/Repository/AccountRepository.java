package com.logo.Repository;


import com.logo.Model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository {
    static List<Account> accountList = new ArrayList<>(10);

    public Account save(Account accountRequest) {
        accountList.add(accountRequest);

        return accountRequest;
    }

    public List<Account> findAll() {
        return accountList;
    }

    public Account findById(int id) {
        return accountList.stream().filter(account -> account.getId() == id).findFirst().orElseThrow();
    }

    public Account update(int id, Account accountRequest) {

        Account account = accountList.stream().filter(acc -> acc.getId() == id).findFirst().orElseThrow();

        account.setAccountName(accountRequest.getAccountName());
        account.setAccountNumber(accountRequest.getAccountNumber());
        account.setIban(accountRequest.getIban());
        account.setBalance(accountRequest.getBalance());
        account.setCurrencyType(accountRequest.getCurrencyType());

        return account;
    }

    public Account delete(int id) {
        Account account = accountList.stream().filter(acc -> acc.getId() == id).findFirst().orElseThrow();
        accountList.remove(account);

        return account;
    }
}
