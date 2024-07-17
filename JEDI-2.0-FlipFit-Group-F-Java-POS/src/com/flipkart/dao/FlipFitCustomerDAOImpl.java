package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;

import java.util.HashMap;
import java.util.List;

public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAOInterface{

    @Override
    public void createCustomer(FlipFitCustomer flipFitCustomer) {

    }

    @Override
    public void editProfile(FlipFitCustomer flipFitCustomer) {

    }

    @Override
    public FlipFitCustomer viewProfile(int userId) {
        return null;
    }

    @Override
    public List<FlipFitGymDetails> viewGyms() {
        return List.of();
    }

    @Override
    public HashMap<String, Integer> viewSlots(int gymId, String date) {
        return null;
    }
}
