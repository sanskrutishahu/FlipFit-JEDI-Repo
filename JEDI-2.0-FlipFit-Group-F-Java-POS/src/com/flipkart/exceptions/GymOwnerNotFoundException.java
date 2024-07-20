package com.flipkart.exceptions;

/**
 * Exception thrown when a gym center is not found.
 */
public class GymOwnerNotFoundException extends Exception {

    /**
     * Constructs a new GymNotFoundException with the specified gymId.
     *
     * @param gymId the ID of the gym center that was not found.
     */
    public GymOwnerNotFoundException(int gymOwnerId) {
        super("Gym Owner with ID " + gymOwnerId + " not found!");
    }
}
