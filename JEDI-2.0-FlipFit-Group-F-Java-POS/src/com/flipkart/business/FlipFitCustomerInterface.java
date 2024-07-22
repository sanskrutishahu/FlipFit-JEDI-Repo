package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.SlotDetails;

import java.util.HashMap;
import java.util.List;

public interface FlipFitCustomerInterface {

    /**
     * Method to register a customer
     * @param weight
     * @param age
     * @param gender
     * @param customerName
     * @param customerPhone
     * @param customerAddress
     * @param customerId
     */
    public void createCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId);

    /**
     * Method to edit profile of customer
     * @param weight
     * @param age
     * @param gender
     * @param customerName
     * @param customerPhone
     * @param customerAddress
     * @param customerId
     */
    public void editProfile(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId);

    /**
     * Method to view customer's profile
     * @param userId
     */
    public FlipFitCustomer viewProfile(int userId);

    /**
     * Method to view all the existing gym
     * @return GymList
     */
    public List<FlipFitGymDetails> viewGyms();

    /**
     * Method to view slots of particular Gym Id
     * @param gymId
     * @param date
     */
    public void viewSlots(int gymId, String date);

    /**
     * Method to filter slots of gym
     */
    public void filterSlots();
}

