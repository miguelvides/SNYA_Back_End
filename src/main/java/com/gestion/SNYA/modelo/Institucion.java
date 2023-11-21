package com.gestion.SNYA.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Institucion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer idInstitucion;
	String nombre;
	String tipo_institucion;
	Double presupuesto_institucion;
	Date fecha_ingreso;
	
	
	public Integer getIdInstitucion() {
		return idInstitucion;
	}
	

	
	
	


}
