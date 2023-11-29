/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.SNYA.Servicio;

import com.gestion.SNYA.modelo.Institucion;
import com.gestion.SNYA.repositorio.InstitucionRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class InstitucionServicio implements IInstitucionServicio {
     @Autowired
    private InstitucionRepositorio repositorio;
    
    @Override 
    public Institucion guardarInstitucion(Institucion institucion)
    {
    
        return this.repositorio.save(institucion);
    }
    
         

   @Override 
   public List<Institucion> listarInstitucion()
   {
      return  this.repositorio.findAll();
   }
}
