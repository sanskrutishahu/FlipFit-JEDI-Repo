package com.flipkart.dao;

import com.flipkart.bean.User;

public interface FlipFitUserDAOInterface {

    public int authenticateUser(String email, String password, int roleId);

    public int createUser(User user);
}
