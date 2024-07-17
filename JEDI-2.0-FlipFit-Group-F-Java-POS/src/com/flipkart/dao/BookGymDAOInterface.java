package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.List;

public interface BookGymDAOInterface {

    public void createBooking(int bookingId, int customerId, int slotId, int status);

    public void bookSlots();

    public List<Booking> viewBookings(int userId);

    public void cancelBookings(int bookingId);

}
