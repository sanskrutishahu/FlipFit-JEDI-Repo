package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.FlipFitUserDAOImpl;
import com.flipkart.dao.FlipFitUserDAOInterface;

public class FlipFituserService implements FlipFituserInterface{

    FlipFitUserDAOInterface userDAO = new FlipFitUserDAOImpl();

    @Override
    public int authenticateUser(String email, String password, int roleId) {
        try {
            return userDAO.authenticateUser(email, password, roleId);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int createUser(User user) {
        int userId = userDAO.createUser(user);
        if (userId > 0) {
            System.out.println("User created");
            return userId;
        } else {
            System.out.println("User creation failed");
            return 0;
        }
    }
}
