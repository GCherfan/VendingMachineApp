package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.AccountInfo;

import java.math.BigDecimal;

public interface AccountDAO {

    //GET BALANCE
    AccountInfo getBalance(int user);

    //UPDATE BALANCES
        //ADD
    public double addToBalance(double addBalance, int accountId);
        //SUBTRACT
    public double subtractFromBalance(double subtractBalance, int accountId);

}
