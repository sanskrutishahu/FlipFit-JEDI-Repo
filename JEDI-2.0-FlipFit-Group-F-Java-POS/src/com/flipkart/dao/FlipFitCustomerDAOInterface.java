package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.SlotDetails;

import java.util.HashMap;
import java.util.List;

/**
 * This interface defines the operations that can be performed on FlipFitCustomer entities in the database.
 */
public interface FlipFitCustomerDAOInterface {

    /**
     * Creates a new customer in the database with the provided details.
     *
     * @param weight The weight of the customer.
     * @param age The age of the customer.
     * @param gender The gender of the customer.
     * @param customerName The name of the customer.
     * @param customerPhone The phone number of the customer.
     * @param customerAddress The address of the customer.
     * @param customerId The unique identifier of the customer.
     */
    public void createCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId);

    /**
     * Edits the profile of an existing customer with the provided details.
     *
     * @param weight The updated weight of the customer.
     * @param age The updated age of the customer.
     * @param gender The updated gender of the customer.
     * @param customerName The updated name of the customer.
     * @param customerPhone The updated phone number of the customer.
     * @param customerAddress The updated address of the customer.
     * @param customerId The unique identifier of the customer.
     */
    public void editProfile(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId);

    /**
     * Retrieves the profile of a customer based on the provided user ID.
     *
     * @param userId The ID of the customer whose profile is to be retrieved.
     * @return The FlipFitCustomer object representing the customer's profile, or null if not found.
     */
    public FlipFitCustomer viewProfile(int userId);

    /**
     * Retrieves a list of gyms that are approved and available in the database.
     *
     * @return A list of FlipFitGymDetails objects representing the details of the gyms.
     */
    public List<FlipFitGymDetails> viewGyms();

    /**
     * Retrieves a list of available slots for a specific gym and date.
     *
     * @param gymId The ID of the gym for which slots are to be retrieved.
     * @param date The date for which slots are to be retrieved.
     * @return A list of SlotDetails objects representing the available slots.
     */
    List<SlotDetails> viewSlots(int gymId, String date);

//    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment);

}
