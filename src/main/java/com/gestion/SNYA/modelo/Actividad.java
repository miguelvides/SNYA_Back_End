package com.gestion.SNYA.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "actividades")

public class Actividad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Identificador", length = 60, nullable = false)
	private String Identificador;
	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;
	@Column(name = "tipoActividad", length = 60, nullable = false)
	private String tipoActividad;
	@Column(name = "fecha", length = 60, nullable = false, unique = true)
	private String fecha;


	

	public Actividad() {

	}

	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Institucion(long id, String nombre,String  fecha,String tipoActividad ) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoActividad= tipoActividad;
		this.fecha = fecha;
		
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentificador() {
		return Identificador;
	}

	public void setIdentificador(String identificador) {
		Identificador = identificador;
	}
	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

}
