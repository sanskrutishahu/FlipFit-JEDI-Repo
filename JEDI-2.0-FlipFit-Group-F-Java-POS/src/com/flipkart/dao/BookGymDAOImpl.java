package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of BookGymDAOInterface for handling gym booking operations using JDBC.
 */
public class BookGymDAOImpl implements BookGymDAOInterface{

    /**
     * Creates a new booking in the gym system.
     *
     * @param bookingId              The unique identifier for the booking.
     * @param userId                 The ID of the user making the booking.
     * @param slotId                 The ID of the time slot for the booking.
     * @param bookingDate            The date of the booking in string format.
     * @param bookingTimeSlotStart   The start time of the booking time slot in string format.
     * @param bookingTimeSlotEnd     The end time of the booking time slot in string format.
     * @param bookingStatus          The status of the booking (e.g., confirmed, pending).
     * @param transactionId          The ID of the transaction associated with the booking.
     * @param bookingAmount          The amount paid for the booking (if applicable).
     */
    @Override
    public void createBooking(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount) {

    }

    /**
     * Books slots for a user in the gym system.
     *
     * @param bookingId              The unique identifier for the booking.
     * @param userId                 The ID of the user making the booking.
     * @param slotId                 The ID of the time slot for the booking.
     * @param bookingDate            The date of the booking in string format.
     * @param bookingTimeSlotStart   The start time of the booking time slot in string format.
     * @param bookingTimeSlotEnd     The end time of the booking time slot in string format.
     * @param bookingStatus          The status of the booking (e.g., confirmed, pending).
     * @param transactionId          The ID of the transaction associated with the booking.
     * @param bookingAmount          The amount paid for the booking (if applicable).
     */
    @Override
    public void bookSlots(int bookingId, int customerId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount){
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
            int seatsLeft = 0;

            if (!resultSet.next()) {
                System.out.println("Slot not found. Please book another slot!");
                return;
            }else{
                String query2 = "INSERT INTO booking (customerId, slotId, bookingStatus, transactionId, bookingAmount, bookingDate, bookingTimeSlotStart, bookingTimeSlotEnd) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(query2);

                stmt.setInt(1, customerId);
                stmt.setInt(2, slotId);
                stmt.setInt(4, transactionId);
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

    /**
     * Retrieves a list of bookings for a specific user.
     *
     * @param userId  The ID of the user whose bookings are to be retrieved.
     * @return        A List of Booking objects representing the user's bookings.
     */
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

    /**
     * Cancels a booking based on the booking ID.
     *
     * @param bookingId  The ID of the booking to be canceled.
     */
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