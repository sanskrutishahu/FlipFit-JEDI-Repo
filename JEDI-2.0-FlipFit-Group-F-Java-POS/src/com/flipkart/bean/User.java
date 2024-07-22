package com.flipkart.bean;

/**
 * The User class represents a user in the system.
 * It includes information such as the user ID, email, password, and role ID.
 */
public class User {

    private int userId;
    private String userEmail;
    private String userPassword;
    private int roleId;
    /**
     * Constructor to initialize a User object with all fields.
     *
     * @param userId        the unique identifier for the user
     * @param userEmail     the email of the user
     * @param userPassword  the password of the user
     * @param roleId        the role ID associated with the user
     */
    public User(int userId, String userEmail, String userPassword, int roleId) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.roleId = roleId;
    }

    /**
     * Gets the unique identifier for the user.
     *
     * @return the user ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier for the user.
     *
     * @param userId the user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the email of the user.
     *
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets the email of the user.
     *
     * @param userEmail the user email to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets the password of the user.
     *
     * @return the user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the password of the user.
     *
     * @param userPassword the user password to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets the role ID associated with the user.
     *
     * @return the role ID
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID associated with the user.
     *
     * @param roleId the role ID to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
