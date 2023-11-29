/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.SNYA.Servicio;

import com.gestion.SNYA.modelo.Donante;
import com.gestion.SNYA.repositorio.DonanteRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author pc
 */

@Service
public class DonanteServicio implements IDonanteServicio {
    
    @Autowired
    private DonanteRepositorio repositorio;
    
    @Override 
    public Donante agregarDonante(Donante donante)
    {
    
        return this.repositorio.save(donante);
    }
    
         

   @Override
   public List<Donante> listarDonante()
   {
      return  this.repositorio.findAll();
   }
    
}
