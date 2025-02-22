package com.bankmgmt.app.rest;

import com.bankmgmt.app.entity.Account;
import com.bankmgmt.app.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: Make this class a Rest Controller
@RestController
public class BankController {

    // TODO Autowired the BankService class
    @Autowired
    private BankService bankService;

    // TODO: API to Create a new account
    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account newAccount = bankService.createAccount(account.getAccountHolderName(),account.getAccountType(),account.getEmail(),account.getBalance());

        return  new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }
    // TODO: API to Get all accounts
    
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = bankService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // TODO: API to Get an account by ID
    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer id){
        Account account = bankService.getAccountById(id);
        if(account == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // TODO: API to Deposit money
    @PutMapping("/account/deposit/{id}")
    public ResponseEntity<Account> depositMoneyAccount(@PathVariable Integer id, @RequestParam Double amount){
        Account account = bankService.depositMoneyAccount(id, amount);
        if(account == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // TODO: API to Withdraw money
    @PutMapping("/account/withdraw/{id}")
    public ResponseEntity<Account> withdrawMoneyAccount(@PathVariable Integer id, @RequestParam Double amount){
        Account account = bankService.withdrawMoneyAccount(id, amount);
        if(account == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // TODO: API to Transfer money between accounts
    @PutMapping("/account/transfer/{fromId}/{toId}")
    public ResponseEntity<Account> transferMoneyAccount(@PathVariable Integer fromId, @PathVariable Integer toId, @RequestParam Double amount){
        Account account = bankService.transferMoney(fromId, toId, amount);
        if(account == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // TODO: API to Delete an account
    @DeleteMapping("/account/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable Integer id){
        Account account = bankService.deleteAccount(id);
        if(account == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    
}
