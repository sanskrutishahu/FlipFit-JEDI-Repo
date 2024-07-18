package com.flipkart.bean;

public class FlipFitCustomer extends User{
    private int weight;
    private String aadhaarNumber;

    public FlipFitCustomer(int userId, int roleId, String userPhoneNumber, String userAddress,
                           String userEmail, String userPassword, String userName,int weight, String aadhaarNumber) {
        super(userId, roleId, userPhoneNumber, userAddress, userEmail, userPassword, userName);
        this.weight = weight;
        this.aadhaarNumber = aadhaarNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

}