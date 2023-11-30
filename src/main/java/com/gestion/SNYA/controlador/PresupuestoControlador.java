package com.gestion.SNYA.controlador;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.SNYA.modelo.Presupuesto;
import com.gestion.SNYA.servicio.PresupuestoServicio;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
//http://locahost:8080/snya-app
@RequestMapping("snya-app")
@CrossOrigin(value = "http://localhost:4200")
public class PresupuestoControlador {
	private static final Logger logger = LoggerFactory.getLogger(PresupuestoControlador.class);
	@Autowired
	
	private PresupuestoServicio presupuestoServicio;
	//http://locahost:8080/snya-app
	@RequestMapping("presupuesto")
	public List<Presupuesto>obtenerPresupuesto(){
		List<Presupuesto> presupuestos=this.presupuestoServicio.listarPresupuesto();
		logger.info("Presupuestos Obtenidos: ");
		presupuestos.forEach(presupuesto-> logger.info(presupuesto.toString()));
		return presupuestos;
	}
	@DeleteMapping("/presupuesto/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarPresupuesto(@PathVariable int id) {
		Presupuesto presupuesto=presupuestoServicio.buscarPresupuestoPorId(id);
		this.presupuestoServicio.eliminarPresupuesto(presupuesto.getIdPresupuesto());
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("Eliminado", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
	
	
}
