package com.flipkart.business;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipFitAdminDAOImpl;
import com.flipkart.dao.FlipFitAdminDAOInterface;

import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminService implements FlipFitAdminInterface {

    FlipFitAdminDAOInterface adminDAO = new FlipFitAdminDAOImpl();

    /**
     * Method to Create a new Admin
     * @param customUserName : Name of admin
     * @param adminId
     */
    @Override
    public void createAdmin(String customUserName, int adminId) {
        System.out.println("Admin is Created");
    }

    /**
     * Method to view all Gym Owners
     */
    @Override
    public void viewAllGymOwners() {
        if (adminDAO.viewAllGymOwners().isEmpty())
        {
            System.out.println("No Gym Owner Found!!");
            return;
        }
        System.out.println("-------- All Gym Owners --------");
        for(FlipFitGymOwner x : adminDAO.viewAllGymOwners()){
            System.out.println(x);
        }
    }

    /**
     * Method to view all existing Gym details
     */
    @Override
    public void viewGymDetails() {
        if (adminDAO.viewGymDetails().isEmpty())
        {
            System.out.println("No Gym centre found!!");
            return;
        }
        System.out.println("-------- All Gym Centres  --------");
        for(FlipFitGymDetails x : adminDAO.viewGymDetails()){
            System.out.println(x);
        }
    }


    /**
     * Method to approve gym owner requests
     * @param ownerId
     */
    @Override
    public void approveGymOwnerRequests(int ownerId) {
        boolean res=adminDAO.approveGymOwnerRequests(ownerId);
        if (res){
            System.out.println("Gym Owner request with ID " + ownerId + " has been approved.");
        }
        else{
            System.out.println("Gym Owner request with ID " + ownerId + " could not be found!!");
        }
    }

    /**
     * Method to approve gym requests
     * @param gymId
     */
    @Override
    public void approveGymRequests(int gymId) {
        boolean res=adminDAO.approveGymRequests(gymId);
        if (res){
            System.out.println("Gym request with ID " + gymId + " has been approved.");
        }
        else{
            System.out.println("Gym request with ID " + gymId + " could not be found!!");
        }
    }

    /**
     * Method to reject Gym Owner Requests
     * @param ownerId
     */
    @Override
    public void rejectGymOwnerRequests(int ownerId) {
        boolean res=adminDAO.rejectGymOwnerRequests(ownerId);
        if (res){
            System.out.println("Gym Owner request with ID " + ownerId + " has been rejected.");
        }
        else{
            System.out.println("Gym Owner request with ID " + ownerId + " could not be found!!");
        }
    }

    /**
     * Method to reject Gym requests
     * @param gymId
     */
    @Override
    public void rejectGymRequests(int gymId) {
        boolean res=adminDAO.rejectGymRequests(gymId);
        if (res){
            System.out.println("Gym request with ID " + gymId + " has been rejected.");
        }
        else{
            System.out.println("Gym request with ID " + gymId + " could not be found!!");
        }
    }

    /**
     * Method to remove Gym from  Gym Catalog
     * @param gymId
     * @throws GymNotFoundException
     */
    @Override
    public void removeGym(int gymId) {
        boolean res =adminDAO.removeGym(gymId);
        if (res){
            System.out.println("Gym with ID " + gymId + " has been removed successfully.");
        }
        else{
            System.out.println("Gym with ID " + gymId + " could not be found!!");
        }
    }

    /**
     * Method to view pending requests of Gym Owners
     */
    @Override
    public void viewPendingOwner() {
        if (adminDAO.viewPendingOwner().isEmpty())
        {
            System.out.println("No Pending Gym Owner Request!!");
            return;
        }
        System.out.println("Pending Gym Owner Requests:");
        for(FlipFitGymOwner x : adminDAO.viewPendingOwner()){
            System.out.println(x);
        }
    }

    /**
     * Method to view pending requests of centers
     */
    @Override
    public void viewPendingCenter() {
        if(adminDAO.viewPendingCenter().isEmpty())
        {
            System.out.println("No Pending Gym Centre Request!!");
            return;
        }
        System.out.println("Pending Gym Center Requests:");
        for(FlipFitGymDetails x : adminDAO.viewPendingCenter()){
            System.out.println(x);
        }
    }

    /**
     * Method to remove Gym Owners
     * @param ownerId
     * @throws GymOwnerNotFoundException
     */
    @Override
    public void removeGymOwner(int ownerId) {
        boolean res= adminDAO.removeGymOwner(ownerId);
        if (res){
            System.out.println("Gym Owner with ID " + ownerId + " has been removed successfully.");
        }
        else{
            System.out.println("Gym Owner with ID " + ownerId + " could not be found!!");
        }
    }
}
