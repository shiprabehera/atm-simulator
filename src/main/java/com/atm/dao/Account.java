package com.atm.dao;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @Column(name = "account_no", nullable = false)
    private int accountNo;

    @Column(name = "pin", nullable = false)
    private int pin;

    @Column(name = "balance", nullable = false)
    private float balance;

    @Column(name = "account_type", nullable = false)
    private String type;

    @Column(name = "user_id", nullable = false)
    private int userId;

    //getters and setters
    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
