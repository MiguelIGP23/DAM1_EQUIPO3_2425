/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import java.time.LocalDateTime;

/**
 * Clase que representa un calendario de rutas
 * @author Saúl García y Miguel Inglés, JavaDoc por Hugo Fernández    
 */
public class Calendario {
    private int idCalendario;
    private LocalDateTime fecha;
    private String detalles;
    private String recomendaciones;
    /**
     * Constructor por parámetros, incluye todos los parámetros
     * @param idCalendario para darle valor como parámetro al atributo "idCalendario"
     * @param fecha para darle valor como parámetro al atributo "fecha"
     * @param detalles para darle valor como parámetro al atributo "detalles"
     * @param recomendaciones para darle valor como parámetro al atributo "recomendaciones"
     */
    public Calendario(int idCalendario, LocalDateTime fecha, String detalles, String recomendaciones) {
        this.idCalendario = idCalendario;
        this.fecha = fecha;
        this.detalles = detalles;
        this.recomendaciones=recomendaciones;
    }
    /**
     * Constructor por parámetros, no incluye la id
     * @param fecha para darle valor como parámetro al atributo "fecha"
     * @param detalles para darle valor como parámetro al atributo "detalles"
     * @param recomendaciones para darle valor como parámetro al atributo "recomendaciones"
     */
     public Calendario( LocalDateTime fecha, String detalles, String recomendaciones) {
        this.fecha = fecha;
        this.detalles = detalles;
        this.recomendaciones=recomendaciones;
    }
    /**
     * Constructor con solo los atributos que no pueden recibir nulos
     * @param fecha para darle valor como parámetro al atributo "fecha"
     */
    public Calendario(LocalDateTime fecha) {
        this.fecha = fecha;   
    }
    /**
     * toString de la clase para devolver la información de esta
     * @return una cadena con la información de la clase, mostrando todos los atributos a excepción de la id
     */
    @Override
    public String toString() {
        return "Calendario: fecha=" + fecha + ", detalles=" + detalles + ", recomendaciones=" + recomendaciones+"\n";
    } 
    /**
     * Getter del atributo "idCalendario" 
     * @return el valor actual del atributo "idCalendario"
     */
    public int getIdCalendario() {
        return idCalendario;
    }
    /**
     * Getter del atributo "fecha" 
     * @return el valor actual del atributo "fecha"
     */
    public LocalDateTime getFecha() {
        return fecha;
    }
    /**
     * Getter del atributo "detalles" 
     * @return el valor actual del atributo "detalles"
     */
    public String getDetalles() {
        return detalles;
    }
    /**
     * Getter del atributo "recomendaciones" 
     * @return el valor actual del atributo "recomendaciones"
     */
    public String getRecomendaciones() {
        return recomendaciones;
    }
    /**
     * Setter del atributo "idCalendario"
     * @param idCalendario que sirve para igualarse al atributo "idCalendario" y cambiarle el valor
     */
    public void setIdCalendario(int idCalendario) {
        this.idCalendario = idCalendario;
    }
    /**
     * Setter del atributo "fecha"
     * @param fecha que sirve para igualarse al atributo "fecha" y cambiarle el valor
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    /**
     * Setter del atributo "detalles"
     * @param detalles que sirve para igualarse al atributo "detalles" y cambiarle el valor
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    /**
     * Setter del atributo "recomendaciones"
     * @param recomendaciones que sirve para igualarse al atributo "recomendaciones" y cambiarle el valor
     */
    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
}


