package web.Service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.List;
@Component
public class CarServiceImp implements CarService {
    @Override
    public List<Car> showCarsByCount(List<Car> carList, int count) {
        return carList.stream().limit(count).toList();
    }
}
