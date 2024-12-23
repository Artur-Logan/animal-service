package com.arturlogan.animal_service.repositories;

import com.arturlogan.animal_service.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a WHERE a.adocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();


    @Query("SELECT a FROM Animal a WHERE a.adocao IS NOT NULL")
    List<Animal> findAdopted();
}
