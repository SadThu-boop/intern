package com.java.intern.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionID; // Mã giao dịch (có thể mã hóa RSA)
    private String account;       // Số tài khoản (có thể mã hóa RSA hoặc AES)
    private Double inDebt;        // Nợ
    private Double have;          // Có
    private Timestamp time;          // Thời gian phát sinh giao dịch (ISO 8601 format)

    // Constructor không tham số (dùng cho serialization/deserialization)
    public Transaction() {}

    // Constructor đầy đủ
    public Transaction(String transactionID, String account, Double inDebt, Double have, Timestamp time) {
        this.transactionID = transactionID;
        this.account = account;
        this.inDebt = inDebt;
        this.have = have;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter và Setter
    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getInDebt() {
        return inDebt;
    }

    public void setInDebt(Double inDebt) {
        this.inDebt = inDebt;
    }

    public Double getHave() {
        return have;
    }

    public void setHave(Double have) {
        this.have = have;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    // Phương thức để in thông tin payload
    @Override
    public String toString() {
        return "TransactionPayload{" +
                "transactionID='" + transactionID + '\'' +
                ", account='" + account + '\'' +
                ", inDebt=" + inDebt +
                ", have=" + have +
                ", time='" + time + '\'' +
                '}';
    }
}

