package org.launchcode.model;


public class Application {


    private String fullName;
    private String affiliation;
    private String position;
    private String phoneNumber;
    private String email;
    private String introduction;

    private ProfessionalReference reference1;
    private ProfessionalReference reference2;



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public ProfessionalReference getReference1() {
        return reference1;
    }

    public void setReference1(ProfessionalReference reference1) {
        this.reference1 = reference1;
    }

    public ProfessionalReference getReference2() {
        return reference2;
    }

    public void setReference2(ProfessionalReference reference2) {
        this.reference2 = reference2;
    }
}
