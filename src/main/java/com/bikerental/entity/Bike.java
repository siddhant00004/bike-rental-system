package com.bikerental.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bike {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brands;
	private String model;
	private double pricePerHour;
	private boolean available;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrands() {
		return brands;
	}
	public void setBrands(String brands) {
		this.brands = brands;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPricePerHour() {
		return pricePerHour;
	}
	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
