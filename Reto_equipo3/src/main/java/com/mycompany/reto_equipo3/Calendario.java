/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import java.time.LocalDate;

/**
 *
 * @author DAM121
 */
public class Calendario {
    private int idCalendario;
    private LocalDate fecha;
    private String detalles;
    private String recomendaciones;
    //Constructor de calendario para añadirlo con la id
    public Calendario(int idCalendario, LocalDate fecha, String detalles, String recomendaciones) {
        this.idCalendario = idCalendario;
        this.fecha = fecha;
        this.detalles = detalles;
        this.recomendaciones = recomendaciones;
    }
    //constructor de calendario para crearlo sin id
     public Calendario( LocalDate fecha, String detalles, String recomendaciones) {
        this.fecha = fecha;
        this.detalles = detalles;
        this.recomendaciones = recomendaciones;
    }
    // constructor con solo los atributos que no pueden recibir nulos
    public Calendario(LocalDate fecha) {
        this.fecha = fecha;   
    }
    
    @Override
    public String toString() {
        return "Calendario: fecha=" + fecha + ", detalles=" + detalles + ", recomendaciones=" + recomendaciones;
    } 
}
