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
import com.gestion.SNYA.modelo.Presupuesto;
import com.gestion.SNYA.servicio.PresupuestoServicio;

@RestController
//http://locahost:8080/snya-ap
@RequestMapping("snya-app")
@CrossOrigin(value = "http://localhost:4200")

public class PresupuestoControlador {
    private static final Logger logger =
    LoggerFactory.getLogger(PresupuestoControlador.class);
    @Autowired
    private PresupuestoServicio presupuestoServicioS;
    //----------------------------------------------------------
    @GetMapping("/getPresupuestos")
    //Listar todos los presupuestos
    public List<Presupuesto> obtenerAllPresupuesto(){
        List<Presupuesto> presupuesto = this.presupuestoServicioS.listarPresupuestos();
        logger.info("Presupuestos obtenidos");
        presupuesto.forEach((presu->logger.info(presu.toString())));
        return presupuesto;
    }
    
    //-----------------------------------------------------------
    //Buscar por id
    @GetMapping("/presupuesto/{id}")
    public ResponseEntity <Presupuesto> buscarPresupuestoID(
        @PathVariable int id
    ){
        Presupuesto presupuestoPorID = this.presupuestoServicioS.buscarPrespuesto(id);
        if(presupuestoPorID!=null){
            return ResponseEntity.ok(presupuestoPorID);
        }else{
            throw new ResourceNotFoundException("Presupuesto no encontrado "+id);
        }
    }
    //------------------------------------------------------------
    //Actualizar 
    @PutMapping("/presupuesto/{id}")
    public ResponseEntity <Presupuesto> actualizarDatosPresupuesto
    (@PathVariable int id,@RequestBody Presupuesto presup){
        Presupuesto presupuestoAc =this.presupuestoServicioS.buscarPrespuesto(id);
        presupuestoAc.setCantidad(presup.getCantidad());
        presupuestoAc.setInstitucion(presup.getInstitucion());
        presupuestoAc.setObservacion(presup.getObservacion());
        this.presupuestoServicioS.guardarPresupuesto(presupuestoAc);
        return ResponseEntity.ok(presupuestoAc);
    }
}
