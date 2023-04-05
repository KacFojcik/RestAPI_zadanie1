package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarApi {

    private List<Car> cars;

    public CarApi() {
        cars = new ArrayList<>();
        cars.add(new Car(1L, "BMW", "M2", LocalDate.of(2018,1,16)));
        cars.add(new Car(2L, "Mercedes-Benz", "AMG", LocalDate.of(1988,3,3)));
    }

    @GetMapping("/all")
    public List<Car> getAll (){
        return cars;
    }
    @GetMapping
    public Car getById(@RequestParam long id) {
        Optional<Car> first = cars
                .stream()
                .filter(element->element.getId()==id)
                .findFirst();
        return first.get();
    }

    @PostMapping
    public boolean addVideo(@RequestBody Car car) {
        return cars.add(car);
    }

    @PutMapping
    public boolean updateVideo(@RequestBody Car car) {
        return cars.add(car);
    }

    @DeleteMapping
    public boolean deleteVideo(@RequestParam long id) {
       return cars.removeIf(element->element.getId()==id);
    }
}
