package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.services.Garage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class Admin {
    @Autowired
    private Garage garage;

    // POST (Created)
    @PostMapping("cars")
    public ResponseEntity<?> addCar(@RequestBody Car c) {
        if (c.getColor().isBlank() ||
                c.getLabel().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("Vos champs ne sont pas totalement remplis");
        }
        garage.add(c);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(c);
    }

    // GET (Read - n1)
    @GetMapping("cars")
    public List<Car> getAll(){
       return garage.getAll();
    }

    // GET (Read - n2)
    /*
    @GetMapping("cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Integer id){
        Optional<Car> opt = garage.findById(id);
        if(opt.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(opt.get());
        }
    }*/

    @GetMapping("cars/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable("id") Integer id){
        Optional<Car> opt = garage.findById(id);
        if(opt.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            CarDTO dto = CarMapper.convertEntityToDto(opt.get());
            return ResponseEntity.ok(dto);
        }
    }


    // PUT (Update)
    @PutMapping("cars/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id,
    @RequestBody Car c){
        if (!c.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        } else {
            garage.update(c);
            return ResponseEntity.ok().build();
        }
    }

    // DELETE (Delete)
    @DeleteMapping("cars/{id}")
    public void delete(@PathVariable("id") Integer id){
        garage.delete(id);
    }
}
