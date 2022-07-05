package com.logo.Repository;

import com.logo.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountHibernateRepository implements IDao<Account,Integer> {

    @Autowired
    AccountJpaRepository accountJpaRepository;

    @Override
    public Account save(Account account) {
        return accountJpaRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountJpaRepository.findAll();
    }

    @Override
    public Account findById(int id) {
        return accountJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public Account update(int id, Account accountRequest) {
        Account foundAccount = accountJpaRepository.findById(id).orElseThrow();

        foundAccount.setAccountName(accountRequest.getAccountName());
        foundAccount.setAccountNumber(accountRequest.getAccountNumber());
        foundAccount.setCurrencyType(accountRequest.getCurrencyType());
        foundAccount.setIban(accountRequest.getIban());
        foundAccount.setBalance(accountRequest.getBalance());

        return accountJpaRepository.save(foundAccount);
    }

    @Override
    public String deleteById(int id) {
        accountJpaRepository.deleteById(id);

        return id + " id'li hesap silindi.";
    }
}
