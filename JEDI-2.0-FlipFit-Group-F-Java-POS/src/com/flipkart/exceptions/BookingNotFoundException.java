package com.flipkart.exceptions;

/**
 * Exception thrown when a gym center is not found.
 */
public class BookingNotFoundException extends Exception {

    /**
     * Constructs a new BookingNotFoundException with the specified bookingId.
     *
     * @param bookingId the ID of the gym center that was not found.
     */
    public BookingNotFoundException(int bookingId) {
        super("Booking with " + bookingId + " ID not found!");
    }
}
