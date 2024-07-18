
package com.flipkart.bean;

public class FlipFitAdmin{

    private String customUserName;
    private int adminId;

    public FlipFitAdmin(String customUserName, int adminId) {
        this.customUserName = customUserName;
        this.adminId = adminId;
    }

    public String getCustomUserName() {
        return customUserName;
    }

    public void setCustomUserName(String customUserName) {
        this.customUserName = customUserName;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}