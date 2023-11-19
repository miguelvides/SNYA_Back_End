package com.gestion.SNYA.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gestion.SNYA.Servicio.InstitucionServicio;
import com.gestion.SNYA.modelo.Institucion;
import com.gestion.SNYA.repositorio.InstitucionRepositorio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
//http://localhost:8080
@RequestMapping("/api/v1/")
@CrossOrigin(origins ="http://localhost:4200")

public class InstitucionControlador {
	@Autowired
	private InstitucionRepositorio repositorio;
         @Autowired 
    private InstitucionServicio servicio;
        //http://localhost:8080/api/v1/institucion
	@GetMapping("/institucion")
	public List<Institucion> listarTodasInstituciones() {
		return repositorio.findAll();
	}
        
        @PostMapping("/institucion")   
    public Institucion guardarInstitucion(@RequestBody Institucion institucion){
		
        return this.servicio.guardarInstitucion(institucion);
	}  
}
