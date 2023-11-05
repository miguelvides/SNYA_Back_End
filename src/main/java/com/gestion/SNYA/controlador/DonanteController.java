package com.gestion.SNYA.controlador;

import com.gestion.SNYA.modelo.Donacion;
import com.gestion.SNYA.modelo.Donante;
import com.gestion.SNYA.repositorio.DonacionRepositorio;
import com.gestion.SNYA.repositorio.DonanteRepositorio;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/donantes")
public class DonanteController {

    final
    DonanteRepositorio donanteRepositorio;
    final DonacionRepositorio donacionRepositorio;

    public DonanteController(DonanteRepositorio donanteRepositorio, DonacionRepositorio donacionRepositorio) {
        this.donanteRepositorio = donanteRepositorio;
        this.donacionRepositorio = donacionRepositorio;
    }

    /**
     * Controlador para obtener todos los donantes.
     *
     * @return ResponseEntity con un mensaje de éxito y la lista de donantes, o un mensaje de error si no existen datos.
     */
    @GetMapping
    public ResponseEntity<?> findAllDonantes(){
        Map<String,Object> mensaje = new HashMap<>();
        List<Donante> donantes = donanteRepositorio.findAll();
        if (donantes.isEmpty()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje","No existen datos");
            return ResponseEntity.ok().body(mensaje);
        }
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",donantes);
        return ResponseEntity.ok().body(mensaje);
    }

    /**
     * Controlador para crear un nuevo donante con una donación asociada.
     *
     * @param donante El objeto Donante a ser creado.
     * @return ResponseEntity con un mensaje de éxito si se crea el donante, o un mensaje de error si no se puede crear.
     */
    @PostMapping
    public ResponseEntity<?> createDonante(@Valid @RequestBody Donante donante, BindingResult result){
        Map<String,Object> mensaje = new HashMap<>();
        Donacion donacion1 = new Donacion();
        if (result.hasErrors()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("validaciones",obtenerValidaciones(result));
            return ResponseEntity.unprocessableEntity().body(mensaje);
        }
        for(Donacion donacion:donante.getDonaciones()){
            donacion.setDonante(donante);
            donacion1 = donacion;
        }
        donanteRepositorio.save(donante);
        donacionRepositorio.save(donacion1);
        mensaje.put("mensaje","Donante creado con éxito");
        return ResponseEntity.ok().body(mensaje);
    }

    /**
     * Controlador para asignar una nueva donación a un donante existente.
     *
     * @param id El ID del donante al que se asignará la donación.
     * @param donacion El objeto Donacion a ser asignado al donante.
     * @return ResponseEntity con un mensaje de éxito si se asigna la donación, o un mensaje de error si no se puede asignar.
     */
    @PutMapping("/{id}/nuevadonacion")
    public ResponseEntity<?> asignarDonacion(@PathVariable Long id, @RequestBody Donacion donacion){
        Map<String,Object> mensaje = new HashMap<>();
        Donante donanteBD = donanteRepositorio.findById(id).orElse(null);
        if (donanteBD == null){
            mensaje.put("mensaje",String.format("No existe donante con ID: %d",id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        donacion.setDonante(donanteBD);
        donanteBD.agregarDonacion(donacionRepositorio.save(donacion));
        mensaje.put("mensaje","Donación asignada con éxito");
        return ResponseEntity.ok().body(mensaje);
    }

    protected Map<String,Object> obtenerValidaciones(BindingResult result){
        Map<String,Object> validaciones = new HashMap<>();
        result.getFieldErrors()
                .forEach(error-> validaciones.put(error.getField(),error.getDefaultMessage()));
        return validaciones;
    }

}