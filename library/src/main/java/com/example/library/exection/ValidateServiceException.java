package com.example.library.exection;
import androidx.annotation.NonNull;

public class ValidateServiceException extends RuntimeException {
    public ValidateServiceException() {
        super();
    }
    public ValidateServiceException(String message) {
        super(message);
    }
    public ValidateServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public ValidateServiceException(Throwable cause) {
        super(cause);
    }
    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
