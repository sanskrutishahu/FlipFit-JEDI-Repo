package com.flipkart.bean;

/**
 * The Payments class represents the details of a payment transaction in the FlipFit system.
 * It includes details such as transaction ID, payment details, expiry date, and mode of payment.
 */
public class Payments {

    private int transactionId;
    private String paymentDetails;
    private String expiryDate;
    private String modeOfPayment;

    /**
     * Constructor to initialize a Payments object with all fields.
     *
     * @param transactionId   the unique identifier for the transaction
     * @param paymentDetails  the details of the payment
     * @param expiryDate      the expiry date of the payment method
     * @param modeOfPayment   the mode of payment (e.g., Credit Card, Debit Card, etc.)
     */
    public Payments(int transactionId, String paymentDetails, String expiryDate, String modeOfPayment) {
        this.transactionId = transactionId;
        this.paymentDetails = paymentDetails;
        this.expiryDate = expiryDate;
        this.modeOfPayment = modeOfPayment;
    }

    /**
     * Gets the unique identifier for the transaction.
     *
     * @return the transaction ID
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the unique identifier for the transaction.
     *
     * @param transactionId the transaction ID to set
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets the details of the payment.
     *
     * @return the payment details
     */
    public String getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * Sets the details of the payment.
     *
     * @param paymentDetails the payment details to set
     */
    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    /**
     * Gets the expiry date of the payment method.
     *
     * @return the expiry date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the expiry date of the payment method.
     *
     * @param expiryDate the expiry date to set
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Gets the mode of payment.
     *
     * @return the mode of payment
     */
    public String getModeOfPayment() {
        return modeOfPayment;
    }

    /**
     * Sets the mode of payment.
     *
     * @param modeOfPayment the mode of payment to set
     */
    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
}
