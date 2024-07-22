package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.List;

/**
 * Interface defining operations related to gym bookings.
 */
public interface BookGymDAOInterface {

    /**
     * Creates a new booking in the gym system.
     *
     * @param bookingId              The unique identifier for the booking.
     * @param userId                 The ID of the user making the booking.
     * @param slotId                 The ID of the time slot for the booking.
     * @param bookingDate            The date of the booking in string format.
     * @param bookingTimeSlotStart   The start time of the booking time slot in string format.
     * @param bookingTimeSlotEnd     The end time of the booking time slot in string format.
     * @param bookingStatus          The status of the booking (e.g., confirmed, pending).
     * @param transactionId          The ID of the transaction associated with the booking.
     * @param bookingAmount          The amount paid for the booking (if applicable).
     */
    public void createBooking(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount);

    /**
     * Books slots for a user in the gym system.
     *
     * @param bookingId              The unique identifier for the booking.
     * @param userId                 The ID of the user making the booking.
     * @param slotId                 The ID of the time slot for the booking.
     * @param bookingDate            The date of the booking in string format.
     * @param bookingTimeSlotStart   The start time of the booking time slot in string format.
     * @param bookingTimeSlotEnd     The end time of the booking time slot in string format.
     * @param bookingStatus          The status of the booking (e.g., confirmed, pending).
     * @param transactionId          The ID of the transaction associated with the booking.
     * @param bookingAmount          The amount paid for the booking (if applicable).
     */
    public void bookSlots(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount);

    /**
     * Retrieves a list of bookings for a specific user.
     *
     * @param userId  The ID of the user whose bookings are to be retrieved.
     * @return        A List of Booking objects representing the user's bookings.
     */
    public List<Booking> viewBookings(int userId);

    /**
     * Cancels a booking based on the booking ID.
     *
     * @param bookingId  The ID of the booking to be canceled.
     */
    public void cancelBookings(int bookingId);
}
