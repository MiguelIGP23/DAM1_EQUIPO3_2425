/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import java.time.LocalDate;

/**
 * Clase que representa una valoración de un usuario a una ruta
 *
 * @author Miguel Inglés, JavaDoc por Hugo Fernández
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

    /**
     * Constructor por parámetros, con las valoraciones con la id
     *
     * @param idValora para darle valor como parámetro al atributo "idValora"
     * @param dificultad para darle valor como parámetro al atributo
     * "dificultad"
     * @param fecha para darle valor como parámetro al atributo "fecha"
     * @param estrellas para darle valor como parámetro al atributo "estrellas"
     * @param interesCultural para darle valor como parámetro al atributo
     * "interesCultural"
     * @param belleza para darle valor como parámetro al atributo "belleza"
     */
    public Valora(int idValora, int dificultad, LocalDate fecha, int estrellas, int interesCultural, int belleza) {
        this.idValora = idValora;
        this.dificultad = dificultad;
        this.fecha = fecha;
        this.estrellas = estrellas;
        this.interesCultural = interesCultural;
        this.belleza = belleza;
    }
    /**
     * Constructor por parámetros, sin la id
     *
     * @param dificultad para darle valor como parámetro al atributo
     * "dificultad"
     * @param fecha para darle valor como parámetro al atributo "fecha"
     * @param estrellas para darle valor como parámetro al atributo "estrellas"
     * @param interesCultural para darle valor como parámetro al atributo
     * "interesCultural"
     * @param belleza para darle valor como parámetro al atributo "belleza"
     */
    public Valora(int dificultad, LocalDate fecha, int estrellas, int interesCultural, int belleza) {
        this.dificultad = dificultad;
        this.fecha = fecha;
        this.estrellas = estrellas;
        this.interesCultural = interesCultural;
        this.belleza = belleza;
    }
    /**
     * Constructor por parámetros, con los valores que no admiten nulos
     * @param dificultad para darle valor como parámetro al atributo "dificultad"
     * @param fecha para darle valor como parámetro al atributo "fecha"
     */
    public Valora(int dificultad, LocalDate fecha) {
        this.dificultad = dificultad;
        this.fecha = fecha;
    }
    /**
     * toString de la clase para devolver la información de esta
     * @return una cadena con la información de la clase, mostrando los atributos que se deben de mostrar
     */
    @Override
    public String toString() {
        return "Valora {dificultad=" + dificultad + ", fecha=" + fecha + ", estrellas=" + estrellas + ", interesCultural=" + interesCultural + ", belleza=" + belleza + "}\n";
    }
    /**
     * Getter del atributo "idValora"
     * @return el valor actual del atributo "idValora"
     */
    public int getIdValora() {
        return idValora;
    }
    /**
     * Getter del atributo "dificultad"
     * @return el valor actual del atributo "dificultad"
     */
    public int getDificultad() {
        return dificultad;
    }
    /**
     * Getter del atributo "fecha"
     * @return el valor actual del atributo "fecha"
     */
    public LocalDate getFecha() {
        return fecha;
    }
    /**
     * Getter del atributo "estrellas"
     * @return el valor actual del atributo "estrellas"
     */
    public int getEstrellas() {
        return estrellas;
    }
    /**
     * Getter del atributo "interesCultural"
     * @return el valor actual del atributo "interesCultural"
     */
    public int getInteresCultural() {
        return interesCultural;
    }
    /**
     * Getter del atributo "belleza"
     * @return el valor actual del atributo "belleza"
     */
    public int getBelleza() {
        return belleza;
    }
    /**
     * Getter del atributo "valoracionTecnica"
     * @return el valor actual del atributo "valoracionTecnica"
     */
    public String getValoracionTecnica() {
        return valoracionTecnica;
    }
    /**
     * Getter del atributo "reseña"
     * @return el valor actual del atributo "reseña"
     */
    public String getReseña() {
        return reseña;
    }
    /**
     * Setter del atributo "idValora"
     * @param idValora que sirve para igualarse al atributo "idValora" y cambiarle el valor
     */
    public void setIdValora(int idValora) {
        this.idValora = idValora;
    }
    /**
     * Setter del atributo "dificultad"
     * @param dificultad que sirve para igualarse al atributo "dificultad" y cambiarle el valor
     */
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    /**
     * Setter del atributo "fecha"
     * @param fecha que sirve para igualarse al atributo "fecha" y cambiarle el valor
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    /**
     * Setter del atributo "estrellas"
     * @param estrellas que sirve para igualarse al atributo "estrellas" y cambiarle el valor
     */
    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
    /**
     * Setter del atributo "interesCultural"
     * @param interesCultural que sirve para igualarse al atributo "interesCultural" y cambiarle el valor
     */
    public void setInteresCultural(int interesCultural) {
        this.interesCultural = interesCultural;
    }
    /**
     * Setter del atributo "belleza"
     * @param belleza que sirve para igualarse al atributo "belleza" y cambiarle el valor
     */
    public void setBelleza(int belleza) {
        this.belleza = belleza;
    }
    /**
     * Setter del atributo "valoracionTecnica"
     * @param valoracionTecnica que sirve para igualarse al atributo "valoracionTecnica" y cambiarle el valor
     */
    public void setValoracionTecnica(String valoracionTecnica) {
        this.valoracionTecnica = valoracionTecnica;
    }
    /**
     * Setter del atributo "reseña"
     * @param reseña que sirve para igualarse al atributo "reseña" y cambiarle el valor
     */
    public void setReseña(String reseña) {
        this.reseña = reseña;
    }
}
