package com.driven.carsapi.dto;

public record CarDTO(String modelo, String fabricante, String dataFabricacao, Double valor, Long anoModelo ) {

}


// {
// 	"modelo": "Fiat Argo 1.3",
// 	"fabricante": "Fiat",
// 	"dataFabricacao": "10/02/2006",
// 	"valor": 10.000,
// 	"anoModelo": 2023,
// }