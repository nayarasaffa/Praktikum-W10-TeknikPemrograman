package com.example.Kelompok8.apicrud.controller;

import com.example.Kelompok8.apicrud.entities.CarEntity;
import com.example.Kelompok8.apicrud.repositories.CarRepository;
import com.example.Kelompok8.apicrud.response.CommonResponse;
import com.example.Kelompok8.apicrud.response.CommonResponseGenerator;
import com.example.Kelompok8.apicrud.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    CarServices carService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;
    @GetMapping(value = "checkAPI")
    public CommonResponse<String> checkAPI(){
        return commonResponseGenerator.successResponse("Hello World", "Succes Check API");
    }

    /* Add Data */
    @PostMapping(value = "addNewCar")
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param){
        try{
            CarEntity car = carService.addCar(param);
            return commonResponseGenerator.successResponse(car, "Success Add New Car");
        }catch(Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    /* Get All */
    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntity>> getAllCar(){
        try{
            List<CarEntity> carList = carService.getAllCar();
            return commonResponseGenerator.successResponse(carList, "Success Get All Car");
        }catch(Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    /* Get By Id */
    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int id){
        try{
            CarEntity car = carService.getCarById(id);
            return commonResponseGenerator.successResponse(car, "Success Get Car By Id: "+id);
        }catch(Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    /* Update by ID */
    @PostMapping(value = "updateCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param){
        try{
            CarEntity car = carService.updateCar(param);
            return commonResponseGenerator.successResponse(car, "Success Update Car Id: "+car.getId());
        }catch(Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage()+" For Id: "+param.getId());
        }
    }

    /* Delete */
    @GetMapping(value = "deleteCar")
    public CommonResponse<List<CarEntity>> deleteCar(@RequestParam int id){
        try{
            carService.deleteCar(id);
            List<CarEntity> carList = carService.getAllCar();
            return commonResponseGenerator.successResponse(carList, "Success Delete Car Id: "+id);
        }catch(Exception e){
            return commonResponseGenerator.failedResponse(e.getMessage());
        }
    }
}
