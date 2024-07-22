package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.SlotDetails;

import java.util.HashMap;
import java.util.List;

public interface FlipFitCustomerDAOInterface {

    public void createCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId);

    public void editProfile(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId);

    public FlipFitCustomer viewProfile(int userId);

    public List<FlipFitGymDetails> viewGyms();

    List<SlotDetails> viewSlots(int gymId, String date);

//    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment);

}
