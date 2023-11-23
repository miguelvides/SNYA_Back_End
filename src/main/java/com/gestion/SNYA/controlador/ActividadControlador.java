package com.gestion.SNYA.controlador;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.gestion.SNYA.modelo.Actividad;
import com.gestion.SNYA.repositorio.ActividadRepositorio;
import com.gestion.SNYA.servicio.ActividadServicio;

@RestController
//http://locahost:8080/snya-ap
@RequestMapping("snya-app")
@CrossOrigin(value = "http://localhost:4200")
public class ActividadControlador {
		
	private static final Logger logger=
			LoggerFactory.getLogger(ActividadControlador.class);
	@Autowired

    private ActividadServicio actividadServicio;

		@GetMapping("/getActividades")
	public List<Actividad>obtenerActividades(){

		List<Actividad> actividad = this.actividadServicio.listarActividadeList();
		logger.info("Actividades Obtenidas: ");
		actividad.forEach((actividi->logger.info(actividi.toString())));
		return actividad; 

	}

	//metodo para buscar por id
	@GetMapping("/actividades/{id}")
	public ResponseEntity <Actividad> buscarActividadID(@PathVariable int id){
		Actividad actividadPorID=this.actividadServicio.buscarActividadId(id);
		if(actividadPorID!=null){
			return ResponseEntity.ok(actividadPorID);
		}else{
			throw new ResourceNotFoundException("Actividad no encontrada "+id);
		}
	}

	//metodo para actualizar

	     @PutMapping("/actividades/{id}")
		 public ResponseEntity<Actividad> actualizarActividad
		 (@PathVariable int id,@RequestBody Actividad actividadC){
			Actividad activi = this.actividadServicio.buscarActividadId(id);
			activi.setNombre(actividadC.getNombre());
			activi.setDonanteActividad(actividadC.getDonanteActividad());
			activi.setPresupuestoActividad(actividadC.getPresupuestoActividad());
			activi.setFechaActividd(actividadC.getFechaActividd());
			this.actividadServicio.guardarActividad(activi);
			return ResponseEntity.ok(activi);
		 }
}
