package com.flipkart.bean;

public class Booking {
    private int bookingId;          
    private int customerId;
    private int slotId;
    private int status; 
    
    
    public Booking(int bookingId,int userId,int slotId,int status) {
        this.bookingId=bookingId;
        this.customerId =userId;
        this.slotId=slotId;
        this.status=status;
    }

    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    public int getCustomerId(){
        return customerId;
    }
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public int getSlotId(){
        return slotId;
    }
    public void setSlotId(int slotId){
        this.slotId=slotId;
    }
    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status=status;
    }
}
