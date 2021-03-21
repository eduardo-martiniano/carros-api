package viewmodels;

import com.api.carrosapi.Domain.Entities.Brand;
import lombok.Data;

@Data
public class BrandViewModel {
    private Long id;
    private String Name;

    public BrandViewModel(Brand brand) {
        this.id = brand.getId();
        this.Name = brand.getName();
    }
}
