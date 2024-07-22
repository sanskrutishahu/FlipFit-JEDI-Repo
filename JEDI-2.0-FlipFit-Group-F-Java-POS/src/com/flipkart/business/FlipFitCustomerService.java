package com.flipkart.business;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlipFitCustomerService implements FlipFitCustomerInterface {

    FlipFitCustomerDAOInterface customerDAO = new FlipFitCustomerDAOImpl();

    @Override
    public void createCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
        customerDAO.createCustomer(weight, age, gender, customerName, customerPhone, customerAddress,customerId);
        System.out.println("Customer Details are added!");
    }

    @Override
    public void editProfile(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
        customerDAO.editProfile(weight, age, gender, customerName,customerPhone, customerAddress, customerId);
        System.out.println("Customer Details are added!");
    }

    @Override
    public FlipFitCustomer viewProfile(int userId) {
        return customerDAO.viewProfile(userId);
//        FlipFitCustomer customer = new FlipFitCustomer(
//                60,
//                21,
//                "Male",
//                "ankur",
//                "882034532423",
//                "delhi",
//                43
//        );
//        return customer;
    }

    @Override
    public List<FlipFitGymDetails> viewGyms() {
        return customerDAO.viewGyms();
    }


    @Override
    public HashMap<String, Integer> viewSlots(int gymId, String date) {
        try {
            return customerDAO.viewSlots(gymId,date);
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
