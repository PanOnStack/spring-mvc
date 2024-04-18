package web.Service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarServiceImp implements CarService {

    private List<Car> carsList = new ArrayList<>();

    {
        carsList.add(new Car(1, "BMW", "black"));
        carsList.add(new Car(2, "Mercedes", "Silver"));
        carsList.add(new Car(3, "Ford", "blue"));
        carsList.add(new Car(4, "Tayota", "red"));
        carsList.add(new Car(5, "Lada", "white"));
    }
    @Override
    public List<Car> showCarsByCount(int count) {
        return carsList.stream().limit(count).toList();
    }
    @Override
    public  List<Car> getAllCars() {
        return carsList;
    }
}
