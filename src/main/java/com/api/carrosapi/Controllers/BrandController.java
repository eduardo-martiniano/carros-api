package com.api.carrosapi.Controllers;

import com.api.carrosapi.Domain.Entities.Brand;
import com.api.carrosapi.Domain.Services.IBrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brands")
public class BrandController {
    
    @Autowired
    private IBrandService _brandService;

    @PostMapping()
    public ResponseEntity<?> addBrand(@RequestBody Brand brand) {
        return ResponseEntity.status(HttpStatus.CREATED).body(_brandService.save(brand));
    }

    @GetMapping()
    public ResponseEntity<?> getBrands() {
        return ResponseEntity.status(HttpStatus.OK).body(_brandService.getAll());
    }
}
