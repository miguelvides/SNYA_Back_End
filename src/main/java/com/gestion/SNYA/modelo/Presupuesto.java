package com.gestion.SNYA.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "presupuestos")
public class Presupuesto {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name = "cantidad", length = 60, nullable = false)
	private String cantidad;
	@Column(name = "institucion", length = 60, nullable = false)
	private String institucion;
	@Column(name = "observacion", length = 60, nullable = false)
	private String observacion;

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getCantidad() {
        return cantidad;
    }


    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }


    public String getInstitucion() {
        return institucion;
    }


    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }


    public String getObservacion() {
        return observacion;
    }


    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    public Presupuesto(){

    }

    
	public Presupuesto(long id, String cantidad,String institucion,String observacion ) {
		super();
		this.id = id;
		this.cantidad= cantidad;
		this.institucion=institucion;
		this.observacion=observacion;
	}


}

