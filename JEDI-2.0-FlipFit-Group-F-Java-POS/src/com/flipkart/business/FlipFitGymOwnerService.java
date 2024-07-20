package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.SlotDetails;
import com.flipkart.dao.FLipFitGymOwnerDAOInterface;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;

import java.util.HashMap;
import java.util.List;

public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface{

    FLipFitGymOwnerDAOInterface fLipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();

    @Override
    public void createGymOwner(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum,String approvalStatus, int ownerId) {
        fLipFitGymOwnerDAO.createGymOwner(ownerName,ownerPhone,ownerAddress,ownerGstNum,ownerPanNum,ownerId);
    }

    @Override
    public void editProfile(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId) {
        fLipFitGymOwnerDAO.editProfile(ownerName,ownerPhone,ownerAddress,ownerGstNum,ownerPanNum,ownerId);
    }

    @Override
    public void registerGym(int gymOwnerId, String gymName, String gymAddress) {
        fLipFitGymOwnerDAO.registerGym(gymOwnerId, gymName, gymAddress);
    }

    @Override
    public void editGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots) {
        fLipFitGymOwnerDAO.editGym(gymId, gymOwnerId, gymName, gymAddress, noOfSlots);
    }

    @Override
    public void removeGym(int gymId) {
        fLipFitGymOwnerDAO.removeGym(gymId);
    }

    @Override
    public void viewAllRegisteredGymCenters(int userId) {
        if (fLipFitGymOwnerDAO.viewAllRegisteredGymCenters(userId).isEmpty())
        {
            System.out.println("No Gym registered yet!!");
            return;
        }
        System.out.println("-------- All Gym Details --------");
        for(FlipFitGymDetails x : fLipFitGymOwnerDAO.viewAllRegisteredGymCenters(userId)){
            System.out.println("Approval Status: "+x.getApprovalStatus().toString());
            System.out.println(x);
        }
    }

    @Override
    public List<Booking> viewAllBookings(int userId) {
        return fLipFitGymOwnerDAO.viewAllBookings(userId);
    }

    @Override
    public List<Booking> viewBookings(int gymId) {
        return fLipFitGymOwnerDAO.viewBookings(gymId);
    }

    @Override
    public void viewAvailableSlots(int gymId, String date) {
        fLipFitGymOwnerDAO.viewAvailableSlots(gymId,date);
        if (fLipFitGymOwnerDAO.viewAvailableSlots(gymId,date).isEmpty())
        {
            System.out.println("No Slots available right now, please try again later.");
            return;
        }
        System.out.println("-------- All Available Slot Details --------");
        for(SlotDetails x : fLipFitGymOwnerDAO.viewAvailableSlots(gymId,date)){
            System.out.println(x);
        }
    }

    @Override
    public void addSlot(int gymId, String date, String startTime, String endTime, int noOfSeats) {
        fLipFitGymOwnerDAO.addSlot(gymId,date,startTime,endTime,noOfSeats);
    }

    @Override
    public void removeSlot(int gymId, int slotId) {
        fLipFitGymOwnerDAO.removeSlot(gymId, slotId);
    }
}
