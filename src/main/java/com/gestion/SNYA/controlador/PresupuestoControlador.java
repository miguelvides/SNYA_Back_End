package com.gestion.SNYA.controlador;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.SNYA.excepciones.ResourceNotFoundException;
import com.gestion.SNYA.modelo.Presupuesto;
//import com.gestion.SNYA.repositorio.InstitucionRepositorio;
import com.gestion.SNYA.repositorio.PresupuestoRepositorio;

@RestController
@RequestMapping("/api/v1/presupuesto")
@CrossOrigin(origins ="http://localhost:4200")
public class PresupuestoControlador {

	

    final
    PresupuestoRepositorio repositorio;

    public PresupuestoControlador(PresupuestoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        Map<String,Object> mensaje = new HashMap<>();
        List<Presupuesto> presupuestos = repositorio.findAll();
        if (presupuestos.isEmpty()){
            mensaje.put("succes",Boolean.FALSE);
            mensaje.put("Mensaje","No hay datos");
            return ResponseEntity.ok().body(mensaje);
        }
        mensaje.put("succes",Boolean.TRUE);
        mensaje.put("data",repositorio.findAll());
        return ResponseEntity.ok().body(mensaje);
    }
    
    @PostMapping
    public ResponseEntity<?> createActividad(@RequestBody Presupuesto presupuesto){
        Map<String,Object> mensaje = new HashMap<>();
        mensaje.put("succes",Boolean.TRUE);
		mensaje.put("data",repositorio.save(presupuesto));
        return ResponseEntity.ok().body(mensaje);
    }


	
    @PutMapping("/presupuesto/{id}")
	public ResponseEntity<Presupuesto> actualizarPresupuesto(
			@PathVariable (value = "id")Long PresupuestoId,
			@RequestBody Presupuesto presupuestoDetalle){
		Presupuesto presupuesto = repositorio.findById(PresupuestoId).orElseThrow(()-> new ResourceNotFoundException("Institucion no encontrada con el ID : "+PresupuestoId));
		presupuesto.setCantidad(presupuestoDetalle.getCantidad());
        presupuesto.setInstitucion(presupuestoDetalle.getInstitucion());
        presupuesto.setObservacion(presupuestoDetalle.getObservacion());

		Presupuesto presupuestoActualizada = repositorio.save(presupuesto);
		return ResponseEntity.ok(presupuestoActualizada);
	}
}
