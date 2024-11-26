package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class Log {

    // Phương thức này dùng để che thông tin nhạy cảm
    public static String maskSensitiveData(String value) {
        if (value == null) {
            return "?";
        }
        return "?"; // Thay tất cả các giá trị bằng dấu "?"
    }

    // Hàm log exception với thông tin che giấu
    public static void logTransactionError(Logger logger, Exception e, String transactionId, String account, Double inDebt, Double have, Timestamp time) {
        logger.error("Error while processing the transaction. TransactionID: {}, Account: {}, InDebt: {}, Have: {}, Time: {}, Error: {}",
                maskSensitiveData(transactionId),
                maskSensitiveData(account),
                maskSensitiveData(inDebt != null ? inDebt.toString() : null),
                maskSensitiveData(have != null ? have.toString() : null),
                maskSensitiveData(time != null ? time.toString() : null),
                e.getMessage(), e);
    }
}
