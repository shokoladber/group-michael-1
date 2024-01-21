package org.launchcode.model;

import lombok.Getter;

@Getter
public class ApplicationForm {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String organization;
    private String message;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}