package com.gestion.SNYA.controlador;

import java.util.List;

import com.gestion.SNYA.excepciones.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.SNYA.modelo.Institucion;
import com.gestion.SNYA.repositorio.InstitucionRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins ="http://localhost:4200")
//documentacion en http://localhost:8080/swagger-ui.html
public class InstitucionControlador {
	@Autowired
	private InstitucionRepositorio repositorio;

	@GetMapping("/institucion")
	public List<Institucion> listarTodasInstituciones() {
		return repositorio.findAll();
	}
	@PutMapping("/institucion/{id}")
	public ResponseEntity<Institucion> actualizarInstitucion(
			@PathVariable (value = "id")Long institucionId,
			@RequestBody Institucion institucionDetalle){
		Institucion institucion = repositorio.findById(institucionId).orElseThrow(()-> new ResourceNotFoundException("Institucion no encontrada con el ID : "+institucionId));
		institucion.setNombre(institucionDetalle.getNombre());
		institucion.setIdentificador(institucionDetalle.getIdentificador());
		institucion.setFecha(institucionDetalle.getFecha());
		institucion.setTipoInstitucion(institucionDetalle.getTipoInstitucion());

		Institucion institucionActualizada = repositorio.save(institucion);
		return ResponseEntity.ok(institucionActualizada);
	}
}
