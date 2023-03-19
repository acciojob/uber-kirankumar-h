package com.driver.services.impl;

import com.driver.model.*;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		//Save the customer in database
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function

	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query
		List<Driver> driverList = driverRepository2.findAll();

		Cab cab = null;
		Driver driver = null;
		for(Driver driver1 : driverList){
		    if(	driver1.getCab().isAvailable()){
				driver = driver1;
				driver.getCab().setAvailable(false);
				break;
			}
		}
      if (driver ==null) throw new Exception("No cab available!");

	  TripBooking tripBooking = new TripBooking();

	  Customer customer = customerRepository2.findById(customerId).get();

	  int ratePKm = driver.getCab().getPerKMRate();

	  int bill = ratePKm * distanceInKm;

	  tripBooking.setFrom_Location(fromLocation);
	  tripBooking.setTo_Location(toLocation);
	  tripBooking.setStatus(TripStatus.CONFIRMED);
	  tripBooking.setBill(bill);
	  tripBooking.setDistanceInKm(distanceInKm);

       tripBooking.setCustomer(customer);
	   tripBooking.setDriver(driver);

	   driver.getTripBookingList().add(tripBooking);
	   customer.getTripBookingList().add(tripBooking);

	   driverRepository2.save(driver);
	   customerRepository2.save(customer);

	   return tripBooking;
	}

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
       TripBooking tripBooking = tripBookingRepository2.findById(tripId).get();

	   tripBooking.setStatus(TripStatus.CANCELED);
	   tripBooking.setBill(0);

	   tripBookingRepository2.save(tripBooking);
	}

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking tripBooking = tripBookingRepository2.findById(tripId).get();

		tripBooking.setStatus(TripStatus.COMPLETED);
		tripBookingRepository2.save(tripBooking);
	}
}
