package com.gestion.SNYA.servicio;

import com.gestion.SNYA.modelo.Actividad;
import com.gestion.SNYA.repositorio.ActividadRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadServicio implements IActividadServicio{

    private final ActividadRepositorio repositorio;

    public ActividadServicio(ActividadRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Actividad> listar() {
        return repositorio.findAll();
    }

    @Override
    public Actividad buscarId(Integer id) {
        return null;
    }

    @Override
    public Actividad guardar(Actividad actividad) {
        return repositorio.save(actividad);
    }

    @Override
    public void elimiarId(Integer id) {

    }

    @Override
    public Actividad obtenerPorId(Integer id) {
        return null;
    }
}
