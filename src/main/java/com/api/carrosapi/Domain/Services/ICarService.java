package com.api.carrosapi.Domain.Services;

import java.util.Optional;

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

    public Iterable<Car> getAll() {
        return _carRepository.findAll();
    }

    public Car getById(Long id) {
        return _carRepository.findById(id).orElse(null);
    }

    public boolean update(Long id, Car car) {
        return _carRepository.findById(id)
           .map(record -> {
               record.setName(car.getName());
               record.setColor(car.getColor());
               record.setPrice(car.getPrice());
               record.setQuantityInStock(car.getQuantityInStock());
               _carRepository.save(record);
               return true;
           }).orElse(false);
    }

    public void remove(Long id) {
        Car car = _carRepository.findById(id).get();
        _carRepository.delete(car);
    }
}
