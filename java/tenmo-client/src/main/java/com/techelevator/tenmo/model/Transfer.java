package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private Long transferId;
    private Long transferTypeId;
    private Long transferStatusId;
    private int accountTo;
    private int accountFrom;
    private BigDecimal transferAmount;

    //CONSTRUCTOR
    public Transfer(Long transferId, Long transferTypeId, Long transferStatusId, int accountTo, int accountFrom, BigDecimal transferAmount) {
        this.transferId = transferId;
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
        this.accountTo = accountTo;
        this.accountFrom = accountFrom;
        this.transferAmount = transferAmount;
    }

    public Transfer(int accountTo, int accountFrom, BigDecimal amount) {
        this.transferTypeId = 1L;
        this.transferStatusId = 1L;
        this.accountTo = accountTo;
        this.accountFrom = accountFrom;
        this.transferAmount = amount;

    }

    //GETTERS AND SETTERS
    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public Long getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(Long transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public Long getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(Long transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    @Override
    public String toString() {
        return "Transfers{" +
                "transferId=" + transferId +
                ", transferTypeId=" + transferTypeId +
                ", transferStatusId=" + transferStatusId +
                ", accountTo=" + accountTo +
                ", accountFrom=" + accountFrom +
                ", transferAmount=" + transferAmount +
                '}';
    }
}
