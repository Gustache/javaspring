package com.gustache.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustache.cursomc.domain.Categoria;
import com.gustache.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired //instancia sozinho pelo spring
	private CategoriaRepository repo;
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
