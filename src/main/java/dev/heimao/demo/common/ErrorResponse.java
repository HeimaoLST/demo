package dev.heimao.demo.common;

public class ErrorResponse<T> {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getErrorData() {
        return errorData;
    }

    public void setErrorData(T errorData) {
        this.errorData = errorData;
    }

    private int code;
    private boolean success;
    private String message;
    private T errorData;


    public ErrorResponse() {}



    public ErrorResponse(int code, boolean success, String message, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.errorData = data;
    }
}
