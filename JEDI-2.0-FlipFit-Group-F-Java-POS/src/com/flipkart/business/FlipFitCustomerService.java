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

public class FlipFitCustomerService implements FlipFitCustomerInterface {

    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();
    FLipFitGymOwnerDAOInterface gymOwnerDAO = new FlipFitGymOwnerDAOImpl();

    @Override
    public void createCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
        customerDAO.createCustomer(weight, age, gender, customerName, customerPhone, customerAddress,customerId);
    }

    @Override
    public void editProfile(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
        customerDAO.editProfile(weight, age, gender, customerName,customerPhone, customerAddress, customerId);
        System.out.println("Customer Details are added!");
    }

    @Override
    public FlipFitCustomer viewProfile(int userId) {
        return customerDAO.viewProfile(userId);
    }

    @Override
    public List<FlipFitGymDetails> viewGyms() {
        return customerDAO.viewGyms();
    }


    @Override
    public void viewSlots(int gymId, String date) {
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

    @Override
    public void filterSlots() {
        System.out.println("All slots filtered");
    }
}
