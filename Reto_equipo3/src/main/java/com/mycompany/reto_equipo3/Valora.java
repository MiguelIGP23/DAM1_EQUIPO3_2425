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
public class Valora {
    private int idValora;
    private int dificultad;
    private LocalDate fecha;
    private int estrellas;
    private int interesCultural;
    private int belleza;
    private String valoracionTecnica;
    private String reseña;
    // constructor con las valoraciones con la id
    public Valora(int idValora, int dificultad, LocalDate fecha, int estrellas, int interesCultural, int belleza, String valoracionTecnica, String reseña) {
        this.idValora = idValora;
        this.dificultad = dificultad;
        this.fecha = fecha;
        this.estrellas = estrellas;
        this.interesCultural = interesCultural;
        this.belleza = belleza;
        this.valoracionTecnica = valoracionTecnica;
        this.reseña = reseña;
    }
    // constructor sin la id
      public Valora(int dificultad, LocalDate fecha, int estrellas, int interesCultural, int belleza, String valoracionTecnica, String reseña) {
        this.dificultad = dificultad;
        this.fecha = fecha;
        this.estrellas = estrellas;
        this.interesCultural = interesCultural;
        this.belleza = belleza;
        this.valoracionTecnica = valoracionTecnica;
        this.reseña = reseña;
    }
      //constructor con los valores que no admiten nulos
    public Valora(int dificultad, LocalDate fecha) {
        this.dificultad = dificultad;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Valora{" + "idValora=" + idValora + ", dificultad=" + dificultad + ", fecha=" + fecha + ", estrellas=" + estrellas + ", interesCultural=" + interesCultural + ", belleza=" + belleza + ", valoracionTecnica=" + valoracionTecnica + ", rese\u00f1a=" + reseña + '}';
    }
    
}
