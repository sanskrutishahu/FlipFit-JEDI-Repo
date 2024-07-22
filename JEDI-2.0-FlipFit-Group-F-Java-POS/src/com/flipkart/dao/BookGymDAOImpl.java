package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookGymDAOImpl implements BookGymDAOInterface{

    @Override
    public void createBooking(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount) {

    }

    @Override
    public void bookSlots(int bookingId, int useId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount){
        System.out.println("Slot book");
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "SELECT * FROM slotDetails WHERE slotId = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, slotId);
            ResultSet resultSet = stmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Slot not found. Please book another slot!");
                return;
            }

            System.out.println("slot present");
            String query2 = "INSERT INTO booking (userId, slotId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount, bookingStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(query2);

            stmt.setInt(1, useId);
            stmt.setInt(2, slotId);
            stmt.setInt(3, transactionId);
            stmt.setString(4, bookingDate);
            stmt.setString(5, "bookingTimeSlot");
            stmt.setString(6, "bookingType");
            stmt.setInt(7, bookingAmount);
            stmt.setInt(8, 1);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Booking created successfully");
            } else {
//                throw new Exception();
                throw new com.flipkart.exceptions.BookingFailedException("Failed to create booking");
            }
        } catch (Exception e) {
//            throw new com.flipkart.exceptions.BookingFailedException(e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    @Override
    public List<Booking> viewBookings(int userId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            // Now, get all bookings for the userId
            String bookingQuery = "SELECT * FROM booking WHERE customerId = ?";
            stmt = con.prepareStatement(bookingQuery);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int bookingId = rs.getInt("bookingId");
                int slotId = rs.getInt("slotId");
                String bookingDate = rs.getString("bookingDate");
                String bookingTimeSlotStart = rs.getString("bookingTimeSlotStart");
                String bookingTimeSlotEnd = rs.getString("bookingTimeSlotEnd");
                int bookingStatus = rs.getInt("bookingStatus");
                int transactionId = rs.getInt("transactionId");
                int bookingAmount = rs.getInt("bookingAmount");

                Booking booking = new Booking(bookingId, userId, slotId, bookingDate, bookingTimeSlotStart, bookingTimeSlotEnd, bookingStatus, transactionId, bookingAmount);

                bookings.add(booking);
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
        if(bookings.isEmpty())
        {
            return null;
        }
        return bookings;
    }


    @Override
    public void cancelBookings(int bookingId) {
        Connection con = null;
        PreparedStatement stmtSelect = null;
        PreparedStatement stmtDeleteBooking = null;
        PreparedStatement stmtDeletePayment = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

//            String querySelect = "SELECT transactionId FROM booking WHERE bookingId = ?";
//            stmtSelect = con.prepareStatement(querySelect);
//            stmtSelect.setInt(1, bookingId);
//            rs = stmtSelect.executeQuery();

            if (rs.next()) {
//                int transactionId = rs.getInt("transactionId");
                String queryDeleteBooking = "DELETE FROM booking WHERE bookingId = ?";
                stmtDeleteBooking = con.prepareStatement(queryDeleteBooking);
                stmtDeleteBooking.setInt(1, bookingId);
                int resultBooking = stmtDeleteBooking.executeUpdate();

                if (resultBooking > 0) {
                    System.out.println("Booking successfully cancelled.");

//                    String queryDeletePayment = "DELETE FROM Payment WHERE transactionId = ?";
//                    stmtDeletePayment = con.prepareStatement(queryDeletePayment);
//                    stmtDeletePayment.setInt(1, transactionId);
//                    int resultPayment = stmtDeletePayment.executeUpdate();
//
//                    if (resultPayment > 0) {
//                        System.out.println("Payment successfully removed.");
//                    } else {
//                        System.out.println("No payment found with the given transactionId.");
//                    }
                } else {
                    System.out.println("No booking found with the given bookingId.");
                }
            } else {
                System.out.println("No booking found with the given bookingId.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmtSelect != null) stmtSelect.close();
                if (stmtDeleteBooking != null) stmtDeleteBooking.close();
                if (stmtDeletePayment != null) stmtDeletePayment.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}