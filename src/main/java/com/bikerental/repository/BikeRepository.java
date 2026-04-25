package com.bikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikerental.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
