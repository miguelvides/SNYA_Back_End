package com.gestion.SNYA.repositorio;

import com.gestion.SNYA.modelo.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonanteRepositorio extends JpaRepository<Donante,Long>{
}
