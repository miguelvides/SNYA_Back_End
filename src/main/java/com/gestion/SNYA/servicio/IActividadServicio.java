package com.gestion.SNYA.servicio;

import com.gestion.SNYA.modelo.Actividad;

import java.util.List;

public interface IActividadServicio {
     List<Actividad> listar();
     Actividad buscarId(Integer id );
     Actividad guardar(Actividad actividad);
     void elimiarId(Integer id);
     Actividad obtenerPorId(Integer id);
}
