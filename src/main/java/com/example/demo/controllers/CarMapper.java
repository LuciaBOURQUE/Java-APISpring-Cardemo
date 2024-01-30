package com.example.demo.controllers;

import com.example.demo.models.Car;

import java.time.Year;

public class CarMapper {
    public static CarDTO convertEntityToDto(Car entity){
        CarDTO dto = new CarDTO();
        dto.setId(entity.getId());
        dto.setMarque(entity.getLabel());
        dto.setModele(entity.getModel());
        dto.setAnnnee(entity.getYear());
        dto.setColor(entity.getColor());
        dto.setAge(Year.now().getValue() - entity.getYear());
        return dto;
    }

    public static Car convertDtoToEntity(CarDTO dto){
        Car entity = new Car();
        entity.setId(dto.getId());
        entity.setLabel(dto.getMarque());
        entity.setModel(dto.getModele());
        entity.setYear(dto.getAnnnee());
        entity.setColor(dto.getColor());
        return entity;
    }
}
