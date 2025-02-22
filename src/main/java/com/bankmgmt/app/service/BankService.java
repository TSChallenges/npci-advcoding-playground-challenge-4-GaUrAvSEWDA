package com.bankmgmt.app.service;

import com.bankmgmt.app.entity.Account;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.*;

@Service
public class BankService {

    private List<Account> accounts = new ArrayList<>();
    private Integer currentId = 1;

    // TODO: Method to Create a new Account
    // Account account = new Account();
    public Account createAccount(String accountHolderName, String accountType, String email, Double balance) {
        // Validate email uniqueness
        for (Account acc : accounts) {
            if (acc.getEmail().equalsIgnoreCase(email)) {
                throw new IllegalArgumentException("Email already exists.");
            }
        }

        // Validate account type
        if (!accountType.equalsIgnoreCase("SAVINGS") && !accountType.equalsIgnoreCase("CURRENT")) {
            throw new IllegalArgumentException("Invalid account type. Must be SAVINGS or CURRENT.");
        }

        // Create and add account
        Account account = new Account();
        account.setId(currentId++);
        account.setAccountHolderName(accountHolderName);
        account.setAccountType(accountType.toUpperCase());
        account.setBalance(balance);
        account.setEmail(email);
        accounts.add(account);
        return account;
    }



    // TODO: Method to Get All Accounts
    public List<Account> getAllAccounts() {
        return accounts;
    }

    // TODO: Method to Get Account by ID
    public Account getAccountById(Integer id){
        for(Account curaccount: accounts){
            if(curaccount.getId().equals(id)){
                return curaccount;
            }
        }
        return null;
    }    

    // TODO: Method to Deposit Money to the specified account id
    public Account depositMoneyAccount(Integer id, Double amount){
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");

        for(Account curaccount: accounts){
            if(curaccount.getId().equals(id)){
                curaccount.setBalance(curaccount.getBalance() + amount);
                return curaccount;
            }
        }
        return null;
    }

    // TODO: Method to Withdraw Money from the specified account id
   public Account withdrawMoneyAccount(Integer id, Double amount){
    if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
    for(Account curaccount: accounts){
        if(curaccount.getId().equals(id)){
            if(curaccount.getBalance() >= amount){
                curaccount.setBalance(curaccount.getBalance()-amount);
            }
        }
    }
    return null;
   }    

    // TODO: Method to Transfer Money from one account to another
    public Account transferMoney(Integer fromId, Integer toId, Double amount){
        if (amount <= 0) throw new IllegalArgumentException("Transfer amount must be positive.");
        Account fromAccount = null;
        Account toAccount = null;
        for(Account curaccount: accounts){
            if(curaccount.getId().equals(fromId)){
                fromAccount = curaccount;
            }
            if(curaccount.getId().equals(toId)){
                toAccount = curaccount;
            }
        }

        if(fromAccount != null && toAccount != null){
            if(fromAccount.getBalance() >= amount){
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                return fromAccount;
            }
        }
        return null;    
    }
    
    // TODO: Method to Delete Account given a account id
    public Account deleteAccount(Integer id){
        for(Account curaccount: accounts){
            if(curaccount.getId().equals(id)){
                accounts.remove(curaccount);
                return curaccount;
            }
        }
        return null;
    }

}
