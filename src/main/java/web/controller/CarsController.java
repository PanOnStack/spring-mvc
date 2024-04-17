package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarServiceImp;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private CarServiceImp carServiceImp;

    @Autowired
    public CarsController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping()
    public String showCars(@RequestParam("count") int count, Model model) {

        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car(1, "BMW", "black"));
        carsList.add(new Car(2, "Mercedes", "Silver"));
        carsList.add(new Car(3, "Ford", "blue"));
        carsList.add(new Car(4, "Tayota", "red"));
        carsList.add(new Car(5, "Lada", "white"));

        if (count < 5 && count >= 0) {
            carsList = carServiceImp.showCarsByCount(carsList, count);
        }
        model.addAttribute("list", carsList);
        return "cars";
    }

}
