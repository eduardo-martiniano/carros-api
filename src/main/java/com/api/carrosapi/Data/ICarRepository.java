package com.api.carrosapi.Data;

import com.api.carrosapi.Domain.Entities.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends CrudRepository<Car, Long> {
    
}
