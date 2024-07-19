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
    public void registerGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots) {
        fLipFitGymOwnerDAO.registerGym(gymId, gymOwnerId, gymName, gymAddress, noOfSlots);
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
    public List<FlipFitGymDetails> viewAllRegisteredGymCenters(int userId) {
        return fLipFitGymOwnerDAO.viewAllRegisteredGymCenters(userId);
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
    public HashMap<String, Integer> viewAvailableSlots(int gymId, String date) {
        return null;
    }

    @Override
    public void addSlot(SlotDetails slotDetails) {
        fLipFitGymOwnerDAO.addSlot(slotDetails);
        System.out.println("Added slot");
    }

    @Override
    public void removeSlot(int gymId, int slotId) {
        fLipFitGymOwnerDAO.removeSlot(gymId, slotId);
        System.out.println("Removed slot " + slotId + " for gym " + gymId);
    }
}
