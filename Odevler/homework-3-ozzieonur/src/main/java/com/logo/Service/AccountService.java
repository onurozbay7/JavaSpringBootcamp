package com.logo.Service;

import com.logo.Model.Account;
import com.logo.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Account accountRequest) {
        return accountRepository.save(accountRequest);
    }

    public List<Account> getAllAcounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(int id) {
        return accountRepository.findById(id);
    }

    public Account updateAccount(int id, Account accountRequest) {
        return accountRepository.update(id,accountRequest);
    }

    public Account deleteAccount(int id) {
        return accountRepository.delete(id);
    }
}
