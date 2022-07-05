package com.logo.Controller;


import com.logo.Model.Account;
import com.logo.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account accountRequest){
        return accountService.createAccount(accountRequest);
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAcounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable int id){
        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
   public Account updateAccount(@PathVariable int id, @RequestBody Account accountRequest){
        return accountService.updateAccount(id, accountRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable int id){
        return accountService.deleteAccount(id);
    }
}
