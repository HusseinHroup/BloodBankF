package com.Final.BloodBankF.Login;

public class loginMessage {

    private String Message;
    private String status;

    public loginMessage() {
    }

    public loginMessage(String message, String status) {
        Message = message;
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "loginMeassage{" +
                "Message='" + Message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
