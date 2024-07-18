package com.flipkart.business;

import com.flipkart.bean.User;

public interface FlipFituserInterface {

    public int authenticateUser(int userId, String userEmail, String userPassword, int roleId);

    public int createUser(int userId, String userEmail, String userPassword, int roleId);
}
