package com.gustache.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustache.cursomc.domain.Estados;

@Repository
public interface EstadoRepository extends JpaRepository<Estados, Integer> {

}
