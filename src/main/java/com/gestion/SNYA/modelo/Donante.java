/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestion.SNYA.modelo;

/**
 *
 * @author pc
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "donantes")

public class Donante {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
      @Column(name = "nombreDonante", length = 60, nullable = false)
	private String NomDonante;
        @Column(name = "institucionDonante", length = 60, nullable = false)
	private String InstitucionDonante;
          @Column(name = "actDonante", length = 60, nullable = false)
	private String ActDonante;
          
          public Donante()
          {}

    public Donante(long id, String NomDonante, String InstitucionDonante, String ActDonante) {
        super();
        this.id = id;
        this.NomDonante = NomDonante;
        this.InstitucionDonante = InstitucionDonante;
        this.ActDonante = ActDonante;
    }

          
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomDonante() {
        return NomDonante;
    }

    public void setNomDonante(String NomDonante) {
        this.NomDonante = NomDonante;
    }

    public String getInstitucionDonante() {
        return InstitucionDonante;
    }

    public void setInstitucionDonante(String InstitucionDonante) {
        this.InstitucionDonante = InstitucionDonante;
    }

    public String getActDonante() {
        return ActDonante;
    }

    public void setActDonante(String ActDonante) {
        this.ActDonante = ActDonante;
    }
          
          
    
    
}
