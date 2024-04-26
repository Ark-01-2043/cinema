package com.jpn2018.hoadonservice.exception;

public class ThanhVienNotFoundException extends Exception {
    public ThanhVienNotFoundException() {
    }

    public ThanhVienNotFoundException(String message) {
        super(message);
    }

    public ThanhVienNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThanhVienNotFoundException(Throwable cause) {
        super(cause);
    }

    public ThanhVienNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
