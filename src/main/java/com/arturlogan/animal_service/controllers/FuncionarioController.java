package com.arturlogan.animal_service.controllers;

import com.arturlogan.animal_service.entities.Funcionario;
import com.arturlogan.animal_service.repositories.AnimalRepository;
import com.arturlogan.animal_service.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public Funcionario create(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
}

