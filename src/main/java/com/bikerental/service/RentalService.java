package com.bikerental.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikerental.entity.AppUser;
import com.bikerental.entity.Bike;
import com.bikerental.entity.Rental;
import com.bikerental.repository.AppUserRepository;
import com.bikerental.repository.BikeRepository;
import com.bikerental.repository.RentalRepository;
@Service
public class RentalService {
	@Autowired
	private BikeRepository bikeRepository;
	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private RentalRepository rentalRepository;
	
	public String rentBike(Long userId, Long bikeId) {
		
		Bike bike = bikeRepository.findById(bikeId)
				.orElseThrow(() -> new RuntimeException("Bike is Not Found"));
		
		if(!bike.isAvailable()) {
			return "Bike is already rented";
		}
		
		AppUser user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User Not Found"));
		
		Rental rental = new Rental();
		rental.setBike(bike);
		rental.setUser(user);
		rental.setStartTime(LocalDateTime.now());
		
		bike.setAvailable(false);
		
		rentalRepository.save(rental);
		bikeRepository.save(bike);
		return "Bike rented successfully";		
	}
	
	public String returnBike(Long rentalId) {
		Rental rental = rentalRepository.findById(rentalId).orElseThrow(() -> new RuntimeException("Rental not found"));
		if(rental.getEndTime()!=null) {
			return "Bike already returned";
		}
		rental.setEndTime(LocalDateTime.now());
		
		long hours = Duration.between(rental.getStartTime(),rental.getEndTime()).toHours();
		
		if(hours==0) {
			hours = 1;
		}
		
		double cost = hours*rental.getBike().getPricePerHour();
		rental.setTotalCost(cost);
		
		Bike bike = rental.getBike();
		bike.setAvailable(true);
		
		
		rentalRepository.save(rental);
		bikeRepository.save(bike);
		
		return "Bike returned. Total Cost: "+ cost;
	}

}
