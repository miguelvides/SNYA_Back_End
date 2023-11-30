package com.gestion.SNYA.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.SNYA.modelo.Presupuesto;
import com.gestion.SNYA.repositorio.PresupuestoRepositorio;
@Service

public class PresupuestoServicio implements IPresupuestoServicio{

	@Autowired
	
	private PresupuestoRepositorio presupuestoRepositorio;
	public List<Presupuesto> listarPresupuesto() {
		return this.presupuestoRepositorio.findAll();
	}

	
	public Presupuesto buscarPresupuestoPorId(Integer IdPresupuesto) {
		Presupuesto presupuesto=this.presupuestoRepositorio.findById(IdPresupuesto).orElse(null);
		return presupuesto;
	}


	public void guardarPresupuesto(Presupuesto presupuesto) {
		this.presupuestoRepositorio.save(presupuesto);		
	}


	public void eliminarPresupuesto(Integer IdPresupuesto) {
		this.presupuestoRepositorio.deleteById(IdPresupuesto);
		
	}

}
