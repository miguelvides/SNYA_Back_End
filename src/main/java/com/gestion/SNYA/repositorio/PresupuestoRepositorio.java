package com.gestion.SNYA.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.SNYA.modelo.Presupuesto;

@Repository
public interface PresupuestoRepositorio extends JpaRepository<Presupuesto, Integer>{
    
}
