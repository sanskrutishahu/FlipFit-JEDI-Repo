package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.SlotDetails;
import com.flipkart.exceptions.GymNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implementation of FlipFitCustomerDAOInterface for interacting with customer-related data in the FlipFit system.
 */
public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAOInterface{

    /**
     * Creates a new customer with the given details.
     *
     * @param weight         The weight of the customer.
     * @param age            The age of the customer.
     * @param gender         The gender of the customer.
     * @param customerName   The name of the customer.
     * @param customerPhone  The phone number of the customer.
     * @param customerAddress The address of the customer.
     * @param customerId     The ID of the customer.
     */
    @Override
    public void createCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
        Connection con = null;
        PreparedStatement stmtCustomer = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");
            con.setAutoCommit(false);

            String queryCustomer = "INSERT INTO customer (customerId,weight,age,gender,customerName, customerPhone, customerAddress) VALUES (?, ?, ?, ?,?,?,?)";
            stmtCustomer = con.prepareStatement(queryCustomer);

            stmtCustomer.setInt(1, customerId);
            stmtCustomer.setInt(2, weight);
            stmtCustomer.setInt(3, age);
            stmtCustomer.setString(4, gender);
            stmtCustomer.setString(5, customerName);
            stmtCustomer.setString(6, customerPhone);
            stmtCustomer.setString(7, customerAddress);


            int customerInsertCount = stmtCustomer.executeUpdate();
//            System.out.println(customerInsertCount + " customer records inserted");

            System.out.println("Customer Details are added!");

            con.commit(); // Commit transaction
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Edits the profile of a customer with the given details.
     *
     * @param weight         The new weight of the customer.
     * @param age            The new age of the customer.
     * @param gender         The new gender of the customer.
     * @param customerName   The new name of the customer.
     * @param customerPhone  The new phone number of the customer.
     * @param customerAddress The new address of the customer.
     * @param customerId     The ID of the customer.
     */
    @Override
    public void editProfile(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
    }

    /**
     * Retrieves the profile of a customer with the given user ID.
     *
     * @param userId The ID of the customer.
     * @return FlipFitCustomer object representing the customer's profile.
     */
    @Override
    public FlipFitCustomer viewProfile(int userId){
        System.out.println("User "+userId);
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        FlipFitCustomer customer = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "SELECT * FROM customer WHERE customerId = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, userId); // Set the userId as a parameter in the query
            rs = stmt.executeQuery();
            if (rs.next()) {
                int customerId = rs.getInt("customerId");
                int weight = rs.getInt("weight");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String customerName = rs.getString("customerName");
                String customerPhone = rs.getString("customerPhone");
                String customerAddress = rs.getString("customerAddress");
                customer = new FlipFitCustomer(weight, age, gender, customerName, customerPhone, customerAddress, customerId);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }

        return customer;
    }

    /**
     * Retrieves a list of all approved gym details.
     *
     * @return List of FlipFitGymDetails objects representing gym details.
     */
    @Override
    public List<FlipFitGymDetails> viewGyms() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<FlipFitGymDetails> gymList = new ArrayList<FlipFitGymDetails>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "SELECT * FROM gymDetails WHERE approvalStatus = 'APPROVED';";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int gymId = rs.getInt("gymId");
                int ownerId = rs.getInt("gymOwnerId");
                String gymName = rs.getString("gymName");
                String gymLocation = rs.getString("gymAddress");
                int noOfSlots= rs.getInt("noOfSlots");
                String approvalStatus = rs.getString("approvalStatus");
                gymList.add(new FlipFitGymDetails(gymId, ownerId, gymName, gymLocation,noOfSlots, approvalStatus));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }

        if(gymList.isEmpty())
        {
            return null;
        }

        return gymList;
    }

    /**
     * Retrieves available slots for a given gym and date.
     *
     * @param gymId The ID of the gym.
     * @param date  The date for which slots are required.
     * @return List of SlotDetails objects representing available slots.
     */
    @Override
    public List<SlotDetails> viewSlots(int gymId, String date) {
        List<SlotDetails> slotList = new ArrayList<SlotDetails>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "SELECT * FROM gymDetails WHERE gymId = ? AND approvalStatus = 'APPROVED'";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, gymId);
            ResultSet resultSet = stmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Gym is not registered, Please try again after registering Gym.");
                return null;
            }

            String query2 = "SELECT * FROM slotDetails WHERE gymId=? AND date=? AND noOfSeats!=0";
            stmt = con.prepareStatement(query2);
            stmt.setInt(1, gymId);
            stmt.setString(2, date);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int slotId = rs.getInt("slotId");
                int slotGymId = rs.getInt("gymId");
                String slotDate = rs.getString("date");
                String slotSTime = rs.getString("startTime");
                String slotETime = rs.getString("endTime");
                int slotNoOfSeats = rs.getInt("noOfSeats");
                slotList.add(new SlotDetails(slotGymId, slotId, slotDate, slotSTime, slotETime, slotNoOfSeats));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return slotList;
    }

//    @Override
//    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) {
//        return 0;
//    }

}
