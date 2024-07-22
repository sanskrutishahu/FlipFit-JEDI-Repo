package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookGymDAOImpl;
import com.flipkart.dao.BookGymDAOInterface;

import java.util.List;

public class FlipFitGymBookingService implements FlipFitGymBookingInterface {

    BookGymDAOInterface bookGymDAO = new BookGymDAOImpl();
    @Override
    public void createBooking(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount) {
        System.out.println("Booking can't be created like this.");
    }

    @Override
    public void bookSlots(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount) {
        bookGymDAO.bookSlots(bookingId,userId,slotId,bookingDate,bookingTimeSlotStart,bookingTimeSlotEnd,bookingStatus,transactionId,bookingAmount);
//        System.out.println("Slot booked successfully.");
    }

    @Override
    public List<Booking> viewBookings(int userId) {
        return bookGymDAO.viewBookings(userId);
//        Booking booking = new Booking(
//               1,
//               2,
//               3,
//               "18-7-2024",
//               "21-07-2024|15:06",
//                "21-07-2024|16:00",
//                1,
//                4,
//                500
//        );
//        List<Booking> bookings = new ArrayList<>();
//        bookings.add(booking);
//        return bookings;
    }

    @Override
    public void cancelBookings(int bookingId) {
        bookGymDAO.cancelBookings(bookingId);
//        System.out.println("Booking is cancelled");
    }

    @Override
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) {
        return 0;
    }
}
