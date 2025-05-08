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
    public Valora(int idValora, int dificultad, LocalDate fecha, int estrellas, int interesCultural, int belleza) {
        this.idValora = idValora;
        this.dificultad = dificultad;
        this.fecha = fecha;
        this.estrellas = estrellas;
        this.interesCultural = interesCultural;
        this.belleza = belleza;
    }
    // constructor sin la id
      public Valora(int dificultad, LocalDate fecha, int estrellas, int interesCultural, int belleza) {
        this.dificultad = dificultad;
        this.fecha = fecha;
        this.estrellas = estrellas;
        this.interesCultural = interesCultural;
        this.belleza = belleza;
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
    
    //Metodos get
    public int getIdValora() {
        return idValora;
    }

    public int getDificultad() {
        return dificultad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public int getInteresCultural() {
        return interesCultural;
    }

    public int getBelleza() {
        return belleza;
    }

    public String getValoracionTecnica() {
        return valoracionTecnica;
    }

    public String getReseña() {
        return reseña;
    }
    
    
    //Metodos set
    public void setIdValora(int idValora) {
        this.idValora = idValora;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public void setInteresCultural(int interesCultural) {
        this.interesCultural = interesCultural;
    }

    public void setBelleza(int belleza) {
        this.belleza = belleza;
    }

    public void setValoracionTecnica(String valoracionTecnica) {
        this.valoracionTecnica = valoracionTecnica;
    }

    public void setReseña(String reseña) {
        this.reseña = reseña;
    }
    
}
