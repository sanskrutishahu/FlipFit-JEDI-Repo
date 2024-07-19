package com.flipkart.dao;

import com.flipkart.bean.FlipFitCustomer;
import com.flipkart.bean.FlipFitGymDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAOInterface{

    @Override
    public void createCustomer(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
        Connection con = null;
        PreparedStatement stmtCustomer = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "Sushma@22");
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
            System.out.println(customerInsertCount + " customer records inserted");

            con.commit(); // Commit transaction
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void editProfile(int weight, int age, String gender, String customerName, String customerPhone, String customerAddress, int customerId) {
    }

    @Override
    public FlipFitCustomer viewProfile(int userId) {
        return null;
    }

    @Override
    public List<FlipFitGymDetails> viewGyms() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<FlipFitGymDetails> gymList = new ArrayList<FlipFitGymDetails>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "Sushma@22");

            String query = "SELECT * FROM gymDetails";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int gymId = rs.getInt("gymId");
                int ownerId = rs.getInt("gymOwnerId");
                String gymName = rs.getString("gymName");
                String gymLocation = rs.getString("gymAddress");
                int noOfSlots= rs.getInt("noOfSlots");
                String aprovalStatus = rs.getString("approvalStatus");
                gymList.add(new FlipFitGymDetails(gymId, ownerId, gymName, gymLocation,noOfSlots,aprovalStatus));
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
        return gymList;
    }

    @Override
    public HashMap<String,Integer> viewSlots(int gymId,String date) {
        Connection con = null;
        PreparedStatement stmtSlots = null;
        PreparedStatement stmtBookings = null;
        ResultSet rsSlots = null;
        ResultSet rsBookings = null;
        HashMap<String, Integer> slotAvailability = new HashMap<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "Sushma@22");

            String querySlots = "SELECT * FROM slotDetails WHERE gymId = ?";
            stmtSlots = con.prepareStatement(querySlots);
            stmtSlots.setInt(1, gymId);
            rsSlots = stmtSlots.executeQuery();

            if (!rsSlots.isBeforeFirst()) {
                throw new com.flipkart.exceptions.GymNotFoundException(gymId);
            }

            while (rsSlots.next()) {
                int SlotId = rsSlots.getInt("slotId");
                int GymId = rsSlots.getInt("gymId");
                String Date = rsSlots.getString("date");
                String StartTime = rsSlots.getString("startTime");
                String EndTime = rsSlots.getString("endTime");
                int slotCapacity = rsSlots.getInt("noOfSeats");

                String queryBookings = "SELECT COUNT(*) as bookedCount FROM booking WHERE gymId = ? AND bookingDate = ?";
                stmtBookings = con.prepareStatement(queryBookings);
                stmtBookings.setInt(1, gymId);
                stmtBookings.setString(2, date);
                rsBookings = stmtBookings.executeQuery();

                int bookedCount = 0;
                if (rsBookings.next()) {
                    bookedCount = rsBookings.getInt("bookedCount");
                }
                int availableSeats = slotCapacity - bookedCount;
//                String slotTime= date +"_" + StartTime + "_" + EndTime;
                slotAvailability.put(date,availableSeats);
            }


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rsBookings != null) rsBookings.close();
                if (stmtBookings != null) stmtBookings.close();
                if (rsSlots != null) rsSlots.close();
                if (stmtSlots != null) stmtSlots.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }

        return slotAvailability;
    }

    @Override
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) {
        return 0;
    }

}
