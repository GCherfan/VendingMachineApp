package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfers {

    private Long transferId;
    private Long transferTypeId;
    private Long transferStatusId;
    private Long accountTo;
    private Long accountFrom;
    private BigDecimal transferAmount;

    //CONSTRUCTOR
    public Transfers(Long transferId, Long transferTypeId, Long transferStatusId, Long accountTo, Long accountFrom, BigDecimal transferAmount) {
        this.transferId = transferId;
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
        this.accountTo = accountTo;
        this.accountFrom = accountFrom;
        this.transferAmount = transferAmount;
    }

    public Transfers(Long accountTo, Long accountFrom, BigDecimal amount) {
        this.transferTypeId = 2L;
        this.transferStatusId = 2L;
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

    public Long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Long accountTo) {
        this.accountTo = accountTo;
    }

    public Long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Long accountFrom) {
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
