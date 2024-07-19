package com.flipkart.exceptions;

/**
 * Exception thrown when login fails due to incorrect credentials.
 */
public class LoginFailedException extends RuntimeException {

    /**
     * Constructs a new LoginFailedException with the specified detail message.
     *
     * @param message the detail message that describes the login failure.
     */
    public LoginFailedException(String message) {
        super(message);
        System.out.println("Login Failed!!, please try again after some time"); // Assuming this is for console output, not part of exception handling
    }
}
