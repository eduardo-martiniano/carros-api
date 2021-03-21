package viewmodels;

import com.api.carrosapi.Domain.Entities.Car;
import lombok.Data;

@Data
public class CarViewModel {
    private Long id;
    private String name;
    private String color;
    private Double price;
    private Integer quantityInStock;
    private BrandViewModel brand;

    public CarViewModel(Car car) {
        this.id = car.getId();
        this.name = car.getName();
        this.color = car.getColor();
        this.price = car.getPrice();
        this.quantityInStock = car.getQuantityInStock();
        this.brand = new BrandViewModel(car.getBrand());
    }   
}
