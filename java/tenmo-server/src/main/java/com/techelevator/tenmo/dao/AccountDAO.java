package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.AccountInfo;

import java.math.BigDecimal;

public interface AccountDAO {

    AccountInfo getBalance(int user);
}
