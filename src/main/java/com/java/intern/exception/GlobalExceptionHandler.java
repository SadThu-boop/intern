//package com.java.intern.exception;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import com.java.intern.dto.response.APIResponse;
//
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.extern.slf4j.Slf4j;
//
//@ControllerAdvice
//@Slf4j
//@Tag(name = "Global Exception Handler", description = "Handles all exceptions for the application")
//public class GlobalExceptionHandler {
//
//    // Xử lý các ngoại lệ liên quan đến validation
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Validation Error")})
//    public ResponseEntity<APIResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        APIResponse apiResponse = new APIResponse();
//
//        // Duyệt qua tất cả các lỗi và lưu vào map
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//            String field = error.getField();
//            String message = error.getDefaultMessage();
//
//            ErrorCode errorCode;
//
//            // Xác định mã lỗi dựa vào trường bị lỗi
//            switch (field) {
//                case "productName":
//                    errorCode = ErrorCode.PRODUCT_NAME_BLANK; // Tên sản phẩm không được để trống
//                    break;
//                case "price":
//                    errorCode = ErrorCode.PRICE_INVALID; // Giá tiền không hợp lệ
//                    break;
//                case "brand":
//                    errorCode = ErrorCode.BRAND_BLANK; // Thương hiệu không được để trống
//                    break;
//                case "description":
//                    errorCode = ErrorCode.DESCRIPTION_TOO_LONG; // Mô tả quá dài
//                    break;
//                default:
//                    errorCode = ErrorCode.INTERNAL_SERVER_ERROR; // Mặc định nếu không có lỗi cụ thể
//            }
//
//            // Gán mã lỗi và thông báo lỗi vào APIResponse
//            apiResponse.setCode(errorCode.getCode());
//            apiResponse.setMessage(errorCode.getMessage());
//
//            // Ghi log lỗi chi tiết
//            log.error("Validation error on field: {} - {}", field, message);
//        }
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse); // Trả về lỗi 400
//    }
//
//    // Xử lý các ngoại lệ không xác định
//    @ExceptionHandler(value = RuntimeException.class)
//    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal Server Error")})
//    public ResponseEntity<APIResponse> handleRuntimeException(RuntimeException exception) {
//        log.error("Unhandled RuntimeException: ", exception);
//
//        APIResponse apiResponse = new APIResponse();
//        apiResponse.setCode(ErrorCode.INTERNAL_SERVER_ERROR.getCode());
//        apiResponse.setMessage(ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse); // Trả về lỗi 500
//    }
//
//}
