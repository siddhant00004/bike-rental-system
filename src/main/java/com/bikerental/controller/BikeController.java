package com.bikerental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikerental.entity.Bike;
import com.bikerental.repository.BikeRepository;

@RestController
@RequestMapping("/bikes")
public class BikeController {
	@Autowired
	private BikeRepository bikeRepository;
	@PostMapping
	public Bike addBike(@RequestBody Bike bike) {
		bike.setAvailable(true);
		return bikeRepository.save(bike);
	}
	@GetMapping
	public List<Bike> getAllBikes(){
		return bikeRepository.findAll();
	}
}
