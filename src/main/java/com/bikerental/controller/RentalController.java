package com.bikerental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.bikerental.service.RentalService;

@RestController
@RequestMapping("/rent")
public class RentalController {
	@Autowired
	private RentalService rentalService;
	//rent bike api
	@PostMapping
	public String rentBike(@RequestParam Long userId,
						   @RequestParam Long bikeId) {
		return rentalService.rentBike(userId, bikeId);	
	}
	//return bike api
	@PostMapping("/return")
	public String returnBike(@RequestParam Long rentalId) {
	    return rentalService.returnBike(rentalId);
	}
	
}

