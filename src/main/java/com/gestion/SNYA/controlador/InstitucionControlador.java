package com.gestion.SNYA.controlador;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.SNYA.modelo.Institucion;

import com.gestion.SNYA.servicio.InstitucionServicio;



@RestController
//http://locahost:8080/snya-app
@RequestMapping("snya-app")
@CrossOrigin(value = "http://localhost:4200")


public class InstitucionControlador {
	
	private static final Logger logger=
			LoggerFactory.getLogger(InstitucionControlador.class);
	
	@Autowired
	
	private InstitucionServicio institucionServicio;
	//http://localhost:8080/snya-app/instituciones

	@GetMapping("/instituciones")
	public List<Institucion>obtenerInstituciones(){
		List<Institucion> instituciones = this.institucionServicio.listarInstituciones();
		logger.info("insttituciones Obtenidas: ");
		instituciones.forEach((institucion->logger.info(institucion.toString())));
		return instituciones; 
	}
	
}
