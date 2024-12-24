package com.arturlogan.animal_service.controllers;

import com.arturlogan.animal_service.entities.Animal;
import com.arturlogan.animal_service.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequestMapping("/animais")
@RestController
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    private List<Animal> finAll(){
        return animalRepository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal){
        return animalRepository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted(){
        return animalRepository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted(){
        return animalRepository.findAdopted();
    }

    @GetMapping("/not-adopted-dog")
    private List<Animal> findNotAdoptedDog() {
        return animalRepository.findNotAdoptedDog();
    }

    @GetMapping("/adopted-dog")
    private List<Animal> findAdoptedDog() {
        return animalRepository.findAdoptedDog();
    }

    @GetMapping("/not-adopted-cat")
    private List<Animal> findNotAdoptedCat() {
        return animalRepository.findNotAdoptedCat();
    }

    @GetMapping("/adopted-cat")
    private List<Animal> findAdoptedCat() {
        return animalRepository.findAdoptedCat();
    }

    @GetMapping("/employee-gap")
    private List<Object[]> findEmployees() {
        Date startDate = new Date("2023-02-05");
        Date endDate = new Date("2023-07-05");
        return animalRepository.findFuncionario(startDate, endDate);
    }

    @GetMapping("/month")
    private List<Animal> FindMonthAnimals(
            @RequestParam(name = "startDate",required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
            @RequestParam(name = "endDate",required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate)
    {
        return animalRepository.findMonthAnimals(startDate, endDate);
    }
}
