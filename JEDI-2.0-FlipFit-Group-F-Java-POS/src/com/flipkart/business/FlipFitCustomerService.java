package com.flipkart.business;

import com.flipkart.bean.FlipFitGymDetails;

import java.util.HashMap;
import java.util.List;

public class FlipFitCustomerService implements FlipFitCustomerInterface {


    public void createCustomer(int userId, String name, String phoneNumber, String address) {
        System.out.println("Customer Details are added!");
    }

    public void editProfile(int userId, String name, String phoneNumber, String address) {
        System.out.println("Customer details are updated!");
    }

    public void viewProfile(int userId) {

    }

    public List<FlipFitGymDetails> viewGyms() {
        return null;
    }

    public HashMap<String, Integer> viewSlots(int gymId, String date) {
        return null;
    }


    public void filterSlots() {
        System.out.println("All slots filtered");
    }
}
