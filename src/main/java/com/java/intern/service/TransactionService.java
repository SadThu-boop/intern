package com.java.intern.service;

import com.java.intern.entity.Transaction;
import com.java.intern.repository.TransactionRepo;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepo transactionRepository;

    @Transactional
    public void transferMoney(String accountSource, String accountDestination, Double amount, String transactionId) {
        try {
            // Giao dịch cho tài khoản nguồn (nợ)
            Transaction transactionSource = new Transaction();
            transactionSource.setAccount(accountSource);
            transactionSource.setInDebt(amount);
            transactionSource.setHave(500.0);
            transactionSource.setTransactionID(transactionId);
            transactionSource.setTime(Timestamp.valueOf(LocalDateTime.now()));

            // Giao dịch cho tài khoản đích (có)
            Transaction transactionDestination = new Transaction();
            transactionDestination.setAccount(accountDestination);
            transactionDestination.setInDebt(200.0);
            transactionDestination.setHave(amount);
            transactionDestination.setTransactionID(transactionId);
            transactionDestination.setTime(Timestamp.valueOf(LocalDateTime.now()));

            // Lưu vào database
            transactionRepository.save(transactionSource);
            transactionRepository.save(transactionDestination);

            // Log thông tin giao dịch
            logger.info("Successfully processed transaction {}. Source: {} owes {}, Destination: {} receives {}",
                    transactionId,
                    accountSource,
                    amount,
                    accountDestination,
                    amount);
        } catch (Exception e) {
            // Log lỗi
            logger.error("Error processing transaction {} for source account {} and destination account {}",
                    transactionId,
                    accountSource,
                    accountDestination,
                    e);
            throw new RuntimeException("Error processing transaction", e);
        }
    }
}
