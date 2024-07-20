package com.flipkart.dao;

import com.flipkart.bean.User;

public interface FlipFitUserDAOInterface {

    public int authenticateUser(String userEmail, String userPassword, int roleId);

    public int createUser(int userId, String userEmail, String userPassword, int roleId);

    public boolean changeUserPassword(int userId, String userPassword);
}
