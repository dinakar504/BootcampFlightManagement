package com.capg.bs.service;

import java.util.List;
import java.util.Optional;

import com.capg.bs.dto.Booking;

public interface ServiceInterface {

	Optional<Booking> getBookingDetails(long bookingId);

	List<Booking> getAllBookingDetails();

	Booking getBooking(long bookingId);

	Booking addBookingDetails(Booking booking);

	void updateBookingDetails(Booking booking);

	void deleteBookingDetails(long bookingId, Booking booking);

}
