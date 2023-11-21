package com.gestion.SNYA.repositorio;

import com.gestion.SNYA.modelo.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepositorio extends JpaRepository<Actividad,Long> {
}
