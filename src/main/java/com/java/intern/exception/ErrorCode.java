package com.java.intern.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Getter;

@Getter
public enum ErrorCode { // Error codes for module
    // Error codes for product
    PRODUCT_NAME_BLANK(400, "Product name cannot be blank", HttpStatus.BAD_REQUEST),
    PRICE_INVALID(400, "Price must be greater than 0", HttpStatus.BAD_REQUEST),
    BRAND_BLANK(400, "Brand cannot be blank", HttpStatus.BAD_REQUEST),
    DESCRIPTION_TOO_LONG(400, "Description must not exceed 500 characters", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(500, "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),

    // Error codes for image upload
    MAX_UPLOAD_LIMIT_EXCEEDED(400, "You can upload a maximum of 10 images at once", HttpStatus.BAD_REQUEST),
    INVALID_FILE_TYPE(400, "Only JPG files are allowed", HttpStatus.BAD_REQUEST),
    IMAGE_UPLOAD_FAILED(500, "Failed to upload image due to a server error", HttpStatus.INTERNAL_SERVER_ERROR);

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
