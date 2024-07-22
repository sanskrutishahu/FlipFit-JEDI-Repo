package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.SlotDetails;
import com.flipkart.dao.FLipFitGymOwnerDAOInterface;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;

import java.util.HashMap;
import java.util.List;

/**
 * Implementation for methods related to Gym Owner
 */
public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface{

    FLipFitGymOwnerDAOInterface fLipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();

    /**
     * Method to Create a Gym Owner
     * @param ownerName
     * @param ownerPhone
     * @param ownerAddress
     * @param ownerGstNum
     * @param ownerPanNum
     * @param approvalStatus
     * @param ownerId
     */
    @Override
    public void createGymOwner(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum,String approvalStatus, int ownerId) {
        fLipFitGymOwnerDAO.createGymOwner(ownerName,ownerPhone,ownerAddress,ownerGstNum,ownerPanNum,ownerId);
    }

    /**
     * Method to Edit Profile of Gym Owner
     * @param ownerName
     * @param ownerPhone
     * @param ownerAddress
     * @param ownerGstNum
     * @param ownerPanNum
     * @param ownerId
     */
    @Override
    public void editProfile(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId) {
        fLipFitGymOwnerDAO.editProfile(ownerName,ownerPhone,ownerAddress,ownerGstNum,ownerPanNum,ownerId);
    }

    /**
     * Method to Register Gym
     * @param gymOwnerId
     * @param gymName
     * @param gymAddress
     */
    @Override
    public void registerGym(int gymOwnerId, String gymName, String gymAddress) {
        fLipFitGymOwnerDAO.registerGym(gymOwnerId, gymName, gymAddress);
    }

    /**
     * Method to Edit Gym details
     * @param gymId
     * @param gymOwnerId
     * @param gymName
     * @param gymAddress
     * @param noOfSlots
     */
    @Override
    public void editGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots) {
        fLipFitGymOwnerDAO.editGym(gymId, gymOwnerId, gymName, gymAddress, noOfSlots);
    }

    /**
     * Method to Delete a Gym
     * @param gymId
     */
    @Override
    public void removeGym(int gymId) {
        fLipFitGymOwnerDAO.removeGym(gymId);
    }

    /**
     * Method to view all registed Gym centers
     * @param userId
     */
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

    /**
     * Method to view all bookings by a user
     * @param userId
     * @return UserBookingList
     */
    @Override
    public List<Booking> viewAllBookings(int userId) {
        return fLipFitGymOwnerDAO.viewAllBookings(userId);
    }

    /**
     * Method to view all bookings in a gym
     * @param gymId
     * @return GymBookingList
     */
    @Override
    public List<Booking> viewBookings(int gymId) {
        return fLipFitGymOwnerDAO.viewBookings(gymId);
    }

    /**
     * Method to view all available slots in a gym
     * @param gymId
     * @param date
     */
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

    /**
     * Method to add slot
     * @param gymId
     * @param date
     * @param startTime
     * @param endTime
     * @param noOfSeats
     */
    @Override
    public void addSlot(int gymId, String date, String startTime, String endTime, int noOfSeats) {
        fLipFitGymOwnerDAO.addSlot(gymId,date,startTime,endTime,noOfSeats);
    }

    /**
     * Method to remove a slot
     * @param gymId
     * @param slotId
     */
    @Override
    public void removeSlot(int gymId, int slotId) {
        fLipFitGymOwnerDAO.removeSlot(gymId, slotId);
    }
}
