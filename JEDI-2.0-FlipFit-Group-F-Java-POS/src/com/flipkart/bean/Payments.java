package com.flipkart.bean;

public class Payments {

    private int transactionId;
    private String paymentDetails;
    private String expiryDate;
    private String modeOfPayment;

    public Payments(int transactionId, String paymentDetails, String expiryDate, String modeOfPayment) {
        this.transactionId = transactionId;
        this.paymentDetails = paymentDetails;
        this.expiryDate = expiryDate;
        this.modeOfPayment = modeOfPayment;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
}
