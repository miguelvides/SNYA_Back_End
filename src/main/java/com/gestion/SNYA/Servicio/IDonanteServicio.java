/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gestion.SNYA.Servicio;

import com.gestion.SNYA.modelo.Donante;
import java.util.List;

/**
 *
 * @author pc
 */
public interface IDonanteServicio {
     public Donante agregarDonante(Donante Donante);
    public List<Donante> listarDonante();
}
