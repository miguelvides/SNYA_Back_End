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



public class Donante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer idDoanante;
	String nombre;
	String institucion_donante;
	String actividad_donante; 
	Date fecha_inscripcion;
	
	

}
