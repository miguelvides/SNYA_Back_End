package com.gestion.SNYA.repositorio;

import com.gestion.SNYA.modelo.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonacionRepositorio extends JpaRepository<Donacion,Long> {
}
