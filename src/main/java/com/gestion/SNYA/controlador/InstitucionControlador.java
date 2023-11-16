package com.gestion.SNYA.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.SNYA.excepciones.ResourceNotFoundException;
import com.gestion.SNYA.modelo.Institucion;
import com.gestion.SNYA.repositorio.InstitucionRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins ="http://localhost:4200")

public class InstitucionControlador {
	@Autowired
	private InstitucionRepositorio repositorio;

	@GetMapping("/institucion")
	public List<Institucion> listarTodasInstituciones() {
		return repositorio.findAll();
	}

	

}


