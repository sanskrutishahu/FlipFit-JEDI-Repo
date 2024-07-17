
package com.flipkart.bean;

public class FlipFitAdmin {

    private int adminId;
    private int userId;

    public FlipFitAdmin(int adminId, int userId) {
        this.adminId = adminId;
        this.userId = userId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}