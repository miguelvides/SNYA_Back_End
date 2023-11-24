package com.gestion.SNYA.servicio;
import java.util.List;

import com.gestion.SNYA.modelo.Presupuesto;
public interface IPresupuestoServicio {
        public List<Presupuesto> listarPresupuestos();
	public Presupuesto buscarPrespuesto(Integer idPresInteger );
	public void guardarPresupuesto(Presupuesto presupuesto);
	//public void eliminarPresupuesto(Integer idPresupuesto);
}
