
package com.flipkart.bean;

public class Admin {
	
    private int adminId;

    public Admin(int adminId, String name, String email, String password, String phoneNumber) {
        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

}