package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.SlotDetails;
import com.flipkart.dao.FLipFitGymOwnerDAOInterface;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implementation for methods related to Customer
 */
public class FlipFitCustomerService implements FlipFitCustomerInterface {

    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();
    FLipFitGymOwnerDAOInterface gymOwnerDAO = new FlipFitGymOwnerDAOImpl();

    /**
     * Method to create a customer
     * @param weight
     * @param age
     * @param gender
     * @param customerName
     * @param customerPhone
     * @param customerAddress
     * @param customerId
     */
    @Override
    public void createCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
        customerDAO.createCustomer(weight, age, gender, customerName, customerPhone, customerAddress,customerId);
    }

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
    @Override
    public void editProfile(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
        customerDAO.editProfile(weight, age, gender, customerName,customerPhone, customerAddress, customerId);
        System.out.println("Customer Details are added!");
    }

    /**
     * Method to view customer's profile
     * @param userId
     */
    @Override
    public FlipFitCustomer viewProfile(int userId) {
        return customerDAO.viewProfile(userId);
    }

    /**
     * Method to view all the existing gym
     * @return GymList
     */
    @Override
    public List<FlipFitGymDetails> viewGyms() {
        return customerDAO.viewGyms();
    }


    /**
     * Method to view slots of particular Gym Id
     * @param gymId
     * @param date
     */
    @Override
    public void viewSlots(int gymId, String date) {
        if(customerDAO.viewSlots(gymId,date)==null) return;
        if (customerDAO.viewSlots(gymId,date).isEmpty())
        {
            System.out.println("No Slots available right now, please try again later.");
            return;
        }
        System.out.println("-------- All Available Slot Details --------");
        for(SlotDetails x : customerDAO.viewSlots(gymId,date)){
            System.out.println(x);
        }
    }

    /**
     * Method to filter slots of gym
     */
    @Override
    public void filterSlots() {
        System.out.println("All slots filtered");
    }
}
