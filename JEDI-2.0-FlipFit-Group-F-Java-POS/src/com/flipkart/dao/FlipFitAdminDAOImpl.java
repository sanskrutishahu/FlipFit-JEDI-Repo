package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminDAOImpl implements FlipFitAdminDAOInterface{

    @Override
    public void createAdmin(String customUserName, int adminId) {
    }

    @Override
    public List<FlipFitGymOwner> viewAllGymOwners() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> Output= new ArrayList<>();

        List<FlipFitGymOwner> gymOwnerList = new ArrayList<FlipFitGymOwner>();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "SELECT * FROM gymOwner WHERE approvalStatus = 'APPROVED'";

            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int gymOwnerId = rs.getInt("ownerId");
                String ownerName = rs.getString("ownerName");
                String ownerGstNum = rs.getString("ownerGstNum");
                String ownerPanNum = rs.getString("ownerPanNum");
                String approvalStatus = rs.getString("approvalStatus");
                String ownerAddress = rs.getString("ownerAddress");
                String ownerPhone = rs.getString("ownerPhone");
                gymOwnerList.add(new FlipFitGymOwner(ownerName,ownerPhone,ownerAddress,ownerGstNum,ownerPanNum,approvalStatus,gymOwnerId));
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

        return gymOwnerList;
    }

    @Override
    public List<FlipFitGymDetails> viewGymDetails() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FlipFitGymDetails> gymList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "SELECT * FROM gymDetails WHERE approvalStatus = 'APPROVED'";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int gymId = rs.getInt("gymId");
                int gymOwnerId = rs.getInt("gymOwnerId");
                String gymName = rs.getString("gymName");
                String gymAddress = rs.getString("gymAddress");
                int noOfSlots = rs.getInt("noOfSlots");
                String approvalStatus = rs.getString("approvalStatus");

                gymList.add(new FlipFitGymDetails(gymId, gymOwnerId, gymName, gymAddress, noOfSlots, approvalStatus));
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
    public List<FlipFitGymOwner> viewGymOwnerRequests() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FlipFitGymOwner> gymOwnerList = new ArrayList<FlipFitGymOwner>();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");


            String query = "SELECT * FROM gymOwner WHERE approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);

            rs = stmt.executeQuery();

            boolean hasRequests = false;
            System.out.println("Pending Gym Owner Requests:");

            while (rs.next()) {
                int gymOwnerId = rs.getInt("ownerId");
                String name = rs.getString("ownerName");
                String phone = rs.getString("ownerPhone");
                String address = rs.getString("ownerAddress");
                String gstNum = rs.getString("ownerGstNum");
                String panNum = rs.getString("ownerPanNum");
                String approvalStatus = rs.getString("approvalStatus");
//                int userId = rs.getInt("userId");

                gymOwnerList.add(new FlipFitGymOwner(name, phone, address, gstNum, panNum, approvalStatus, gymOwnerId));
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
        return gymOwnerList;
    }

    @Override
    public boolean approveGymOwnerRequests(int ownerId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "UPDATE gymOwner SET approvalStatus = 'APPROVED' WHERE ownerId = ? AND approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, ownerId);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            return false;
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
    public boolean approveGymRequests(int gymId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");


            String query = "UPDATE gymDetails SET approvalStatus = 'APPROVED' WHERE gymId = ? AND approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, gymId);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            return false;
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
    public boolean rejectGymOwnerRequests(int ownerId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "UPDATE gymOwner SET approvalStatus = 'REJECTED' WHERE ownerId = ? AND approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, ownerId);


            int rowsAffected = stmt.executeUpdate();


            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            return false;
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
    public boolean removeGym(int gymId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "UPDATE gymDetails SET approvalStatus = 'REMOVED' WHERE gymId = ? AND approvalStatus = 'APPROVED'";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, gymId);


            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            return false;
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
    public List<FlipFitGymOwner> viewPendingOwner() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FlipFitGymOwner> gymOwnerList = new ArrayList<FlipFitGymOwner>();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");


            String query = "SELECT * FROM gymOwner WHERE approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);

            rs = stmt.executeQuery();

            boolean hasRequests = false;

            while (rs.next()) {
                int gymOwnerId = rs.getInt("ownerId");
                String name = rs.getString("ownerName");
                String phone = rs.getString("ownerPhone");
                String address = rs.getString("ownerAddress");
                String gstNum = rs.getString("ownerGstNum");
                String panNum = rs.getString("ownerPanNum");
                String approvalStatus = rs.getString("approvalStatus");
//                int userId = rs.getInt("userId");

                gymOwnerList.add(new FlipFitGymOwner( name, phone, address, gstNum, panNum, approvalStatus, gymOwnerId));

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
        return gymOwnerList;
    }

    @Override
    public List<FlipFitGymDetails> viewPendingCenter() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FlipFitGymDetails> gymList = new ArrayList<>();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "SELECT * FROM gymDetails WHERE approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);

            rs = stmt.executeQuery();

            boolean hasRequests = false;

            while (rs.next()) {
                int gymId = rs.getInt("gymId");
                int gymOwnerId = rs.getInt("gymOwnerId");
                String gymName = rs.getString("gymName");
                String gymAddress = rs.getString("gymAddress");
                int noOfSlots = rs.getInt("noOfSlots");
                String approvalStatus = rs.getString("approvalStatus");

                gymList.add(new FlipFitGymDetails(gymId, gymOwnerId, gymName, gymAddress, noOfSlots, approvalStatus));
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
    public boolean rejectGymRequests(int gymId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "UPDATE gymDetails SET approvalStatus = 'REJECTED' WHERE gymId = ? AND approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, gymId);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            return false;
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
    public boolean removeGymOwner(int ownerId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            String query = "UPDATE gymOwner SET approvalStatus = 'REMOVED' WHERE ownerId = ? AND approvalStatus = 'APPROVED'";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, ownerId);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            return false;
        } finally {
            try {

                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
