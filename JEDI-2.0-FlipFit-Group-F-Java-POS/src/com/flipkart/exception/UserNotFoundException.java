package com.flipkart.exceptions;

/**
 * Exception thrown when a user is not found.
 */
public class UserNotFoundException extends Exception {

    /**
     * Constructs a new UserNotFoundException with the specified detail message.
     *
     * @param message the detail message that describes the user not found condition.
     */
    public UserNotFoundException(String message) {
        super(message);
        System.out.println("User not found!!"); // Assuming this is for console output, not part of exception handling
    }
}