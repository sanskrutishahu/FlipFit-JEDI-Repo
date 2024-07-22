package com.flipkart.business;

import com.flipkart.bean.Booking;

import java.util.List;

public interface FlipFitGymBookingInterface {

    /**
     * Method to create booking in a Gym center
     * @param bookingId
     * @param userId
     * @param bookingDate
     * @param bookingTimeSlotStart
     * @param bookingTimeSlotEnd
     * @param bookingStatus
     * @param transactionId
     * @param bookingAmount
     */
    public void createBooking(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount);

    /**
     * Method to book slot in a Gym center
     * @param bookingId
     * @param userId
     * @param bookingDate
     * @param bookingTimeSlotStart
     * @param bookingTimeSlotEnd
     * @param bookingStatus
     * @param transactionId
     * @param bookingAmount
     * @throws BookingFailedException
     */
    public void bookSlots(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount);

    /**
     * Method to return list of bookings by a particular user
     * @param userId
     * @return BookingList
     */
    public List<Booking> viewBookings(int userId);

    /**
     * Method to cancel a booking
     * @param bookingId
     */
    public void cancelBookings(int bookingId);

    /**
     * Method to do payment
     * @param userId
     * @param paymentDetails
     * @param expiryDate
     * @param modeOfPayment
     */
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) ;
}
