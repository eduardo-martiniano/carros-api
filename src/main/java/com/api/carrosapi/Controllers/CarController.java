package com.api.carrosapi.Controllers;

import com.api.carrosapi.Domain.Entities.Car;
import com.api.carrosapi.Domain.Services.ICarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
public class CarController {
    
    @Autowired
    private ICarService _carService;

    @PostMapping()
    public Car addCar(@RequestBody Car car) {
        return _carService.save(car);
    }
}
