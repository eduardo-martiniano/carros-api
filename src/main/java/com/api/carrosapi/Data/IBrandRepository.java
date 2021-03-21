package com.api.carrosapi.Data;

import com.api.carrosapi.Domain.Entities.Brand;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandRepository extends CrudRepository<Brand, Long> {
    
}
