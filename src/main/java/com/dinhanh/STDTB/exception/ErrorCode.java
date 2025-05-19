package com.dinhanh.STDTB.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized Error"),
    USER_EXISTED(1001,"User already exists"),
    INVALID_KEY(1002,"INVALID MESSAGE KEY"),
    USERNAME_INVALID(1003,"Username is invalid, at least 3 characters"),
    INVALID_PASSWORD(1004,"Password must be at least 8 characters"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
