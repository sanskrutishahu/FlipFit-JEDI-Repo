package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.SlotDetails;

import java.util.List;

/**
 * This interface defines methods to manage gym owners and their gyms in the FlipFit application.
 */
public interface FLipFitGymOwnerDAOInterface {

    /**
     * Creates a new gym owner with the provided details.
     *
     * @param ownerName     The name of the gym owner.
     * @param ownerPhone    The phone number of the gym owner.
     * @param ownerAddress  The address of the gym owner.
     * @param ownerGstNum   The GST number of the gym owner.
     * @param ownerPanNum   The PAN number of the gym owner.
     * @param ownerId       The unique ID of the gym owner.
     */
    public void createGymOwner(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId);

    /**
     * Edits the profile details of an existing gym owner.
     *
     * @param ownerName     The updated name of the gym owner.
     * @param ownerPhone    The updated phone number of the gym owner.
     * @param ownerAddress  The updated address of the gym owner.
     * @param ownerGstNum   The updated GST number of the gym owner.
     * @param ownerPanNum   The updated PAN number of the gym owner.
     * @param ownerId       The unique ID of the gym owner.
     */
    public void editProfile(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, int ownerId);

    /**
     * Registers a new gym under an existing gym owner.
     *
     * @param gymOwnerId    The ID of the gym owner registering the gym.
     * @param gymName       The name of the gym.
     * @param gymAddress    The address of the gym.
     */
    public void registerGym(int gymOwnerId, String gymName, String gymAddress);

    /**
     * Edits the details of an existing gym.
     *
     * @param gymId         The ID of the gym to be edited.
     * @param gymOwnerId    The ID of the gym owner who owns the gym.
     * @param gymName       The updated name of the gym.
     * @param gymAddress    The updated address of the gym.
     * @param noOfSlots     The updated number of available slots in the gym.
     */
    public void editGym(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots);

    /**
     * Removes a gym from the system.
     *
     * @param gymId     The ID of the gym to be removed.
     */
    public void removeGym(int gymId);

    /**
     * Retrieves a list of all gyms registered by a specific gym owner.
     *
     * @param userId    The ID of the gym owner whose gyms are to be retrieved.
     * @return          A list of FlipFitGymDetails objects representing the gyms.
     */
    public List<FlipFitGymDetails> viewAllRegisteredGymCenters(int userId);

    /**
     * Retrieves a list of all bookings made by a specific user.
     *
     * @param userId    The ID of the user whose bookings are to be retrieved.
     * @return          A list of Booking objects representing the bookings.
     */
    public List<Booking> viewAllBookings(int userId);


    /**
     * Retrieves a list of all bookings made for a specific gym.
     *
     * @param gymId     The ID of the gym for which bookings are to be retrieved.
     * @return          A list of Booking objects representing the bookings.
     */
    public List<Booking> viewBookings(int gymId);

    /**
     * Adds a new slot (time slot) for booking at a specific gym on a given date.
     *
     * @param gymId         The ID of the gym for which the slot is being added.
     * @param date          The date of the slot (in YYYY-MM-DD format).
     * @param startTime     The start time of the slot (in HH:MM format).
     * @param endTime       The end time of the slot (in HH:MM format).
     * @param noOfSeats     The number of available seats in the slot.
     */
    public List<SlotDetails> viewAvailableSlots(int gymId, String date);

    /**
     * Adds a new slot (time slot) for booking at a specific gym on a given date.
     *
     * @param gymId         The ID of the gym for which the slot is being added.
     * @param date          The date of the slot (in YYYY-MM-DD format).
     * @param startTime     The start time of the slot (in HH:MM format).
     * @param endTime       The end time of the slot (in HH:MM format).
     * @param noOfSeats     The number of available seats in the slot.
     */
    public void addSlot(int gymId, String date, String startTime, String endTime, int noOfSeats);

    /**
     * Removes a specific slot from a gym's schedule.
     *
     * @param gymId     The ID of the gym from which the slot is to be removed.
     * @param slotId    The ID of the slot to be removed.
     */
    public void removeSlot( int gymId,int slotId);
}
