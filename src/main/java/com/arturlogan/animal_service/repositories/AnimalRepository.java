package com.arturlogan.animal_service.repositories;

import com.arturlogan.animal_service.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a WHERE a.adocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();


    @Query("SELECT a FROM Animal a WHERE a.adocao IS NOT NULL")
    List<Animal> findAdopted();

    @Query("SELECT a FROM Animal a WHERE a.adocao IS NULL AND a.especie = 'cão'")
    List<Animal> findNotAdoptedDog();

    @Query("SELECT a FROM Animal a WHERE a.adocao IS NOT NULL AND a.especie = 'cão'")
    List<Animal> findAdoptedDog();

    @Query("SELECT a FROM Animal a WHERE a.adocao IS NULL AND a.especie = 'gato'")
    List<Animal> findNotAdoptedCat();

    @Query("SELECT a FROM Animal a WHERE a.adocao IS NOT NULL AND a.especie = 'gato'")
    List<Animal> findAdoptedCat();

    @Query("SELECT a.funcionario.nome, COUNT(a) as quantidadeAnimais " +
            "FROM Animal a " +
            "WHERE a.adocao >= :startDate AND a.adocao <= :endDate " +
            "GROUP BY a.funcionario.nome")
    List<Object[]> findFuncionario(@Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate);


    @Query("SELECT a FROM Animal a WHERE a.dataEntrada >= :startDate AND a.dataEntrada <= :endDate")
    List<Animal> findMonthAnimals(@Param("startDate") Date startDate,
                                  @Param("endDate") Date endDate);

}


