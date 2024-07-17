package com.flipkart.bean;

public class FlipFitCustomer {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNo;
    private int userId;

    public FlipFitCustomer(int customerId, String customerName, String customerAddress, String customerPhoneNo, int userId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNo = customerPhoneNo;
        this.userId = userId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public void setCustomerPhoneNo(String customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}