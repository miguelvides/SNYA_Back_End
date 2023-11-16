package com.gestion.SNYA.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.SNYA.modelo.Institucion;

@Repository

public interface ActividadRepositorio extends JpaRepository<Institucion, Long> {
	

}
