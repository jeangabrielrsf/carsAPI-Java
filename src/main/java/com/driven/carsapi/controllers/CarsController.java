package com.driven.carsapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.driven.carsapi.dto.CarDTO;
import com.driven.carsapi.model.Car;
import com.driven.carsapi.repository.CarRepository;

import jakarta.validation.Valid;

@RestController
public class CarsController {
    
    @Autowired
    private CarRepository repository;

    @GetMapping("/cars")
    public List<Car> listAll(){
        return repository.findAll();
    }

    @PostMapping("/cars/insert")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody @Valid CarDTO req) {
        repository.save(new Car(req));
    }

    @DeleteMapping("/cars/delete/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/cars/update/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req ){
        repository.findById(id).map(car -> {
            car.setAnoModelo(req.anoModelo());
            car.setDataFabricacao(req.dataFabricacao());
            car.setFabricante(req.fabricante());
            car.setModelo(req.modelo());
            car.setValor(req.valor());
            return repository.save(car);
        });
        
    }
}
