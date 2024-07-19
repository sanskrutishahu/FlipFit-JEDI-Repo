package com.flipkart.business;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipFitAdminDAOImpl;
import com.flipkart.dao.FlipFitAdminDAOInterface;

import java.util.List;

public class FlipFitAdminService implements FlipFitAdminInterface {

    FlipFitAdminDAOInterface adminDAO = new FlipFitAdminDAOImpl();

    @Override
    public void createAdmin(String customUserName, int adminId) {
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
        boolean res=adminDAO.approveGymOwnerRequests(ownerId);
        if (res){
            System.out.println("Approved the gym owner requests with Id " + ownerId);
        }
        else{
            System.out.println("The gym owner requests with Id could not be approved" + ownerId);
        }

    }

    @Override
    public void approveGymRequests(int gymId) {
        boolean res=adminDAO.approveGymRequests(gymId);
        if (res){
            System.out.println("Approved the gym requests with Id " + gymId);
        }
        else{
            System.out.println("The gym request with Id could not be approved" + gymId);
        }
    }

    @Override
    public void rejectGymOwnerRequests(int ownerId) {
        boolean res=adminDAO.rejectGymOwnerRequests(ownerId);
        if (res){
            System.out.println("Rejected the gym owner requests with Id " + ownerId);
        }
        else{
            System.out.println("The gym owner request with Id could not be rejected" + ownerId);
        }

    }

    @Override
    public void rejectGymRequests(int gymId) {
        boolean res=adminDAO.rejectGymRequests(gymId);
        if (res){
            System.out.println("Rejected the gym requests with Id " + gymId);
        }
        else{
            System.out.println("The gym request with Id could not be rejected" + gymId);
        }
    }

    @Override
    public void removeGym(int gymId) {
        boolean res =adminDAO.removeGym(gymId);
        if (res){
            System.out.println("Removed the gym requests with Id " + gymId);
        }
        else{
            System.out.println("The gym request with Id could not be removed" + gymId);
        }
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
        boolean res= adminDAO.removeGymOwner(ownerId);
        if (res){
            System.out.println("Removed the gym owner with Id " + ownerId);
        }
        else{
            System.out.println("The gym request with Id could not be removed" + ownerId);
        }

    }


    public void cancelRequest(int ownerId) {
        adminDAO.cancelRequest(ownerId);
        System.out.println("Cancelled the gym owner request with Id " + ownerId);
    }
}
