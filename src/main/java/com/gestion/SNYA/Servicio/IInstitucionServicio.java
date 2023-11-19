/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gestion.SNYA.Servicio;
import com.gestion.SNYA.modelo.Institucion;
import java.util.List;

/**
 *
 * @author pc
 */
public interface IInstitucionServicio {
    public Institucion guardarInstitucion(Institucion institucion);
    public List<Institucion> listarInstitucion();
}
