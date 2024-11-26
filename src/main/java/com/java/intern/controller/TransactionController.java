package com.java.intern.controller;

import com.java.intern.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.AES;

import javax.crypto.SecretKey;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    private static final SecretKey aesKey; // Khóa AES (có thể lưu trữ trong biến môi trường)

    static {
        try {
            aesKey = AES.createAESKey();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize AES key", e);
        }
    }

    // Phương thức POST để thêm giao dịch
    @PostMapping("/add")
    public String addTransaction(@RequestBody request request) {
        try {
            // Giải mã thông tin tài khoản từ request body
            String transactionId = request.getTransactionId(); // Giả sử transactionId không cần mã hóa
            String accountSource = AES.decrypt(request.getAccountSource(), aesKey);
            String accountDestination = AES.decrypt(request.getAccountDestination(), aesKey);


            // Lấy thời gian phát sinh giao dịch
            LocalDateTime time = LocalDateTime.now();

            // Thực hiện giao dịch chuyển tiền
            transactionService.transferMoney(accountSource, accountDestination, request.getAmount(), transactionId);

            return "Transaction saved successfully!";
        } catch (Exception e) {
            return "Error while processing the transaction: " + e.getMessage();
        }
    }
}