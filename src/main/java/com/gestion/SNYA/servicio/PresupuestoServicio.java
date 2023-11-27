package com.gestion.SNYA.servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.SNYA.modelo.Presupuesto;
import com.gestion.SNYA.repositorio.PresupuestoRepositorio;


@Service
public class PresupuestoServicio implements IPresupuestoServicio{

   @Autowired
   ///agregar una variable privada de tipo presupuesto repositorio
   private PresupuestoRepositorio presupuestoRepositorio;
    public List<Presupuesto> listarPresupuestos() {
        return this.presupuestoRepositorio.findAll();
    }

    
    public Presupuesto buscarPrespuesto(Integer idPresInteger) {
       Presupuesto presupuesto =this.presupuestoRepositorio.findById(idPresInteger).orElse(null);
       return presupuesto;
    }

    @Override
    public void guardarPresupuesto(Presupuesto presupuesto) {
        this.presupuestoRepositorio.save(presupuesto);
    }
    
}
