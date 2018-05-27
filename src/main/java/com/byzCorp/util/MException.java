package com.byzCorp.util;

public class MException extends Exception{

    private String message;
    private String status;
    private boolean success;
    private Integer task;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public MException(String message, String status, boolean success) {

        this.message = message;
        this.status = status;
        this.success = success;
        this.task = null;
    }
}
