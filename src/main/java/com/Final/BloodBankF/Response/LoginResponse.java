package com.Final.BloodBankF.Response;

import java.util.Optional;

public class LoginResponse {

public String Message;
public Boolean Status ;

    public Optional<Integer> getId() {
        return id;
    }

    public void setId(Optional<Integer> id) {
        this.id = id;
    }

    public Optional<Integer> id;

    public LoginResponse() {
    }

    public LoginResponse(String message, Boolean status  , Optional<Integer> id  ) {
        Message = message;
        Status = status;
        this.id=id;
    }


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "Message='" + Message + '\'' +
                ", Status=" + Status +
                ", id=" + id +
                '}';
    }
}
