package com.driven.carsapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.driven.carsapi.dto.CarDTO;
import com.driven.carsapi.model.Car;
import com.driven.carsapi.repository.CarRepository;

@RestController
public class CarsController {

    //List<CarDTO> cars = new ArrayList<>();
    
    @Autowired
    private CarRepository repository;

    @GetMapping("/cars")
    public List<Car> listAll(){
        return repository.findAll();
    }

    @PostMapping("/cars/insert")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody CarDTO req) {
        //cars.add(req);
        repository.save(new Car(req));
    }
}
