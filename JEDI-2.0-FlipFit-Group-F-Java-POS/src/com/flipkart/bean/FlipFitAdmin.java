
package com.flipkart.bean;

public class FlipFitAdmin extends User{

    private String customUserName;

    public FlipFitAdmin(int userId, int roleId, String userPhoneNumber, String userAddress,
                        String userEmail, String userPassword, String userName, String customerUserName) {
        super(userId, roleId, userPhoneNumber, userAddress, userEmail, userPassword,  userName);
        this.customUserName = customerUserName;
    }

    public String getCustomUserName() {
        return customUserName;
    }

    public void setCustomUserName(String customUserName) {
        this.customUserName = customUserName;
    }

}