package com.api.carrosapi.Controllers;

import java.util.Optional;

import com.api.carrosapi.Domain.Entities.Brand;
import com.api.carrosapi.Domain.Entities.Car;
import com.api.carrosapi.Domain.Services.IBrandService;
import com.api.carrosapi.Domain.Services.ICarService;
import java.util.ArrayList;
import java.util.List;

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
import viewmodels.CarListViewModel;
import viewmodels.CarViewModel;

@RestController
@RequestMapping("cars")
public class CarController {
    
    @Autowired
    private ICarService _carService;

    @Autowired
    private IBrandService _brandService;

    @PostMapping()
    public ResponseEntity<?> addCar(@RequestBody Car car) {

        Brand brand = _brandService.getById(car.getBrand().getId());
        if (brand == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar essa marca!");
        }
        _carService.save(car);
        car.setBrand(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CarViewModel(car));
    }
    
    @GetMapping()
    public ResponseEntity<?> getAll() {
        Iterable<Car> cars = _carService.getAll();
        List<CarViewModel> carsViewModel = new ArrayList<>();
        for (Car car : cars) {
            carsViewModel.add(new CarViewModel(car));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new CarListViewModel(carsViewModel.size(), carsViewModel));
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Car car = _carService.getById(id);
        if (car == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse carro");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new CarViewModel(car));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Car car) {
        Car _car = _carService.getById(id);
        if (_car == null) {
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
        Car car = _carService.getById(id);
        if (car == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse carro");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Carro removido com sucesso!");
    }
}
