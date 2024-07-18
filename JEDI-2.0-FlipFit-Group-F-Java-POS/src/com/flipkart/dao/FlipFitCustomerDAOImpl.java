package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;

import java.util.HashMap;
import java.util.List;

public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAOInterface{

    @Override
    public void createCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {

    }

    @Override
    public void editProfile(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {

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

    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) {
        return 0;
    }

}
