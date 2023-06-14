package de.neuefische.carspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Car {
    private String manufacturer;
    private int wheelsCount;
    private boolean hasMot;
    private final UUID id;

    public Car(String manufacturer, int wheelsCount, boolean hasMot) {
        this.manufacturer = manufacturer;
        this.wheelsCount = wheelsCount;
        this.hasMot = hasMot;
        this.id = UUID.randomUUID();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public boolean isHasMot() {
        return hasMot;
    }

    @Override
    public String toString() {
        StringBuilder carString = new StringBuilder();
        carString.append("\n---------------").append("\nID: " + id).append("\nManufacturer: " + manufacturer).append("\nWheels: " + wheelsCount).append("\nMOT: " + hasMot);
        return carString.toString();
        //return String.format("%s - Wheels: %d - MOT: %b - ID: %s%n", manufacturer, wheelsCount, hasMot, id);
    }

    public void setHasMot(boolean hasMot) {
        this.hasMot = hasMot;
    }

    public UUID getId() {
        return id;
    }
}
