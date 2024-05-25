package com.example.Demo_spring_boot_project.Car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceSimple implements CarInterface<Integer, Car> {
      List<Car> carList = new ArrayList<>();
      Integer carId=1;
    @Override
    public Car create(Car car){
        Car car1 =Car.builder()
                .id(carId)
                .color(car.getColor())
                .model(car.getColor())
                .build();
        carList.add(car1);
        carId++;
        return car1;
    }

    @Override
    public Car update(Integer id, Car car) {
        for (Car car1 : carList) {
            if (car1.getId().equals(id)) {
                car1.setColor(car.getColor());
                car1.setModel(car.getModel());
                car1.setId(id);
                return car;
            }

        }
        return new Car();
    }

    @Override
    public Car delete(Integer id) {
        for (Car car1 : carList) {
            if (car1.getId().equals(id)) {
                carList.remove(car1);
                return car1;

            }
        }
        return new Car();
    }

    @Override
    public Car get(Integer id) {
        for (Car car1 : carList) {
            if (car1.getId().equals(id)) {
                return car1;
            }
        }
        return new Car();
    }

    @Override
    public List<Car> getAll() {
        return carList;
    }
}