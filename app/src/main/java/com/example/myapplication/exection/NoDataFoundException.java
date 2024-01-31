package com.example.myapplication.exection;

import androidx.annotation.NonNull;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException() {
        super();
    }
    public NoDataFoundException(String message) {
        super(message);
    }
    public NoDataFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoDataFoundException(Throwable cause) {
        super(cause);
    }
    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
