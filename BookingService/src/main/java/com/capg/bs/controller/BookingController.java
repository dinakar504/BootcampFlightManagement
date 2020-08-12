package com.capg.bs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bs.dto.Booking;
import com.capg.bs.dto.Passengers;
import com.capg.bs.exception.NotFoundException;
import com.capg.bs.service.BookingService;
import com.capg.bs.service.PassengersService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookingController 
{
	@Autowired
	BookingService bookingService;

	@Autowired
	PassengersService passengersService;
	
	@GetMapping(value="/getBookingDetails/{bookingId}",produces="application/json")
	public ResponseEntity<Booking> getBookingDetails(@PathVariable long bookingId) throws NotFoundException
	{
		Booking book=bookingService.getBooking(bookingId);
		if(book!=null)
		{
			return new ResponseEntity<Booking>(book,HttpStatus.OK);
			
		}
		else
			throw new NotFoundException("not found");
		 
	}

	@PostMapping(value="/addBookingDetails")
	public ResponseEntity<String> addBookingDetails(@RequestBody()Booking booking)
	{ 
		for(Passengers p : booking.getPassengers())
			passengersService.addPassenger(p);
		Booking b = bookingService.addBookingDetails(booking);
	
        if(b.getBookingId()>0)
        	return new ResponseEntity<String>("{\"bookingId\":" + b.getBookingId() + "}",HttpStatus.OK);
	return new ResponseEntity<String>("Booking not created",HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value="/getAllBookingDetails",produces="application/json")
	public ResponseEntity<List<Booking>> getAllBookingDetails() throws NotFoundException
	{
		List<Booking> book=bookingService.getAllBookingDetails();
		if(book!=null)
		{
			return new ResponseEntity<List<Booking>>(book,HttpStatus.OK);
		}
		else
			throw new NotFoundException("no records found");
		
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> usernotfound(NotFoundException e)
	{
		return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
	}
}

