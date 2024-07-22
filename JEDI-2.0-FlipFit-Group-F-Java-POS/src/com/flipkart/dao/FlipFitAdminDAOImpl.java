package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the FlipFitAdminDAOInterface and provides
 * functionality to interact with the database for administrative tasks.
 */
public class FlipFitAdminDAOImpl implements FlipFitAdminDAOInterface{

    /**
     * Creates a new admin with the specified custom username and admin ID.
     *
     * @param customUserName The custom username of the admin.
     * @param adminId        The ID of the admin.
     */
    @Override
    public void createAdmin(String customUserName, int adminId) {
    }

    /**
     * Retrieves a list of all approved gym owners from the database.
     *
     * @return List of FlipFitGymOwner objects representing approved gym owners.
     */
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

    /**
     * Retrieves details of all approved gyms from the database.
     *
     * @return List of FlipFitGymDetails objects representing approved gyms.
     */
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

    /**
     * Retrieves a list of pending gym owner requests from the database.
     *
     * @return List of FlipFitGymOwner objects representing pending gym owner requests.
     */
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

    /**
     * Approves a pending gym owner request by updating the approval status in the database.
     *
     * @param ownerId The ID of the gym owner whose request is to be approved.
     * @return true if the approval was successful, false otherwise.
     */
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

    /**
     * Approves a pending gym request by updating the approval status in the database.
     *
     * @param gymId The ID of the gym whose request is to be approved.
     * @return true if the approval was successful, false otherwise.
     */
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

    /**
     * Rejects a pending gym owner request by updating the approval status in the database to 'REJECTED'.
     *
     * @param ownerId The ID of the gym owner whose request is to be rejected.
     * @return true if the rejection was successful, false otherwise.
     */
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

    /**
     * Removes an approved gym entry from the database by updating the approval status to 'REMOVED'.
     *
     * @param gymId The ID of the gym to be removed.
     * @return true if the removal was successful, false otherwise.
     */
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

    /**
     * Retrieves a list of gym owners whose requests are pending approval.
     *
     * @return List of FlipFitGymOwner objects representing pending gym owner requests.
     */
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

    /**
     * Retrieves a list of gym centers whose approval status is pending.
     *
     * @return List of FlipFitGymDetails objects representing pending gym center requests.
     */
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

    /**
     * Rejects a pending gym request by updating the approval status in the database to 'REJECTED'.
     *
     * @param gymId The ID of the gym whose request is to be rejected.
     * @return true if the rejection was successful, false otherwise.
     */
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

    /**
     * Removes an approved gym owner from the database by updating the approval status to 'REMOVED'.
     *
     * @param ownerId The ID of the gym owner to be removed.
     * @return true if the removal was successful, false otherwise.
     */
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
