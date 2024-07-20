package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.SlotDetails;

import java.util.HashMap;
import java.util.List;

public interface FlipFitGymOwnerInterface {

    public void createGymOwner(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum,String approvalStatus,int ownerId);
    public void editProfile(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId);
    public void registerGym(int gymOwnerId, String gymName, String gymAddress);
    public void editGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots);
    public void removeGym(int gymId);
    public void viewAllRegisteredGymCenters(int userId);
    public List<Booking> viewAllBookings(int userId);
    public List<Booking> viewBookings(int gymId);
    public void viewAvailableSlots(int gymId, String date);
    public void addSlot(int gymId, String date, String startTime, String endTime, int noOfSeats);
    public void removeSlot( int gymId, int slotId);
}
