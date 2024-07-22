package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.SlotDetails;

import java.util.HashMap;
import java.util.List;

public interface FlipFitGymOwnerInterface {

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
    public void createGymOwner(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum,String approvalStatus,int ownerId);

    /**
     * Method to Edit Profile of Gym Owner
     * @param ownerName
     * @param ownerPhone
     * @param ownerAddress
     * @param ownerGstNum
     * @param ownerPanNum
     * @param ownerId
     */
    public void editProfile(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId);

    /**
     * Method to Register Gym
     * @param gymOwnerId
     * @param gymName
     * @param gymAddress
     */
    public void registerGym(int gymOwnerId, String gymName, String gymAddress);

    /**
     * Method to Edit Gym details
     * @param gymId
     * @param gymOwnerId
     * @param gymName
     * @param gymAddress
     * @param noOfSlots
     */
    public void editGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots);

    /**
     * Method to Delete a Gym
     * @param gymId
     */
    public void removeGym(int gymId);

    /**
     * Method to view all registed Gym centers
     * @param userId
     */
    public void viewAllRegisteredGymCenters(int userId);

    /**
     * Method to view all bookings by a user
     * @param userId
     * @return UserBookingList
     */
    public List<Booking> viewAllBookings(int userId);

    /**
     * Method to view all bookings in a gym
     * @param gymId
     * @return GymBookingList
     */
    public List<Booking> viewBookings(int gymId);

    /**
     * Method to view all available slots in a gym
     * @param gymId
     * @param date
     */
    public void viewAvailableSlots(int gymId, String date);

    /**
     * Method to add slot
     * @param userId
     * @param date
     * @param startTime
     * @param endTime
     * @param noOfSeats
     */
    public void addSlot(int gymId, String date, String startTime, String endTime, int noOfSeats);

    /**
     * Method to remove a slot
     * @param gymId
     * @param slotId
     */
    public void removeSlot( int gymId, int slotId);
}
