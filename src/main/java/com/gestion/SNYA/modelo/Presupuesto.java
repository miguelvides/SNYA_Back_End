package com.gestion.SNYA.modelo;

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



public class Presupuesto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer IdPresupuesto;
	Integer cantidad;
	String institucion;
	String observacion; 
	
	 public Integer getIdPresupuesto() {
	        return IdPresupuesto;
	    }

}
