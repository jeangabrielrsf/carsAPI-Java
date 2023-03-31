package com.driven.carsapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.driven.carsapi.dto.CarDTO;

@RestController
public class CarsController {

    List<CarDTO> cars = new ArrayList<>(); 

    @GetMapping("/cars")
    public List<CarDTO> listAll(){
        return cars;
    }

    @PostMapping("/cars/insert")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody CarDTO req) {
        cars.add(req);
    }
}
