package com.driven.carsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driven.carsapi.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    
}
