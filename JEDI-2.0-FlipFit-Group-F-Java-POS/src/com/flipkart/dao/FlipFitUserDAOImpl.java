package com.flipkart.dao;

import com.flipkart.bean.User;
import java.sql.*;

public class FlipFitUserDAOImpl implements FlipFitUserDAOInterface{

    @Override
    public int authenticateUser(int userId, String userEmail, String userPassword, int roleId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "Sushma@22");
            String query = "SELECT userPassword, userId FROM userDetails WHERE userEmail = ? and roleID = ?";

            stmt = con.prepareStatement(query);
            stmt.setString(1, userEmail);
            stmt.setInt(2, roleId);

            rs = stmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("userPassword");
                if (userPassword.equals(storedPassword)){
                    return rs.getInt("userId");
                }
                else {
                    return 0;
                }
            } else {

                return 0;

            }
        }
        catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        return 0;
    }

    @Override
    public int createUser(int userId, String userEmail, String userPassword, int roleId) {
        Connection con = null;
        PreparedStatement stmtUser = null;
//        int userId=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "Sushma@22");

            con.setAutoCommit(false);
            System.out.println(userEmail);
            System.out.println(userPassword);
            System.out.println(roleId);
            String queryUser = "INSERT INTO userDetails (userEmail, userPassword, roleID) VALUES (?,?,?)";
            stmtUser = con.prepareStatement(queryUser,Statement.RETURN_GENERATED_KEYS);
            System.out.println(stmtUser);
            stmtUser.setString(1, userEmail);
            stmtUser.setString(2, userPassword);
            stmtUser.setInt(3, roleId);

            int userInsertCount = stmtUser.executeUpdate();

            if (userInsertCount > 0) {
                ResultSet generatedKeys = stmtUser.getGeneratedKeys();
                if (generatedKeys.next()) {
                    userId = generatedKeys.getInt(1);
                    System.out.println(userInsertCount + " user records inserted");
                }
            } else {
                System.out.println("User insertion failed.");
            }
            con.commit(); // Commit transaction
        } catch (Exception e) {
            System.out.println(e);
        }
        return userId;

    }
}
