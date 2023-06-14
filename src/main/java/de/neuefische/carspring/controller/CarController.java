package de.neuefische.carspring.controller;

import de.neuefische.carspring.collection.CarService;
import de.neuefische.carspring.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("car")
    public List<Car> list() {
        return this.carService.getCars();
    }

    @PostMapping("car/add")
    public void add(@RequestBody Car car) {
            this.carService.addCar(car);
    }

    @DeleteMapping("car/{id}")
    public void delete(@PathVariable String id) {
        this.carService.deleteCar(UUID.fromString(id));
    }

    @PutMapping("car/{id}")
    public void edit(@PathVariable String id, @RequestBody Car car) {
        this.carService.editCar(UUID.fromString(id), car);
    }

}
