package com.example.mycollegex.models;

public class UsersItem {
    String displayName,uid;
    String contactNumber;
    String collegeEmail;
    String password;
    public  String imageUrl ;

    public UsersItem(String displayName, String uid, String contactNumber, String collegeEmail, String password , String imageUrl) {
        this.displayName = displayName;
        this.uid = uid;
        this.contactNumber = contactNumber;
        this.collegeEmail = collegeEmail;
        this.password = password;
        this.imageUrl= imageUrl;
    }

    public UsersItem() {
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUid() {
        return uid;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCollegeEmail() {
        return collegeEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
