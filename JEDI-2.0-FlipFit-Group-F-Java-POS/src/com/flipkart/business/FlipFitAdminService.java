package com.flipkart.business;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.FlipFitAdminDAOImpl;
import com.flipkart.dao.FlipFitAdminDAOInterface;

import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminService implements FlipFitAdminInterface {

    FlipFitAdminDAOInterface adminDAO = new FlipFitAdminDAOImpl();

    @Override
    public void createAdmin(String customUserName, int adminId) {
        System.out.println("Admin is Created");
    }

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
