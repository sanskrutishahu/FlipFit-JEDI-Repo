package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymDetails;

import java.util.HashMap;
import java.util.List;

public interface FlipFitCustomerDAOInterface {

    public void createCustomer(int userId, String name, String phoneNumber, String address);

    public void editProfile(int userId, String name, String phoneNumber, String address);

    public List<FlipFitGymDetails> viewGyms();

    public HashMap<String, Integer> viewSlots(int gymId, String date);

}
