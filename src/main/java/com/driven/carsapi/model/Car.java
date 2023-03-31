package com.driven.carsapi.model;

import java.util.Date;

import com.driven.carsapi.dto.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Car {

    public Car(CarDTO data){
        this.anoModelo = data.anoModelo();
        this.dataFabricacao = data.dataFabricacao();
        this.fabricante = data.fabricante();
        this.modelo = data.modelo();
        this.valor = data.valor();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 150, nullable = false)
    private String modelo;

    @Column(length = 50, nullable = false)
    private String fabricante;

    @Column(length = 10, nullable = false)
    private Date dataFabricacao;

    @Column (length = 15, nullable = false)
    private Double valor;

    @Column(length = 4, nullable = false)
    private Long anoModelo;
}