package com.capg.bs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.bs.dto.Airport;
import com.capg.bs.dto.Booking;
import com.capg.bs.dto.Flight;
import com.capg.bs.dto.FlightSchedule;
import com.capg.bs.dto.Passengers;
import com.capg.bs.dto.Users;
import com.capg.bs.service.BookingService;
import com.capg.bs.service.PassengersService;

@SpringBootTest
class BookingServiceApplicationTests {
	@Autowired
	BookingService service;
	@Autowired
	PassengersService passengersService;
	
	@Test
	void addBookingdetailsTest() {
		long bookingid=4;
		List<Passengers> passen = new ArrayList<Passengers>();
		Flight fiy=new Flight( "159", "AirIndia",220);
		Airport airport=new Airport("Banglore",
                "Kempegowda",
              "Banglore");
		FlightSchedule flightScheduleList = new FlightSchedule("149",fiy,airport,airport,3000,null,null);
		Users user=new Users("dinakar","din123","dinakar",'m',"din@gmail.com",970544098);
		Booking book=new Booking(bookingid,user,flightScheduleList,null,null,passen);
		for(Passengers p : book.getPassengers())
			passengersService.addPassenger(p);
		Booking book1=service.addBookingDetails(book);
		assertNotEquals(book1.getBookingId(), 4);
		
		
	
	}
	

	@Test
	void getDetailsTest() {
		//get test case
	assertEquals(11,service.getBooking(11).getBookingId());
	}
	@Test
	void getDetails1Test() {
		//get test case
	assertEquals(service.getBooking(4),null);
	}
	@Test
	void getAllDetails1Test() {
		//get test case
	assertNotEquals(service.getAllBookingDetails(),null);
	}


}
