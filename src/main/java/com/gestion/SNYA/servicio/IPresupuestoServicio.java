package com.gestion.SNYA.servicio;

import java.util.List;

import com.gestion.SNYA.modelo.Presupuesto;

 public interface IPresupuestoServicio {
  public List<Presupuesto> listarPresupuesto();
  public Presupuesto buscarPresupuestoPorId(Integer IdPresupuesto);
  public void guardarPresupuesto(Presupuesto presupuesto);
  public void eliminarPresupuesto(Integer IdPresupuesto);
  
}
