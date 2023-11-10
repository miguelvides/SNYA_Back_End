package com.gestion.SNYA.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.SNYA.modelo.Actividad;
import com.gestion.SNYA.repositorio.ActividadRepositorio;

@RestController
@RequestMapping("/api/v1/actividades")

public class ActividadControlador {
    final
    ActividadRepositorio actividadRepositorio;

    public ActividadControlador(ActividadRepositorio actividadRepositorio) {
        this.actividadRepositorio = actividadRepositorio;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        Map<String,Object> mensaje = new HashMap<>();
        List<Actividad> actividades = actividadRepositorio.findAll();
        if (actividades.isEmpty()){
            mensaje.put("succes",Boolean.FALSE);
            mensaje.put("Mensaje","No hay datos");
            return ResponseEntity.ok().body(mensaje);
        }
        mensaje.put("succes",Boolean.TRUE);
        mensaje.put("data",actividadRepositorio.findAll());
        return ResponseEntity.ok().body(mensaje);
    }
    @PostMapping
    public ResponseEntity<?> createActividad(@RequestBody Actividad actividad){
        Map<String,Object> mensaje = new HashMap<>();
        mensaje.put("succes",Boolean.TRUE);
        mensaje.put("data",actividadRepositorio.save(actividad));
        return ResponseEntity.ok().body(mensaje);
    }
}