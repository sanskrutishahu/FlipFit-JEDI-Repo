package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;

import java.util.HashMap;
import java.util.List;

public interface FlipFitCustomerInterface {


    public void createCustomer(FlipFitCustomer flipFitCustomer);


    public void editProfile(FlipFitCustomer flipFitCustomer);


    public FlipFitCustomer viewProfile(int userId);

    public List<FlipFitGymDetails> viewGyms();

    public HashMap<String, Integer> viewSlots(int gymId, String date);


    public void filterSlots();
}

