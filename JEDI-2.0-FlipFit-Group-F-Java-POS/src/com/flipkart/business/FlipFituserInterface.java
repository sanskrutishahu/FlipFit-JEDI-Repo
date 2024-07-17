package com.flipkart.business;

import com.flipkart.bean.User;

public interface FlipFituserInterface {

    public int authenticateUser(String email, String password, int roleId);

    public int createUser(User user);
}
