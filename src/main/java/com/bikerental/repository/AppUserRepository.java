package com.bikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikerental.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}
