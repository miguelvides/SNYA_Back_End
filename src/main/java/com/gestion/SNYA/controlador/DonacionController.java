package com.gestion.SNYA.controlador;

import com.gestion.SNYA.modelo.Donacion;
import com.gestion.SNYA.repositorio.DonacionRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/donacion")
public class DonacionController {

    final
    DonacionRepositorio donacionRepositorio;

    public DonacionController(DonacionRepositorio donacionRepositorio) {
        this.donacionRepositorio = donacionRepositorio;
    }

    /**
     * Controlador para obtener todas las donaciones.
     *
     * @return ResponseEntity con un mensaje de éxito y la lista de donaciones, o un mensaje de error si no existen datos.
     */
    @GetMapping
    public ResponseEntity<?> findAllDonantes(){
        Map<String,Object> mensaje = new HashMap<>();
        List<Donacion> donaciones = donacionRepositorio.findAll();
        if (donaciones.isEmpty()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje","No existen datos");
            return ResponseEntity.ok().body(mensaje);
        }
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",donaciones);
        return ResponseEntity.ok().body(mensaje);
    }
}

