package com.gestion.SNYA.controlador;
import java.util.List;

import com.gestion.SNYA.excepciones.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.SNYA.modelo.Actividad;
import com.gestion.SNYA.repositorio.ActividadRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins ="http://localhost:4200")
public class ActividadControlador {
    	@Autowired
	private ActividadRepositorio repositorio;
    	@GetMapping("/actividad")
	public List<Actividad> listarTodasLActividads() {
		return repositorio.findAll();
	}
    @PutMapping("/actividad/{id}")
	public ResponseEntity<Actividad> actualizarActividad(
			@PathVariable (value = "id")Long actividadID,
			@RequestBody Actividad actividadDetalle){
		Actividad actividad = repositorio.findById(actividadID).orElseThrow(()-> new ResourceNotFoundException("Actividad no encontrada con el ID : "+actividadID));
		actividad.setNombre_actividad(actividadDetalle.getNombre_actividad());
        actividad.setDonante_actividad(actividadDetalle.getDonante_actividad());
        actividad.setPresupuesto_actividad(actividadDetalle.getPresupuesto_actividad());
        actividad.setFecha_actividad(actividadDetalle.getFecha_actividad());

		Actividad actividadActualizada = repositorio.save(actividad);
		return ResponseEntity.ok(actividadActualizada);
	}
}
