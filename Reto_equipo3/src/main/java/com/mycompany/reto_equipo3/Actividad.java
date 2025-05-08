/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

/**
 *
 * @author DAM123
 */
public class Actividad {
    
    private int idActividad;
    private String nombre;

    public Actividad(int idActividad, String nombre) {
        this.idActividad = idActividad;
        this.nombre = nombre;
    }

    public Actividad(String nombre) {
        this.nombre = nombre;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
