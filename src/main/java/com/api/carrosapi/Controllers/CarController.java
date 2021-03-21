package com.api.carrosapi.Controllers;

import java.util.Optional;

import com.api.carrosapi.Domain.Entities.Car;
import com.api.carrosapi.Domain.Services.ICarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
public class CarController {
    
    @Autowired
    private ICarService _carService;

    @PostMapping()
    public ResponseEntity<?> addCar(@RequestBody Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(_carService.save(car));
    }
    
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(_carService.getAll());
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<Car> car = _carService.getById(id);
        if (car.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse carro");
        }
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Car car) {
        Optional<Car> _car = _carService.getById(id);
        if (_car.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse carro");
        }
        
        Boolean result = _carService.update(id, car);
        
        if (!result) {
            return ResponseEntity.status(500).body("Erro ao editar carro :(");
        }
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Carro editado com sucesso!");
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        Optional<Car> _car = _carService.getById(id);
        
        if (_car.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse carro");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Carro removido com sucesso!");
    }
}
