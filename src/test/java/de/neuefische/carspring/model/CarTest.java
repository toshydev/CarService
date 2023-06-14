package de.neuefische.carspring.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    public void testGetManufacturer() {
        Car car = new Car("Toyota", 4, true);
        assertThat(car.getManufacturer()).isEqualTo("Toyota");
    }

    @Test
    public void testSetManufacturer() {
        Car car = new Car("Toyota", 4, true);
        car.setManufacturer("Honda");
        assertThat(car.getManufacturer()).isEqualTo("Honda");
    }

    @Test
    public void testGetWheelsCount() {
        Car car = new Car("Toyota", 4, true);
        assertThat(car.getWheelsCount()).isEqualTo(4);
    }

    @Test
    public void testSetWheelsCount() {
        Car car = new Car("Toyota", 4, true);
        car.setWheelsCount(3);
        assertThat(car.getWheelsCount()).isEqualTo(3);
    }

    @Test
    public void testIsHasMot() {
        Car car = new Car("Toyota", 4, true);
        assertThat(car.isHasMot()).isTrue();
    }

    @Test
    public void testSetHasMot() {
        Car car = new Car("Toyota", 4, true);
        car.setHasMot(false);
        assertThat(car.isHasMot()).isFalse();
    }

    @Test
    public void testGetId() {
        Car car = new Car("Toyota", 4, true);
        assertThat(car.getId()).isNotNull();
    }

    @Test
    public void testToString() {
        Car car = new Car("Toyota", 4, true);
        String expectedString = "\n---------------\nID: " + car.getId() + "\nManufacturer: Toyota\nWheels: 4\nMOT: true";
        assertThat(car.toString()).isEqualTo(expectedString);
    }
}
