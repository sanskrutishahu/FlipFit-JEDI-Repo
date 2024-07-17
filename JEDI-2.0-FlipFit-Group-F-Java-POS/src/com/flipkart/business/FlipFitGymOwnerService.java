package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;

import java.util.HashMap;
import java.util.List;

public class FlipFitGymOwnerService implements FlipFitGymOwnerInterface{
    @Override
    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no) {

    }

    @Override
    public void editProfile(int userId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum) {

    }

    @Override
    public void registerGym(int userId, String name, String location) {

    }

    @Override
    public void editGym(int gymId, String gymName, String gymLocation) {

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
    public HashMap<String, Integer> viewAvailableSlots(int gymId, String date) {
        return null;
    }

    @Override
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity, int slotPrice) {

    }

    @Override
    public void removeSlot(int gymId, int slotId) {

    }
}
