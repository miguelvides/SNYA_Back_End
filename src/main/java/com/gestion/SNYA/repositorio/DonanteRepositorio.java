package com.gestion.SNYA.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.SNYA.modelo.Donante;

@Repository

public interface DonanteRepositorio extends JpaRepository<Donante, Integer> {
	
	

}
