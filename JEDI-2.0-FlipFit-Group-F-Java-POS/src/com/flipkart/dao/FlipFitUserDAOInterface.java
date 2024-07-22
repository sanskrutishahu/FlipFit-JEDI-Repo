package com.flipkart.dao;

import com.flipkart.bean.User;

/**
 * This interface defines methods to interact with user-related data in the FlipFit application.
 */
public interface FlipFitUserDAOInterface {

    /**
     * Authenticates a user based on email, password, and role ID.
     *
     * @param userEmail    The email of the user to authenticate.
     * @param userPassword The password of the user to authenticate.
     * @param roleId       The role ID of the user to authenticate.
     * @return If authentication succeeds, returns the user ID; if the password does not match, returns -1; if user not found, returns 0.
     */
    public int authenticateUser(String userEmail, String userPassword, int roleId);

    /**
     * Creates a new user in the database.
     *
     * @param userId      The ID of the user being created.
     * @param userEmail   The email of the user being created.
     * @param userPassword The password of the user being created.
     * @param roleId       The role ID of the user being created.
     * @return The generated user ID if creation is successful, otherwise returns 0.
     */
    public int createUser(int userId, String userEmail, String userPassword, int roleId);

    /**
     * Changes the password of a user in the database.
     *
     * @param userId      The ID of the user whose password is being changed.
     * @param userPassword The new password for the user.
     * @return True if password change is successful, false otherwise.
     */
    public boolean changeUserPassword(int userId, String userPassword);
}
