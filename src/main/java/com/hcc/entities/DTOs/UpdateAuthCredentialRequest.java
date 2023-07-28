package com.hcc.entities.DTOs;

public class UpdateAuthCredentialRequest {
    private String AUTHORITY_REQUEST;
    private String username;

    public UpdateAuthCredentialRequest(String AUTHORITY_REQUEST , String username) {
        this.AUTHORITY_REQUEST = AUTHORITY_REQUEST;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAUTHORITY_REQUEST() {
        return AUTHORITY_REQUEST;
    }

    public void setAUTHORITY_REQUEST(String AUTHORITY_REQUEST) {
        this.AUTHORITY_REQUEST = AUTHORITY_REQUEST;
    }
}
