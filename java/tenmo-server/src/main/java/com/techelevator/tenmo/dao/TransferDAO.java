package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfers;

import java.math.BigDecimal;

public interface TransferDAO {

    Transfers userTransfers(Transfers newTransfer);

}