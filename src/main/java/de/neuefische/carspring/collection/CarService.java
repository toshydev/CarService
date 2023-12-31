package de.neuefische.carspring.collection;

import de.neuefische.carspring.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

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
