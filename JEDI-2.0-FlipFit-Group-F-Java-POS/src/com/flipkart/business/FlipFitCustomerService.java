package com.flipkart.business;

import com.flipkart.bean.FlipFitGymDetails;

import java.util.HashMap;
import java.util.List;

public class FlipFitCustomerService implements FlipFitCustomerInterface {

    @Override
    public void createCustomer(int userId, String name, String phoneNumber, String address) {

    }

    @Override
    public void editProfile(int userId, String name, String phoneNumber, String address) {

    }

    @Override
    public void viewProfile(int userId) {

    }

    @Override
    public List<FlipFitGymDetails> viewGyms() {
        return List.of();
    }

    @Override
    public HashMap<String, Integer> viewSlots(int gymId, String date) {
        return null;
    }

    @Override
    public void filterSlots() {

    }
}
