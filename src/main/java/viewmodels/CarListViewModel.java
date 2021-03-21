package viewmodels;

import java.util.List;
import lombok.Data;

@Data
public class CarListViewModel {
    private Integer count;
    private List<CarViewModel> cars;

    public CarListViewModel(Integer count, List<CarViewModel> cars) {
        this.count = count;
        this.cars = cars;
    }
}
