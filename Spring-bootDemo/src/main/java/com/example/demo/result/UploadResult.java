package com.example.demo.result;

public class UploadResult {
    private boolean success;
    private String error;
    private String plate;

    public boolean isSuccess() {
        return success;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public UploadResult(boolean success, String error, String plate, String url) {
        this.success = success;
        this.error = error;
        this.plate = plate;
        this.url = url;
    }

    public UploadResult(boolean success, String error, String url) {
        this.success = success;
        this.error = error;
        this.url = url;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
}
