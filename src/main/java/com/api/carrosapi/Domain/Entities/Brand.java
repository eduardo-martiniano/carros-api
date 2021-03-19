package com.api.carrosapi.Domain.Entities;

import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "brand")
    private List<Car> cars;
}
