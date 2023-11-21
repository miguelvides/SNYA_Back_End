package com.gestion.SNYA.controlador;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.SNYA.modelo.Institucion;

import com.gestion.SNYA.servicio.InstitucionServicio;



@RestController
//http://locahost:8080/snya-app
@RequestMapping("snya-app")
@CrossOrigin(value = "http://localhost:4200")
//documentacion en http://localhost:8080/swagger-ui.html

public class InstitucionControlador {
	
	private static final Logger logger= LoggerFactory.getLogger(InstitucionControlador.class);
	
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

	@PutMapping("/institucion/{id}")
	public ResponseEntity<?> actualizarInstitucion(
			@PathVariable(value = "id") Integer institucionId,
			@RequestBody Institucion institucionJson){
		Institucion institucion=institucionServicio.buscarInstitucionporId(institucionId);
		if(institucion==null){
			return new ResponseEntity<>("institucion no encontrada", HttpStatus.NOT_FOUND);
		}
		institucion.setNombre(institucionJson.getNombre());
		institucion.setPresupuesto_institucion(institucionJson.getPresupuesto_institucion());
		institucion.setTipo_institucion(institucionJson.getTipo_institucion());
		institucion.setFecha_ingreso(institucion.getFecha_ingreso());//format YYYY-MM-DD
		institucionServicio.guardarInstitucion(institucion);
		return ResponseEntity.ok(institucion);
	}
}