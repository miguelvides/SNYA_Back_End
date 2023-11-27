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
	Integer idDonante;
	String nombre;
	String institucion_donante;
	String actividad_donante; 
	Date fecha_inscripcion;
	
	public int getIdDonante() {
        return idDonante;
    }

    public void setIdDonante(int idDonante) {
        this.idDonante = idDonante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstitucion_donante() {
        return institucion_donante;
    }

    public void setInstitucion_donante(String institucion_donante) {
        this.institucion_donante = institucion_donante;
    }

    public String getActividad_donante() {
        return actividad_donante;
    }

    public void setActividad_donante(String actividad_donante) {
        this.actividad_donante = actividad_donante;
    }

    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

}
