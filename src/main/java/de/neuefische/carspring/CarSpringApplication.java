package de.neuefische.carspring;

import de.neuefische.carspring.engine.Frame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarSpringApplication {

    public static void main(String[] args) {
        new Frame();
        SpringApplication.run(CarSpringApplication.class, args);
    }
}
