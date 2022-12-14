package spring.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.springsecurity.entity.Account;
import spring.springsecurity.repository.AccountRepository;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    @GetMapping("/accounts")
    public String getAccounts(){
        return "Here are the accounts detail from the DB";
    }

    @PostMapping("/accounts")
    public String registerCustomer(@RequestBody Account account){
        Account accountSave = accountRepository.save(account);
        if(accountSave.getId() > 0) {
            return "Register success";
        }
        return "Register error";
    }
}
