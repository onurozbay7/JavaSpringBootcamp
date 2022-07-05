package com.logo.Service;

import com.logo.Model.Account;
import com.logo.Repository.AccountHibernateRepository;
import com.logo.Repository.AccountJdbcRepository;
import com.logo.Repository.AccountJdbcTemplateRepository;
import com.logo.Repository.AccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountHibernateRepository accountHibernateRepository; // Hibernate

    @Autowired
    AccountJdbcRepository accountJdbcRepository; // JDBC

    @Autowired
    AccountJdbcTemplateRepository accountJdbcTemplateRepository; // JdbcTemplate

    public Account createAccount(Account accountRequest) {
       // return accountHibernateRepository.save(accountRequest); // HIBERNATE

       // return accountJdbcRepository.save(accountRequest); // JDBC

        return accountJdbcTemplateRepository.save(accountRequest); //JdbcTemplate
    }

    public List<Account> getAllAcounts() {
       // return accountHibernateRepository.findAll(); // HIBERNATE

         return accountJdbcRepository.findAll(); // JDBC

       // return accountJdbcTemplateRepository.findAll(); //JdbcTemplate
    }

    public Account getAccountById(int id) {
        return accountHibernateRepository.findById(id); // HIBERNATE

       // return accountJdbcRepository.findById(id); // JDBC

       // return accountJdbcTemplateRepository.findById(id); //JdbcTemplate
    }

    public Account updateAccount(int id, Account accountRequest) {
        // return accountHibernateRepository.update(id,accountRequest); // HIBERNATE

        // return accountJdbcTemplateRepository.update(id, accountRequest); // JDBC

        return accountJdbcTemplateRepository.update(id,accountRequest); //JdbcTemplate

    }

    public String deleteAccount(int id) {
       // return accountHibernateRepository.deleteById(id); // HIBERNATE

       // return accountJdbcRepository.deleteById(id); // JDBC

        return accountJdbcTemplateRepository.deleteById(id); //JdbcTemplate
    }
}
