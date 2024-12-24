package com.arturlogan.animal_service.repositories;

import com.arturlogan.animal_service.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByNome(String nome);
}
