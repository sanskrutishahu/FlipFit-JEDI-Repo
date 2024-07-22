package com.flipkart.business;

import com.flipkart.bean.User;

/**
 * Interface for method related to Login and register
 */
public interface FlipFituserInterface {

    /**
     * Method to authenticate User
     * @param userEmail
     * @param userPassword
     * @param roleId
     * @return status
     */
    public int authenticateUser(String userEmail, String userPassword, int roleId);

    /**
     * Method to create User
     * @param userId
     * @param userEmail
     * @param userPassword
     * @param roleId
     * @return status
     */
    public int createUser(int userId, String userEmail, String userPassword, int roleId);

    /**
     * Method to change User Password
     * @param userId
     * @param userPassword
     * @return status
     */
    public boolean changeUserPassword(int userId, String userPassword);
}
