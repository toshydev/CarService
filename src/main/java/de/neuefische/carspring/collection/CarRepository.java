package de.neuefische.carspring.collection;

import de.neuefische.carspring.model.Car;

import java.util.*;

public class CarRepository {
    private Map<UUID, Car> cars;

    public CarRepository() {
        this.cars = new HashMap<>();
        ArrayList<Car> carList = new ArrayList<>(List.of(
                new Car("Toyota", 4, true),
                new Car("Honda", 4, true),
                new Car("Ford", 4, false),
                new Car("BMW", 4, true),
                new Car("Mercedes-Benz", 4, true),
                new Car("Audi", 4, true),
                new Car("Volkswagen", 4, true),
                new Car("Chevrolet", 4, false),
                new Car("Hyundai", 4, true),
                new Car("Kia", 4, true),
                new Car("Nissan", 4, false),
                new Car("Subaru", 4, true),
                new Car("Mazda", 4, true),
                new Car("Volvo", 4, true),
                new Car("Jeep", 4, false),
                new Car("Lexus", 4, true),
                new Car("Porsche", 4, true),
                new Car("Tesla", 4, true),
                new Car("Ferrari", 4, true),
                new Car("Lamborghini", 4, true)
                )
        );
        for (Car car : carList) {
            cars.put(car.getId(), car);
        }
    }

    public void addCar(Car car) {
        cars.put(car.getId(), car);
    }

    public void deleteCar(UUID id) {
        cars.remove(id);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars.values());
    }

    public void editCar(UUID id, Car car) {
        if (cars.containsKey(id)) {
            cars.put(id, car);
        }
    }

    @Override
    public String toString() {
        return "CarRepository{" +
                "cars=" + cars +
                '}';
    }
}
