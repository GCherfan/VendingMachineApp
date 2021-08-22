package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfers;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDAO {

    void userTransfers(Transfers transfer);

    List<Transfers> seeTransferHistory();

    Transfers getDetailsByTransferId(long transferId);

}
