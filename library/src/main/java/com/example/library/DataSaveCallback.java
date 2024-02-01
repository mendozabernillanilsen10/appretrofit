package com.example.library;

public interface DataSaveCallback {
    void onDataSaveComplete(String message);
    void onDataSaveError(Exception e);
}
