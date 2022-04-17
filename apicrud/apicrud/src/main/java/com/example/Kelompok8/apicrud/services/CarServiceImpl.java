package com.example.Kelompok8.apicrud.services;

import com.example.Kelompok8.apicrud.entities.CarEntity;
import com.example.Kelompok8.apicrud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarServices {
    @Autowired
    CarRepository carRepository;

    @Override
    public CarEntity addCar(CarEntity param){
        carRepository.save(param);
        return param;
    }

    @Override
    public List<CarEntity> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getCarById(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntity updateCar(CarEntity param) {

        CarEntity findCar = carRepository.findById(param.getId()).get();
        findCar.setCarName(param.getCarName());
        findCar.setColor(param.getColor());
        findCar.setNumber(param.getNumber());
        findCar.setType(param.getType());

        return carRepository.save(findCar);
    }

    @Override
    public void deleteCar(int id) {

    }
}
