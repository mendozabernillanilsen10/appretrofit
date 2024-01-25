package com.example.library.exection;


import androidx.annotation.NonNull;

public class GeneralServiceException extends RuntimeException {
    public GeneralServiceException() {
        super();
    }
    public GeneralServiceException(String message) {
        super(message);
    }
    public GeneralServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public GeneralServiceException(Throwable cause) {
        super(cause);
    }
    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
