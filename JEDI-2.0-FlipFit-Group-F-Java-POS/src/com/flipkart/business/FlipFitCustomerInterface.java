package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.SlotDetails;

import java.util.HashMap;
import java.util.List;

public interface FlipFitCustomerInterface {


    public void createCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId);

    public void editProfile(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId);

    public FlipFitCustomer viewProfile(int userId);

    public List<FlipFitGymDetails> viewGyms();

    public void viewSlots(int gymId, String date);

    public void filterSlots();
}

