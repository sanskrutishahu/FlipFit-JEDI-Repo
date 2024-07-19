package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.SlotDetails;
import com.flipkart.business.FlipFitGymOwnerInterface;

import java.util.List;

public class FlipFitGymOwnerDAOImpl implements FLipFitGymOwnerDAOInterface {


    @Override
    public void createGymOwner(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId) {

    }

    @Override
    public void editProfile(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId) {

    }

    @Override
    public void registerGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots) {

    }

    @Override
    public void editGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots) {

    }
    @Override
    public void removeGym(int gymId) {

    }

    @Override
    public List<FlipFitGymDetails> viewAllRegisteredGymCenters(int userId) {
        return List.of();
    }

    @Override
    public List<Booking> viewAllBookings(int userId) {
        return List.of();
    }

    @Override
    public List<Booking> viewBookings(int gymId) {
        return List.of();
    }

    @Override
    public List<SlotDetails> viewAvailableSlots(int gymId) {
        return List.of();
    }

    @Override
    public void addSlot(SlotDetails slotDetails) {

    }

    @Override
    public void removeSlot(int gymId, int slotId) {

    }
}
