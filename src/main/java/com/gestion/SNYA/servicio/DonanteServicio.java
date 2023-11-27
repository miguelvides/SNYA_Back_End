package com.gestion.SNYA.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion.SNYA.modelo.Donante;
import com.gestion.SNYA.repositorio.DonanteRepositorio;

@Service
public class DonanteServicio implements IDonanteServicio{

    private final DonanteRepositorio repositorio;

    public DonanteServicio(DonanteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Donante> listarDonantes() {
        return repositorio.findAll();
    }

    @Override
    public Donante buscarDonanteporId(Integer id) {
        Donante donante = this.repositorio.findById(id).orElse(null);
        return donante;
        
    }

    @Override
    public void guardarDonante(Donante donante) {
        this.repositorio.save(donante);
    }

    @Override
    public void elimiarDonanteporId(Integer idDonante) {
        this.repositorio.deleteById(idDonante);
    }

}