package com.clima.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clima.application.entities.LeituraClimatica;

@Repository
public interface LeituraClimaticaRepository extends JpaRepository<LeituraClimatica, Long> {

}
