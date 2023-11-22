package com.gestion.SNYA.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instituciones")

public class Institucion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Identificador", length = 60, nullable = false)
	private String Identificador;
	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;
	@Column(name = "tipoInstitucion", length = 60, nullable = false)
	private String tipoInstitucion;
	@Column(name = "fecha", length = 60, nullable = false, unique = true)
	private String fecha;


	

	public Institucion() {

	}

	

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Institucion(long id, String nombre,String  fecha,String tipoInstitucion ) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoInstitucion= tipoInstitucion;
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
	public String getTipoInstitucion() {
		return tipoInstitucion;
	}

	public void setTipoInstitucion(String tipoInstitucion) {
		this.tipoInstitucion = tipoInstitucion;
	}

}
