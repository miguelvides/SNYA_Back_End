package com.gestion.SNYA.modelo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad usada para poder hacer las distintas operaciones en la base de datos de la tabla donantes ademas de guardar la informacion
 * Esta relacionada con la tabla donaciones para identificar la propiedad de cada donacion
 */
@Entity
@Table(name = "donantes")
public class Donante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del donante
    @NotNull(message = "Nombre no puede ser nulo") //validacion
    @NotEmpty(message = "Nombre no puede estar vacio") //validacion
    @Column(nullable = false)
    private String nombre; // Nombre del donante
    @Column(name = "tipo_entidad",nullable = false,length = 60)
    private TipoEntidad tipoEntidad; // Tipo de entidad del donante (por ejemplo, persona física o jurídica)
    @Column(length = 60)
    private String direccion; // Dirección del donante
    @NotEmpty(message = "Correo Electronico no puede quedar vacio") //validacion
    @Column(name = "correo_electronico",nullable = false,unique = true)
    @Email(message = "Email debe ser valido")
    private String correoElectronico; // Correo electrónico del donante
    @NotEmpty(message = "Telefono no puede quedar vacio")//validacion
    @Column(nullable = false)
    private String telefono; // Número de teléfono del donante

    @JsonIgnoreProperties({"donante", "fechaAlta", "fechaModificacion"})
    @OneToMany(mappedBy = "donante")
    private List<Donacion> donaciones; // Lista de donaciones realizadas por el donante

    public Donante() {
    }
    public Donante(Long id, String nombre, TipoEntidad tipoEntidad, String direccion, String correoElectronico, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.tipoEntidad = tipoEntidad;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.donaciones = new ArrayList<>();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoEntidad getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(TipoEntidad tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Donacion> getDonaciones() {
        return donaciones;
    }

    //Metodo usado para añadir registro de donacion por parte de este donante
    public void setDonaciones(List<Donacion> donaciones) {
        this.donaciones =  donaciones;
    }
    public void agregarDonacion(Donacion donacion){
        this.donaciones.add(donacion);
    }

    @Override
    public String toString() {
        return "Donante: " +
                "id: " + id +
                ", nombre: " + nombre + '\'' +
                ", tipoEntidad: " + tipoEntidad +
                ", direccion: " + direccion + '\'' +
                ", correoElectronico: " + correoElectronico + '\'' +
                ", telefono: " + telefono;
    }
}
