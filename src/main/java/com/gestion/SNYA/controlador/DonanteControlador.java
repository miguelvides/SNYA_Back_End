/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.SNYA.controlador;

import com.gestion.SNYA.Servicio.DonanteServicio;
import com.gestion.SNYA.excepciones.ResourceNotFoundException;
import com.gestion.SNYA.modelo.Donante;
import com.gestion.SNYA.repositorio.DonanteRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
//http://localhost:8080
@RequestMapping("/api/v1/")
@CrossOrigin(origins ="http://localhost:4200")

public class DonanteControlador {
    @Autowired
	private DonanteRepositorio repositorio;
         @Autowired 
         private DonanteServicio servicio; 
        //http://localhost:8080/api/v1/ListarDonante
        
            
          @GetMapping("/ListarDonante")
	public List<Donante> listarTodosLosDonantes() {
		return repositorio.findAll();
	}
        
        @PostMapping("/ListarDonante")   
    public Donante agregarDonante(@RequestBody Donante donante){
		
        return this.servicio.agregarDonante(donante);
        
	}  
}
