
package com.flipkart.bean;

public class FlipFitAdmin {


    private String customerUserName;
    private int userId;

    public FlipFitAdmin(String customerUserName, int userId) {
        this.customerUserName = customerUserName;
        this.userId = userId;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}