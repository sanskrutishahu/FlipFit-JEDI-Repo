package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.FlipFitUserDAOImpl;
import com.flipkart.dao.FlipFitUserDAOInterface;

public class FlipFituserService implements FlipFituserInterface{

    FlipFitUserDAOInterface userDAO = new FlipFitUserDAOImpl();

    @Override
    public int authenticateUser(int userId, String userEmail, String userPassword, int roleId) {
        try {
            return userDAO.authenticateUser(userId,userEmail,userPassword,roleId);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int createUser(int userId, String userEmail, String userPassword, int roleId) {
        int userStatus = userDAO.createUser(userId,userEmail,userPassword,roleId);
        if (userStatus > 0) {
            System.out.println("User created");
            return userStatus;
        } else {
            System.out.println("User creation failed");
            return 0;
        }
    }
}
