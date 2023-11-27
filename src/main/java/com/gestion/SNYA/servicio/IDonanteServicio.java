package com.gestion.SNYA.servicio;

import java.util.List;

import com.gestion.SNYA.modelo.Donante;

public interface IDonanteServicio {
	public List<Donante> listarDonantes();
	public Donante buscarDonanteporId(Integer idInstitucion );
	public void guardarDonante(Donante Donante);
	public void elimiarDonanteporId(Integer idDonante);
	
	
}