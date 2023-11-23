package com.gestion.SNYA.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gestion.SNYA.servicio.ActividadServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.SNYA.modelo.Actividad;
import com.gestion.SNYA.repositorio.ActividadRepositorio;

@RestController
@RequestMapping("/snya-app/actividades")

public class ActividadControlador {
    final
    ActividadServicio servicio;

    public ActividadControlador( ActividadServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        Map<String,Object> mensaje = new HashMap<>();
        List<Actividad> actividades = servicio.listar();
        if (actividades.isEmpty()){
            mensaje.put("succes",Boolean.FALSE);
            mensaje.put("Mensaje","No hay datos");
            return ResponseEntity.ok().body(mensaje);
        }
        mensaje.put("succes",Boolean.TRUE);
        mensaje.put("data",actividades);
        return ResponseEntity.ok().body(mensaje);
    }
    @PostMapping
    public ResponseEntity<?> createActividad(@RequestBody Actividad actividad){
        Map<String,Object> mensaje = new HashMap<>();
        mensaje.put("succes",Boolean.TRUE);
        mensaje.put("data",servicio.guardar(actividad));
        return ResponseEntity.ok().body(mensaje);
    }
}