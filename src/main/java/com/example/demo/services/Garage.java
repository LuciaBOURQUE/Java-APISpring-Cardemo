package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Garage {
    @Autowired
    private CarRepository carRepository;

    // CREATED
    public void add(Car c) {
        carRepository.save(c);
    }

    // READ n1
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    // READ n2 (search)
    public Optional<Car> findById(Integer id) {
        return carRepository.findById(id);
    }

    // UPDATE
    public void update(Car c) {
        carRepository.save(c);
    }

    // DELETE
    public void delete(Integer id) {
        carRepository.deleteById(id);
    }
}
