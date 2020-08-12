package com.capg.bs.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capg.bs.dao.BookingDAO;
import com.capg.bs.dto.Booking;

@Service
public class BookingService implements ServiceInterface
{
	@Autowired
	BookingDAO bookingDao;

	@Override
	public Optional<Booking> getBookingDetails(long bookingId)
	{
		return bookingDao.findById(bookingId);
	}
	@Override
	public Booking getBooking(long bookingId)
	{  if(bookingDao.existsById(bookingId))
	{
		Booking book=bookingDao.getBooking(bookingId);
		return book;
	}
	else
		return  null;
	}
	@Override
	public List<Booking> getAllBookingDetails()
	{
		return bookingDao.findAll(Sort.by(Sort.Direction.DESC, "bookingId"));
	}
	@Override
	public Booking addBookingDetails(Booking booking)
	{
		return bookingDao.save(booking);
	}
	@Override
	public void updateBookingDetails(Booking booking)
	{
		bookingDao.save(booking);
	}
	@Override
	public void deleteBookingDetails(long bookingId, Booking booking)
	{
		bookingDao.deleteById(bookingId);
		
	}
}
