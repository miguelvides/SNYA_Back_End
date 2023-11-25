package com.gestion.SNYA.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Actividad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Integer IdActividad; 
	String nombre;
	String donanteActividad;
	Integer presupuestoActividad; 
	Date fechaActividd; 
	

}
