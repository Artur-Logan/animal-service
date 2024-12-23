package com.arturlogan.animal_service.controllers;

import com.arturlogan.animal_service.entities.Animal;
import com.arturlogan.animal_service.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
