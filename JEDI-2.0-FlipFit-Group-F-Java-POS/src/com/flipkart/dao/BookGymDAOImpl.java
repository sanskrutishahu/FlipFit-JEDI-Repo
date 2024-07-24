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
    public void bookSlots(int bookingId, int customerId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, String transactionId, int bookingAmount){
        System.out.println("Slot book");
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "root@123");

            String query = "SELECT * FROM slotDetails WHERE slotId = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, slotId);
            ResultSet resultSet = stmt.executeQuery();
            int seatsLeft = 0;

            if (!resultSet.next()) {
                System.out.println("Slot not found. Please book another slot!");
                return;
            }else{
                String query2 = "INSERT INTO booking (customerId, slotId, bookingStatus, transactionId, bookingAmount, bookingDate, bookingTimeSlotStart, bookingTimeSlotEnd) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(query2);

                stmt.setInt(1, customerId);
                stmt.setInt(2, slotId);
                stmt.setString(4, transactionId);
                stmt.setInt(5, bookingAmount);
                stmt.setString(6, resultSet.getString("date"));
                stmt.setString(7, resultSet.getString("startTime"));
                stmt.setString(8, resultSet.getString("endTime"));

                seatsLeft = resultSet.getInt("seatsLeft");
                if(seatsLeft <= 0){
                    stmt.setInt(3, 0);
                }else{
                    stmt.setInt(3, 1);
                }
            }

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0 && seatsLeft > 0) {
                System.out.println("Booking created successfully");
                String query3 = "Update slotDetails SET seatsLeft = seatsLeft - 1";
                stmt = con.prepareStatement(query3);
                stmt.executeUpdate();
            }else if(rowsAffected > 0){
                System.out.println("Booking created successfully but it is in Pending State once conformed you will be pinged.");
            }
            else {
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

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "root@123");

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
                String transactionId = rs.getString("transactionId");
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

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "root@123");

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

    @Override
    public int makePayment(int userId, String paymentId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "root@123");

            // Now, get all bookings for the userId
            String paymentQuery = "Insert Into paymentDetails (userId, transactionId) Values (?, ?)";
            stmt = con.prepareStatement(paymentQuery);
            stmt.setInt(1, userId);
            stmt.setString(2, paymentId);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        return 1;
    }
}