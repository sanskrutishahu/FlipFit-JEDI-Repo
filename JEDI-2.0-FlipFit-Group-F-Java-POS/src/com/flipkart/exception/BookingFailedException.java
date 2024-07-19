package com.flipkart.exceptions;

/**
 * Exception thrown when a booking fails.
 */
public class BookingFailedException extends Exception {

    /**
     * Constructs a new BookingFailedException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     */
    public BookingFailedException(String message) {
        super(message);
        System.out.println("Booking Failed, please try again after some time");
    }
}
