package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class AccountInfo {

    BigDecimal balance;
    int userId;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "balance=" + balance +
                ", userId=" + userId +
                '}';
    }
}

