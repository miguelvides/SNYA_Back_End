/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gestion.SNYA.repositorio;
import com.gestion.SNYA.modelo.Donante;
import jakarta.persistence.Column;
import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author pc
 */
@Repository

public interface DonanteRepositorio extends JpaRepository<Donante, Long> {
    
  
    
}
