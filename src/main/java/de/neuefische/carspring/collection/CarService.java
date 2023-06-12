package de.neuefische.carspring.collection;

import de.neuefische.carspring.model.Car;

import java.util.List;
import java.util.UUID;

public class CarService {
    private CarRepository carRepository;

    public CarService() {
        this.carRepository = new CarRepository();
    }

    public void addCar(Car car) {
        this.carRepository.addCar(car);
    }

    public List<Car> getCars() {
        return this.carRepository.getCars();
    }

    public void editCar(UUID id, Car car) {
        this.carRepository.editCar(id, car);
    }

    public void deleteCar(UUID id) {
        this.carRepository.deleteCar(id);
    }
}
