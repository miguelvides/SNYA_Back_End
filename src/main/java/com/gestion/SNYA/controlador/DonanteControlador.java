package com.gestion.SNYA.controlador;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.SNYA.modelo.Donante;
import com.gestion.SNYA.servicio.DonanteServicio;

@RestController
//http://locahost:8080/snya-app
@RequestMapping("snya-app")
@CrossOrigin(value = "http://localhost:4200")

public class DonanteControlador {

	private static final Logger logger = LoggerFactory.getLogger(DonanteControlador.class);

	@Autowired

	private DonanteServicio donanteServicio;

	// http://localhost:8080/snya-app/donantes

	
	@DeleteMapping("/donantes/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarDonante(@PathVariable int id) {
		Donante donante = donanteServicio.buscarDonanteporId(id);
		this.donanteServicio.elimiarDonanteporId(donante.getIdDonante());
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("Eliminado", Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
