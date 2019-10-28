package com.springbootdev.examples.controller;

import com.springbootdev.examples.entity.Car;
import com.springbootdev.examples.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarRepository carRepository;


    @PostMapping("/cars")
    public Car create(@RequestBody Car car)
    {
        return carRepository.save(car);
    }


    @GetMapping("/cars")
    public List<Car> findAll()
    {
        return carRepository.findAll();
    }


    @PutMapping("/cars/{cars_id}")
    public Car update(@PathVariable("cars_id") Long carId, @RequestBody Car carObject)
    {
        Car car = carRepository.findOne(carId);
        car.setModel(carObject.getModel());
        car.setYear(carObject.getYear());
        car.setColor(carObject.getColor());
        return carRepository.save(car);
    }



    @DeleteMapping("/cars/{car_id}")
    public List<Car> delete(@PathVariable("car_id") Long userId)
    {
        carRepository.delete(userId);
        return carRepository.findAll();
    }



    @GetMapping("/cars/{car_id}")
    @ResponseBody
    public Car findByUserId(@PathVariable("user_id") Long carId)
    {
        return carRepository.findOne(carId);
    }
}
