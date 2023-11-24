package com.gestion.SNYA.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestion.SNYA.modelo.Actividad;

@Repository

public interface ActividadRepositorio extends JpaRepository<Actividad, Integer> {
    
}
