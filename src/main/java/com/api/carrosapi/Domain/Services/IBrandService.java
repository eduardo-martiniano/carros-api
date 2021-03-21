package com.api.carrosapi.Domain.Services;


import com.api.carrosapi.Data.IBrandRepository;
import com.api.carrosapi.Domain.Entities.Brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class IBrandService {
    
    @Autowired
    private IBrandRepository _brandRepository;
    
    public Brand save(Brand brand) {
        return _brandRepository.save(brand);
    }

    public Iterable<Brand> getAll() {
        return _brandRepository.findAll();
    }

    public Brand getById(Long id) {
        return _brandRepository.findById(id).orElse(null);
    }

    public void remove(Long id) {
        Brand brand = _brandRepository.findById(id).get();
        _brandRepository.delete(brand);
    }
}
