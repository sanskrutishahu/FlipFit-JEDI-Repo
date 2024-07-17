package com.flipkart.bean;

public class User {

    private int userId;
    private String userEmail;
    private String userPassword;
    private int roleId;

    public User(int userId, String userEmail, int roleId, String userPassword) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.roleId = roleId;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
