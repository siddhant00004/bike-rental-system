package com.bikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikerental.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
