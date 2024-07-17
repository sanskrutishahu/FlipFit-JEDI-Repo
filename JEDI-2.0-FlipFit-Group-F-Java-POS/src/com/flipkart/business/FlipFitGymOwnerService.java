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
    public void createGymOwner(FlipFitGymOwner flipFitGymOwner) {
        fLipFitGymOwnerDAO.createGymOwner(flipFitGymOwner);
    }

    @Override
    public void editProfile(FlipFitGymOwner flipFitGymOwner) {
        fLipFitGymOwnerDAO.editProfile(flipFitGymOwner);
    }

    @Override
    public void registerGym(FlipFitGymDetails flipFitGymDetails) {
        fLipFitGymOwnerDAO.registerGym(flipFitGymDetails);
    }

    @Override
    public void editGym(FlipFitGymDetails flipFitGymDetails) {
        fLipFitGymOwnerDAO.editGym(flipFitGymDetails);
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
