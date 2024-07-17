package com.flipkart.bean;

public class FlipFitCustomer {
    private int weight;
    private String aadhaarNumber;
    private int userId;

    public FlipFitCustomer(int weight, String aadhaarNumber, int userId) {
        this.weight = weight;
        this.aadhaarNumber = aadhaarNumber;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}