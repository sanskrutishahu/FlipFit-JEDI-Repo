package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;

import java.util.HashMap;
import java.util.List;

public class FlipFitCustomerService implements FlipFitCustomerInterface {

    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();

    @Override
    public void createCustomer(FlipFitCustomer flipFitCustomer) {
        customerDAO.createCustomer(flipFitCustomer);
        System.out.println("Customer Details are added!");
    }

    @Override
    public void editProfile(FlipFitCustomer flipFitCustomer) {
        customerDAO.editProfile(flipFitCustomer);
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
    public HashMap<String, Integer> viewSlots(int gymId, String date) {
        try {
            return customerDAO.viewSlots(gymId, date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void filterSlots() {
        System.out.println("All slots filtered");
    }
}
