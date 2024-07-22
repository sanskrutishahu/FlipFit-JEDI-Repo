
package com.flipkart.bean;
/**
 * The FlipFitAdmin class represents an administrator in the FlipFit system.
 * It includes details such as the custom username and admin ID.
 */
public class FlipFitAdmin{
    /** The custom username for the admin */
    private String customUserName;
    /** The unique identifier for the admin */
    private int adminId;
    /**
     * Constructor to initialize a FlipFitAdmin object with all fields.
     *
     * @param customUserName the custom username for the admin
     * @param adminId        the unique identifier for the admin
     */
    public FlipFitAdmin(String customUserName, int adminId) {
        this.customUserName = customUserName;
        this.adminId = adminId;
    }

    /**
     * Gets the custom username of the admin.
     *
     * @return the custom username
     */
    public String getCustomUserName() {
        return customUserName;
    }
    /**
     * Sets the custom username of the admin.
     *
     * @param customUserName the custom username to set
     */
    public void setCustomUserName(String customUserName) {
        this.customUserName = customUserName;
    }
    /**
     * Gets the admin ID.
     *
     * @return the admin ID
     */
    public int getAdminId() {
        return adminId;
    }
    /**
     * Sets the admin ID.
     *
     * @param adminId the admin ID to set
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}