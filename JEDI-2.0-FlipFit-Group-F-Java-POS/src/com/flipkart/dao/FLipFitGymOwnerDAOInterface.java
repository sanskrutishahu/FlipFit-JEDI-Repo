package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.SlotDetails;

import java.util.List;

public interface FLipFitGymOwnerDAOInterface {

    public void createGymOwner(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId);
    public void editProfile(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId);
    public void registerGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots);
    public void editGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots);
    public void removeGym(int gymId);
    public List<FlipFitGymDetails> viewAllRegisteredGymCenters(int userId);
    public List<Booking> viewAllBookings(int userId);
    public List<Booking> viewBookings(int gymId);
    public List<SlotDetails> viewAvailableSlots(int gymId);
    public void addSlot(SlotDetails slotDetails);
    public void removeSlot( int gymId,int slotId);
}
