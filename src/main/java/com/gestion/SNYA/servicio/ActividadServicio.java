package com.gestion.SNYA.servicio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.SNYA.modelo.Actividad;
import com.gestion.SNYA.repositorio.ActividadRepositorio;
@Service

public class ActividadServicio implements IActividadServicio{
    @Autowired

    private ActividadRepositorio activiRepositorio;
	
	public List<Actividad> listarActividadeList() {
		return this.activiRepositorio.findAll();
	}


    public Actividad buscarActividadId(Integer idActividad) {
		Actividad actividad=this.activiRepositorio.findById(idActividad).orElse(null);
		
		return actividad;
	}

	//metodo para guardar o actualizar
	public void guardarActividad(Actividad actividad){
		this.activiRepositorio.save(actividad);
	}
}
