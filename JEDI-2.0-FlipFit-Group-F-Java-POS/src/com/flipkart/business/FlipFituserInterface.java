package com.flipkart.business;

public interface FlipFituserInterface {

    public int authenticateUser(String email, String password, int roleId);

    public int createUser(String name, String password, int roleId);
}
