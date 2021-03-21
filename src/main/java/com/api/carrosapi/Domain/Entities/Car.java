package com.api.carrosapi.Domain.Entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String color;
    private Double price;
    private Integer quantityInStock;
    
    @ManyToOne
    @JoinColumn(name = "brandId")
    @JsonBackReference
    private Brand brand;
}
