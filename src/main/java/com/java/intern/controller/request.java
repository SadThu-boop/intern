package com.java.intern.controller;

import lombok.Data;

@Data
public class request {
    private String transactionId;
    private String accountSource;
    private String accountDestination;
    private double amount;

    public String getAccountSource() {
        return accountSource;
    }

    public void setAccountSource(String accountSource) {
        this.accountSource = accountSource;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(String accountDestination) {
        this.accountDestination = accountDestination;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter and Setter methods
}

