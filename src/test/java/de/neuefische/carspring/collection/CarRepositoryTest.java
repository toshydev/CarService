package de.neuefische.carspring.collection;

import de.neuefische.carspring.model.Car;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarRepositoryTest {

    @Test
    public void testAddCar() {
        CarRepository carRepository = new CarRepository();
        Car car = new Car("Tesla", 4, true);

        carRepository.addCar(car);

        assertThat(carRepository.getCars()).contains(car);
    }

    @Test
    public void testDeleteCar() {
        CarRepository carRepository = new CarRepository();
        Car car = new Car("Tesla", 4, true);
        carRepository.addCar(car);

        carRepository.deleteCar(car.getId());

        assertThat(carRepository.getCars()).doesNotContain(car);
    }

    @Test
    public void testGetCars() {
        CarRepository carRepository = new CarRepository();
        assertThat(carRepository.getCars()).hasSize(20);
    }

    @Test
    public void testEditCar() {
        CarRepository carRepository = new CarRepository();
        Car car = new Car("Tesla", 4, true);
        carRepository.addCar(car);

        Car updatedCar = new Car("Tesla", 4, false);
        carRepository.editCar(car.getId(), updatedCar);

        assertThat(carRepository.getCars()).contains(updatedCar);
    }
}
