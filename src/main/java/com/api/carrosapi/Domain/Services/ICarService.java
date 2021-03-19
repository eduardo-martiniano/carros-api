package com.api.carrosapi.Domain.Services;

import com.api.carrosapi.Data.ICarRepository;
import com.api.carrosapi.Domain.Entities.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class ICarService {

    @Autowired
    private ICarRepository _carRepository;
    
    public Car save(Car car) {
        return _carRepository.save(car);
    }
}
