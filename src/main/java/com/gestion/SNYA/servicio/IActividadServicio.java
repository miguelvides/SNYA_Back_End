package com.gestion.SNYA.servicio;

import com.gestion.SNYA.modelo.Actividad;

import java.util.List;

public interface IActividadServicio {
    public List<Actividad> listar();
    public Actividad buscarId(Integer id );
    public Actividad guardar(Actividad actividad);
    public void elimiarId(Integer id);
    public Actividad obtenerPorId(Integer id);
}
