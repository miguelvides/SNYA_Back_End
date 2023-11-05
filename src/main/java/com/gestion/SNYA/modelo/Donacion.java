package com.gestion.SNYA.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entidad usada para poder hacer las distintas operaciones en la base de datos de la tabla donaciones ademas de guardar la informacio
 * Esta relacionada con la tabla donante para identificar la propiedad de cada donacion
 */

@Entity
@Table(name = "donaciones")
public class Donacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador; // Identificador único de la donación
    @Column(nullable = false)
    @NotEmpty(message = "Proposito no puede estar vacio") //validacion
    private String proposito; // Propósito de la donación
    @Column(nullable = false)
    @NotNull(message = "Importe no debe estar vacio") //validacion
    private BigDecimal importe; // Importe de la donación
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta; // Fecha en que se creó la donación
    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion; // Fecha en que se modificó la donación

    @JsonIgnoreProperties({"donaciones"})
    @ManyToOne
    @JoinColumn(name = "donante_id")
    private Donante donante; // Donante asociado a la donación

    @PrePersist
    public void antesPersistir(){
         this.fechaAlta = LocalDate.now(); // Establecer la fecha de alta automáticamente al crear la donación
    }
    @PreUpdate
    public void antesModificar(){
        this.fechaModificacion = LocalDate.now(); // Establecer la fecha de modificación automáticamente al modificar la donación
    }

    public Donacion() {
    }

    public Donacion(Long identificador, String proposito, BigDecimal importe, LocalDate fechaAlta, LocalDate fechaModificacion) {
        this.identificador = identificador;
        this.proposito = proposito;
        this.importe = importe;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    @Override
    public String toString() {
        return "Donacion:" +
                "identificador: " + identificador +
                ", proposito: " + proposito + '\'' +
                ", importe: " + importe +
                ", fechaAlta: " + fechaAlta +
                ", fechaModificacion: " + fechaModificacion +
                ", donante: " + donante;
    }
}
