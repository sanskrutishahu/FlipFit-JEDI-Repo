package com.flipkart.dao;

import com.flipkart.bean.User;
import java.sql.*;

public class FlipFitUserDAOImpl implements FlipFitUserDAOInterface{

    @Override
    public int authenticateUser(String userEmail, String userPassword, int roleId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");
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
                    return -1;
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            con.setAutoCommit(false);
            String queryUser = "INSERT INTO userDetails (userEmail, userPassword, roleID) VALUES (?,?,?)";
            stmtUser = con.prepareStatement(queryUser,Statement.RETURN_GENERATED_KEYS);
            stmtUser.setString(1, userEmail);
            stmtUser.setString(2, userPassword);
            stmtUser.setInt(3, roleId);

            int userInsertCount = stmtUser.executeUpdate();

            if (userInsertCount > 0) {
                ResultSet generatedKeys = stmtUser.getGeneratedKeys();
                if (generatedKeys.next()) {
                    userId = generatedKeys.getInt(1);
                }
            }
            con.commit(); // Commit transaction
        } catch (Exception e) {
            System.out.println(e);
        }
        return userId;
    }

    @Override
    public boolean changeUserPassword(int userId, String userPassword)
    {
        Connection con = null;
        PreparedStatement stmtUser = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "*****");

            con.setAutoCommit(false);
            String queryUser = "UPDATE userDetails SET userPassword = ? WHERE userId = ?";
            stmtUser = con.prepareStatement(queryUser);
            stmtUser.setString(1, userPassword);
            stmtUser.setInt(2, userId);

            int userInsertCount = stmtUser.executeUpdate();

            if (userInsertCount <= 0) {
                return false;
            }
            con.commit(); // Commit transaction
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
