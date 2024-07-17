package com.flipkart.bean;

public class User {

    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;
    private String userPhoneNumber;
    private int roleId;

    public User(int userId, int roleId, String userPhoneNumber, String userAddress, String userEmail, String userPassword, String userName) {
        this.userId = userId;
        this.roleId = roleId;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
