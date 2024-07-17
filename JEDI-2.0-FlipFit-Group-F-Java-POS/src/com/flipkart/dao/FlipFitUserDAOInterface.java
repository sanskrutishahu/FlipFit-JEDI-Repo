package com.flipkart.dao;

public interface FlipFitUserDAOInterface {

    public int authenticateUser(String email, String password, int roleId);

    public int createUser(String name, String password, int roleId);
}
