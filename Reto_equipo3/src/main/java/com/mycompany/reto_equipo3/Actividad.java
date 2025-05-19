/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

/**
 * Clase que representa una actividad para la ruta
 * @author Miguel Inglés, JavaDoc por Hugo Fernández  
 */
public class Actividad {
    
    private int idActividad;
    private String nombre;
    /** Constructor por parámetros, incluye todos los atributos
     * @param idActividad para darle valor como parámetro al atributo "idActividad"
     * @param nombre para darle valor como parámetro al atributo del "nombre"
     */
    public Actividad(int idActividad, String nombre) {
        this.idActividad = idActividad;
        this.nombre = nombre;
    }
    /**
     * Constructor por parámetros, no incluye la id
     * @param nombre para darle valor como atributo al atributo del "nombre"
     */
    public Actividad(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Getter del atributo "idActividad"
     * @return el valor actual del atributo "idActividad"
     */
    public int getIdActividad() {
        return idActividad;
    }
    /**
     * Getter del atributo "nombre"
     * @return el valor actual del atributo "nombre"
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Setter del atributo "nombre"
     * @param nombre que sirve para igualarse al atributo "nombre" y cambiarle el valor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * toString de la clase para devolver la información de esta
     * @return una cadena con la información de la clase, mostrando todos los atributos
     */
    @Override
    public String toString() {
        return "Actividad{" + "idActividad=" + idActividad + ", nombre=" + nombre + "}\n";
    }
}
