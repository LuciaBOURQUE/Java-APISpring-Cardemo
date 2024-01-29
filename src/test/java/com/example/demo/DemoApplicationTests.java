package com.example.demo;

import com.example.demo.models.Car;
import com.example.demo.services.Garage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	Garage garageDatabase;

	@Test
	void testAdd() {
		Car car1 = new Car("Toyota", "Camry", 2022, "Blue", LocalDate.of(2022, 1, 15), "ABC123");
		Car car2 = new Car("Honda", "Civic", 2020, "Red", LocalDate.of(2020, 5, 10), "XYZ789");
		Car car3 = new Car("Ford", "Mustang", 2021, "Yellow", LocalDate.of(2021, 8, 22), "DEF456");
		Car car4 = new Car("Chevrolet", "Silverado", 2019, "Black", LocalDate.of(2019, 3, 5), "GHI789");
		Car car5 = new Car("Volkswagen", "Golf", 2023, "White", LocalDate.of(2023, 6, 30), "JKL012");
		garageDatabase.add(car1);
		garageDatabase.add(car2);
		garageDatabase.add(car3);
		garageDatabase.add(car4);
		garageDatabase.add(car5);
	}

	@Test
	void testDelete() {
		garageDatabase.delete(2);
	}

	@Test
	void testUpdate() {
		Optional<Car> op = garageDatabase.findById(4);
		if(op.isPresent()){
			Car carUpdate = op.get();
			carUpdate.setColor("Red");
			garageDatabase.update(carUpdate);
		}
	}
}
