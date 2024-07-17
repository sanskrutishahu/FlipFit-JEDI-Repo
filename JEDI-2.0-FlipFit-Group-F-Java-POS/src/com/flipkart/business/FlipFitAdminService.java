package com.flipkart.business;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipFitAdminDAOImpl;
import com.flipkart.dao.FlipFitAdminDAOInterface;

import java.util.List;

public class FlipFitAdminService implements FlipFitAdminInterface {

    FlipFitAdminDAOInterface adminDAO = new FlipFitAdminDAOImpl();

    @Override
    public void createAdmin(int adminId, int userId, String userEmail, String userPass) {
        System.out.println("Create Admin Implementation.");
    }

    @Override
    public List<FlipFitGymOwner> viewAllGymOwners() {
        return adminDAO.viewAllGymOwners();
    }

    @Override
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId) {
        return adminDAO.viewGymOwnerDetails(ownerId);
    }

    @Override
    public List<FlipFitGymOwner> viewGymOwnerRequests() {
        return adminDAO.viewGymOwnerRequests();
    }

    @Override
    public void approveGymOwnerRequests(int ownerId) {
        adminDAO.approveGymOwnerRequests(ownerId);
        System.out.println("Approved the gym owner requests with Id " + ownerId);
    }

    @Override
    public void approveGymRequests(int gymId) {
        adminDAO.approveGymRequests(gymId);
        System.out.println("Approved the gym requests with Id " + gymId);
    }

    @Override
    public void rejectGymOwnerRequests(int ownerId) {
        adminDAO.rejectGymOwnerRequests(ownerId);
        System.out.println("Rejected the gym owner requests with Id " + ownerId);
    }

    @Override
    public void rejectGymRequests(int gymId) {
        adminDAO.rejectGymRequests(gymId);
        System.out.println("Rejected the gym requests with Id " + gymId);
    }

    @Override
    public void removeGym(int gymId) {
        adminDAO.removeGym(gymId);
        System.out.println("Removed the gym with Id " + gymId);
    }

    @Override
    public List<FlipFitGymOwner> viewPendingOwner() {
        return adminDAO.viewPendingOwner();
    }

    @Override
    public List<FlipFitGymDetails> viewPendingCenter() {
        return adminDAO.viewPendingCenter();
    }

    @Override
    public void removeGymOwner(int ownerId) {
        adminDAO.removeGymOwner(ownerId);
        System.out.println("Removed the gym owner with Id " + ownerId);
    }

    @Override
    public void cancelRequest(int ownerId) {
        adminDAO.cancelRequest(ownerId);
        System.out.println("Cancelled the gym owner request with Id " + ownerId);
    }
}
