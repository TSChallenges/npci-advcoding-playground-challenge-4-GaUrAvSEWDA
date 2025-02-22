package com.bankmgmt.app.entity;

public class Account {
    private Integer id;
    private String accountHolderName;
    private String accountType;
    private Double balance;
    private String email;

    // Constructors, getters, and setters

    public Account(Integer id, String accountHolderName, String accountType, Double balance, String email) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
        this.email = email;
    }

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        if (accountType != null) {
            this.accountType = accountType.toUpperCase(); // Normalize input
        } else {
            throw new IllegalArgumentException("Account type cannot be null.");
        }
    }


    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        if (balance != null && balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // TODO: Add getters and setters


}
