package com.gestion.SNYA.servicio;

import java.util.List;

import com.gestion.SNYA.modelo.Institucion;

public interface IInstitucionServicio {
	public List<Institucion> listarInstituciones();
	public Institucion buscarInstitucionporId(Integer idInstitucion );
	public void guardarInstitucion(Institucion institucion);
	public void elimiarInstitucionporId(Integer idInstitucion);
	public Institucion obtenerInstitucionPorId(Integer id);
	
	


}
