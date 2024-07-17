package com.flipkart.business;

import com.flipkart.bean.FlipFitGymDetails;

import java.util.HashMap;
import java.util.List;

public interface FlipFitCustomerInterface {


    public void createCustomer(int userId, String name, String phoneNumber, String address);


    public void editProfile(int userId, String name, String phoneNumber, String address);


    public void viewProfile(int userId);

    public List<FlipFitGymDetails> viewGyms();

    public HashMap<String, Integer> viewSlots(int gymId, String date);


    public void filterSlots();
}

