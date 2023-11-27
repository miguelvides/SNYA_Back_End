package com.gestion.SNYA.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.SNYA.modelo.Institucion;
import com.gestion.SNYA.repositorio.InstitucionRepositorio;
@Service

public class InstitucionServicio implements IInstitucionServicio{
	@Autowired
	private InstitucionRepositorio institucionRepositorio;
	
	public List<Institucion> listarInstituciones() {
		return this.institucionRepositorio.findAll();
	}

	public Institucion buscarInstitucionporId(Integer idInstitucion) {
		Institucion institucion=this.institucionRepositorio.findById(idInstitucion).orElse(null);
		return institucion;
	}

	public void guardarInstitucion(Institucion institucion) {
		this.institucionRepositorio.save(institucion);
	}

	public void elimiarInstitucionporId(Integer idInstitucion) {
		this.institucionRepositorio.deleteById(idInstitucion);


	}

}
