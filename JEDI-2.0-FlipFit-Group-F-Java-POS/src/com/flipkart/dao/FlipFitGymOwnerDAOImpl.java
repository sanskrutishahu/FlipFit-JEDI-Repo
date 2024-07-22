package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.SlotDetails;
import com.flipkart.business.FlipFitGymOwnerInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerDAOImpl implements FLipFitGymOwnerDAOInterface {


    @Override
    public void createGymOwner(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId) {
        Connection con = null;
        PreparedStatement stmtOwner = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");
            con.setAutoCommit(false);

            String queryOwner = "INSERT INTO gymOwner (ownerName, ownerPhone, ownerAddress, ownerGSTNum, ownerPanNum, approvalStatus, ownerId) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmtOwner = con.prepareStatement(queryOwner);
            stmtOwner.setString(1, ownerName);
            stmtOwner.setString(2, ownerPhone);
            stmtOwner.setString(3, ownerAddress);
            stmtOwner.setString(4, ownerGstNum);
            stmtOwner.setString(5, ownerPanNum);
            stmtOwner.setString(6, "PENDING");
            stmtOwner.setInt(7, ownerId);

            int ownerInsertCount = stmtOwner.executeUpdate();
            System.out.println(ownerInsertCount + " owner records inserted");

            con.commit();
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void editProfile(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId) {

    }

    @Override
    public void registerGym(int gymOwnerId, String gymName, String gymAddress) {
        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtGym = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");
            con.setAutoCommit(false);

            String query = "SELECT * FROM gymOwner WHERE ownerId = ? AND approvalStatus = 'APPROVED'";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, gymOwnerId);
            ResultSet resultSet = stmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Gym owner is not registered, Please try again after registering Gym Owner.");
                return;
            }

            String queryGym = "INSERT INTO gymDetails ( gymOwnerId, gymName, gymAddress, noOfSlots, approvalStatus) VALUES (?, ?, ?, ?, ?);";
            stmtGym = con.prepareStatement(queryGym);
            stmtGym.setInt(1, gymOwnerId);
            stmtGym.setString(2, gymName);
            stmtGym.setString(3, gymAddress);
            stmtGym.setInt(4, 0);
            stmtGym.setString(5, "PENDING");

            int ownerInsertCount = stmtGym.executeUpdate();
            if(ownerInsertCount > 0) {
                System.out.println("Your Gym has been registered successfully");
            }

            con.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmtGym != null) stmtGym.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    @Override
    public void editGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots) {

    }

    @Override
    public void removeGym(int gymId) {
        Connection con = null;
        PreparedStatement stmt = null;
        int count;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String gymQuery = "DELETE FROM gymDetails WHERE gymId=? AND approvalStatus = 'APPROVED'";
            stmt = con.prepareStatement(gymQuery);
            stmt.setInt(1, gymId);
            count = stmt.executeUpdate();
            if(count!=0)
            {
                System.out.println("Your Gym with ID " + gymId + " has been removed");
            }
            else
            {
                System.out.println("Your Gym with ID " + gymId + " does not exist or has not been approved yet. Please Contact FlipFit Admin for further assistance.");
            }
            stmt.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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
    public List<FlipFitGymDetails> viewAllRegisteredGymCenters(int gymOwnerId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<FlipFitGymDetails> gymList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");
          
            String gymQuery = "SELECT * FROM gymDetails WHERE gymOwnerId = ?";
            stmt = con.prepareStatement(gymQuery);
            stmt.setInt(1, gymOwnerId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int gymId = rs.getInt("gymId");
                String gymName = rs.getString("gymName");
                String gymAddress = rs.getString("gymAddress");
                int noOfSlots = rs.getInt("noOfSlots");
                String approvalStatus = rs.getString("approvalStatus");

                FlipFitGymDetails gym = new FlipFitGymDetails(gymId, gymOwnerId, gymName, gymAddress, noOfSlots, approvalStatus);
                gymList.add(gym);
            }
        }catch (Exception e) {
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
    public List<Booking> viewAllBookings(int userId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String bookingQuery = "SELECT * FROM booking b WHERE b.userId = ?";
            stmt = con.prepareStatement(bookingQuery);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int bookingId = rs.getInt("bookingId");
                int gymId = rs.getInt("gymId");
                int slotId = rs.getInt("slotId");
                String bookingDate = rs.getString("bookingDate");
                String bookingTimeSlotStart = rs.getString("bookingTimeSlotStart");
                String bookingTimeSlotEnd = rs.getString("bookingTimeSlotEnd");
                int bookingStatus = rs.getInt("bookingStatus");
                int transactionId = rs.getInt("transactionId");
                int bookingAmount = rs.getInt("bookingAmount");

                Booking booking = new Booking(bookingId, gymId, slotId, bookingDate, bookingTimeSlotStart, bookingTimeSlotEnd, bookingStatus, transactionId, bookingAmount);

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

        return bookings;

    }

    @Override
    public List<Booking> viewBookings(int gymId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            // Now, get all bookings for the gymId
            String bookingQuery = "SELECT * FROM booking WHERE gymId = ?";
            stmt = con.prepareStatement(bookingQuery);
            stmt.setInt(1, gymId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int bookingId = rs.getInt("bookingId");
                gymId = rs.getInt("gymId");
                int slotId = rs.getInt("slotId");
                String bookingDate = rs.getString("bookingDate");
                String bookingTimeSlotStart = rs.getString("bookingTimeSlotStart");
                String bookingTimeSlotEnd = rs.getString("bookingTimeSlotEnd");
                int bookingStatus = rs.getInt("bookingStatus");
                int transactionId = rs.getInt("transactionId");
                int bookingAmount = rs.getInt("bookingAmount");

                Booking booking = new Booking(bookingId, gymId, slotId, bookingDate, bookingTimeSlotStart, bookingTimeSlotEnd, bookingStatus, transactionId, bookingAmount);

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

        return bookings;
    }

    @Override
    public List<SlotDetails> viewAvailableSlots(int gymId, String date) {
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

    @Override
    public void addSlot(int gymId, String date, String startTime, String endTime, int noOfSeats) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "SELECT * FROM gymDetails WHERE gymId = ? AND approvalStatus = 'APPROVED'";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, gymId);
            ResultSet resultSet = stmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Gym is not registered, Please try again after registering Gym.");
                return;
            }

            PreparedStatement slotStmt = con.prepareStatement(
                    "INSERT INTO slotDetails (gymId, date, startTime, endTime, noOfSeats) VALUES (?, ?, ?, ?, ?)"
            );

            slotStmt.setInt(1, gymId);
            slotStmt.setString(2, date);
            slotStmt.setString(3, startTime);
            slotStmt.setString(4, endTime);
            slotStmt.setInt(5, noOfSeats);

            int slotInsertCount = slotStmt.executeUpdate();
            if (slotInsertCount > 0) {
                System.out.println("New slot has been successfully added");
            }
            else
            {
                System.out.println("Unable to insert new slot, Please try again after some time.");
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeSlot(int gymId, int slotId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "SELECT * FROM gymDetails WHERE gymId = ? AND approvalStatus = 'APPROVED'";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, gymId);
            ResultSet resultSet = stmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("Gym is not registered, Please try again after registering Gym.");
                return ;
            }

            String query2 = "DELETE FROM slotDetails WHERE slotId = ? and gymId = ?";

            stmt = con.prepareStatement(query2);
            stmt.setInt(1, slotId);
            stmt.setInt(2, gymId);


            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("slot with ID " + slotId + " has been removed.");

            } else {
                System.out.println("No slot found with ID " + slotId);
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }
        finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}