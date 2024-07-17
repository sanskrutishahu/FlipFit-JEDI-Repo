package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.List;

public class BookGymDAOImpl implements BookGymDAOInterface{

    @Override
    public void createBooking(Booking booking) {

    }

    @Override
    public void bookSlots(Booking booking) {

    }

    @Override
    public List<Booking> viewBookings(int userId) {
        return List.of();
    }

    @Override
    public void cancelBookings(int bookingId) {

    }
}
