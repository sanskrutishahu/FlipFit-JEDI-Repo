package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.FlipFitUserDAOImpl;
import com.flipkart.dao.FlipFitUserDAOInterface;

/**
 * Implementation for methods related to login and register
 */
public class FlipFituserService implements FlipFituserInterface{

    FlipFitUserDAOInterface userDAO = new FlipFitUserDAOImpl();

    /**
     * Method to authenticate User
     * @param userEmail
     * @param userPassword
     * @param roleId
     * @return status
     */
    @Override
    public int authenticateUser( String userEmail, String userPassword, int roleId) {
        try {
            int i = userDAO.authenticateUser(userEmail,userPassword,roleId);
            if(i<0)
            {
                System.out.println("Incorrect Password!!");
                return -1;
            }
            else if(i==0)
            {
                System.out.println("User is not registered!!");
                return 0;
            }
            return i;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    /**
     * Method to create User
     * @param userId
     * @param userEmail
     * @param userPassword
     * @param roleId
     * @return status
     */
    @Override
    public int createUser(int userId, String userEmail, String userPassword, int roleId) {
        int userStatus = userDAO.createUser(userId,userEmail,userPassword,roleId);
        if (userStatus > 0) {
            System.out.println("User created Successfully!!");
            System.out.println("Your Unique ID is " + userId);
            return userStatus;
        } else {
            System.out.println("User creation failed");
            return 0;
        }
    }

    /**
     * Method to change User Password
     * @param userId
     * @param userPassword
     * @return status
     */
    @Override
    public boolean changeUserPassword(int userId, String userPassword)
    {
        boolean changeStatus = userDAO.changeUserPassword(userId,userPassword);
        if (changeStatus) {
            System.out.println("Password changed Successfully!!");
            return true;
        } else {
            System.out.println("Unable to change password, Please try again.");
            return false;
        }
    }
}
