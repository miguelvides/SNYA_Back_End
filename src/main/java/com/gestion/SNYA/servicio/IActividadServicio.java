package com.gestion.SNYA.servicio;
import java.util.List;

import com.gestion.SNYA.modelo.Actividad;
public interface IActividadServicio {
    public List<Actividad> listarActividadeList();
	public Actividad buscarActividadId(Integer idAcInteger );
	public void guardarActividad(Actividad actividad);
	//public void elimiarActividadId(Integer idActividad);
      
}
