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

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "Sushma@22");

            String query = "SELECT * FROM flipfitGymOwner";

            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            System.out.println("All Registered GymOwners");

            while (rs.next()) {
                int ownerId = rs.getInt("ownerId");
                String ownerName = rs.getString("ownerName");
                String ownerPhone = rs.getString("ownerPhone");
                String ownerAddress = rs.getString("ownerAddress");
                String ownerGstNum = rs.getString("ownerGstNum");
                String ownerPanNum = rs.getString("ownerPanNum");
                String approvalStatus = rs.getString("approvalStatus");
                gymOwnerList.add(new FlipFitGymOwner(ownerName,ownerPhone,ownerAddress,ownerGstNum,ownerPanNum,approvalStatus,ownerId));
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
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId) {
        return List.of();
    }

    @Override
    public List<FlipFitGymOwner> viewGymOwnerRequests() {
        return List.of();
    }

    @Override
    public void approveGymOwnerRequests(int ownerId) {
    }

    @Override
    public void approveGymRequests(int gymId) {

    }

    @Override
    public void rejectGymOwnerRequests(int ownerId) {

    }

    @Override
    public void removeGym(int gymId) {

    }

    @Override
    public List<FlipFitGymOwner> viewPendingOwner() {
        return List.of();
    }

    @Override
    public List<FlipFitGymDetails> viewPendingCenter() {
        return List.of();
    }

    @Override
    public void rejectGymRequests(int gymId) {

    }

    @Override
    public void removeGymOwner(int ownerId) {
    }

    @Override
    public void cancelRequest(int ownerId) {
    }
}
