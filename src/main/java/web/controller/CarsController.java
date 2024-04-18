package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarService;
import web.Service.CarServiceImp;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String showCars(@RequestParam("count") int count, Model model) {

        List<Car> carsList = carService.getAllCars();

        if (count < 5 && count >= 0) {
            carsList = carService.showCarsByCount(count);
        }
        model.addAttribute("list", carsList);
        return "cars";
    }

}
