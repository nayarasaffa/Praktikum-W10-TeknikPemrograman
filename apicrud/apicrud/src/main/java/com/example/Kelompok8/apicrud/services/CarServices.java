package com.example.Kelompok8.apicrud.services;

import com.example.Kelompok8.apicrud.entities.CarEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarServices {

    CarEntity addCar(CarEntity param);

    List<CarEntity> getAllCar();

    CarEntity getCarById(int id);

    CarEntity updateCar(CarEntity param);

    void deleteCar(int id);
}
