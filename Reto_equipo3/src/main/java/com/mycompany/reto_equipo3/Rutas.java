/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Enums.Clasificacion;
import java.time.LocalDate;
import java.util.Set;

/**
 *
 * @author DAM123
 */
public class Rutas {
    
    //Atributos de clase
    private int idRuta;
    private String nombre;
    private String nombre_inicioruta;
    private String nombre_finalruta;
    private double latitudInicial;
    private double latitudFinal;
    private double longitudInicial;
    private double longitudFinal;
    private double distancia;
    private LocalDate duracion;
    private int desnivelPositivo;
    private int desnivelNegativo;
    private double altitudMax;
    private double altitudMin;
    private Clasificacion clasificacion;
    private int nivelEsfuerzo;
    private int nivelriesgo;
    private int estadoRuta;
    private int tipoterreno;
    private int indicaciones;   //indicar valores de 1 a 5
    private Set<String> temporada;   //buscar como implementar set    
    private boolean accesibilidad;
    private boolean rutaFamiliar;
    private String text;
    private String recomendaciones;
    private String zonaGeografica;
    private double mediaEstrellas;
    
   

    //Constructor con id y solo atributos obligatorios
    public Rutas(int idRuta, String nombre, String nombre_inicioruta, String nombre_finalruta, double latitudInicial, double latitudFinal, double longitudInicial, double longitudFinal, double distancia, LocalDate duracion) {
        this.idRuta = idRuta;
        this.nombre = nombre;
        this.nombre_inicioruta = nombre_inicioruta;
        this.nombre_finalruta = nombre_finalruta;
        this.latitudInicial = latitudInicial;
        this.latitudFinal = latitudFinal;
        this.longitudInicial = longitudInicial;
        this.longitudFinal = longitudFinal;
        this.distancia = distancia;
        this.duracion = duracion;
    }
    
    //Constructor sin id y solo con atributos obligatorios

    public Rutas(String nombre, String nombre_inicioruta, String nombre_finalruta, double latitudInicial, double latitudFinal, double longitudInicial, double longitudFinal, double distancia, LocalDate duracion) {
        this.nombre = nombre;
        this.nombre_inicioruta = nombre_inicioruta;
        this.nombre_finalruta = nombre_finalruta;
        this.latitudInicial = latitudInicial;
        this.latitudFinal = latitudFinal;
        this.longitudInicial = longitudInicial;
        this.longitudFinal = longitudFinal;
        this.distancia = distancia;
        this.duracion = duracion;
    }
    
    
    //Constructor completo
    public Rutas(int idRuta, String nombre, String nombre_inicioruta, String nombre_finalruta, double latitudInicial, double latitudFinal, double longitudInicial, double longitudFinal, double distancia, LocalDate duracion, int desnivelPositivo, int desnivelNegativo, double altitudMax, double altitudMin, Clasificacion clasificacion, int nivelEsfuerzo, int nivelriesgo, int estadoRuta, int tipoterreno, int indicaciones, Set<String> temporada, boolean accesibilidad, boolean rutaFamiliar, String text, String recomendaciones, String zonaGeografica, double mediaEstrellas) {
        this.idRuta = idRuta;
        this.nombre = nombre;
        this.nombre_inicioruta = nombre_inicioruta;
        this.nombre_finalruta = nombre_finalruta;
        this.latitudInicial = latitudInicial;
        this.latitudFinal = latitudFinal;
        this.longitudInicial = longitudInicial;
        this.longitudFinal = longitudFinal;
        this.distancia = distancia;
        this.duracion = duracion;
        this.desnivelPositivo = desnivelPositivo;
        this.desnivelNegativo = desnivelNegativo;
        this.altitudMax = altitudMax;
        this.altitudMin = altitudMin;
        this.clasificacion = clasificacion;
        this.nivelEsfuerzo = nivelEsfuerzo;
        this.nivelriesgo = nivelriesgo;
        this.estadoRuta = estadoRuta;
        this.tipoterreno = tipoterreno;
        this.indicaciones = indicaciones;
        this.temporada = temporada;
        this.accesibilidad = accesibilidad;
        this.rutaFamiliar = rutaFamiliar;
        this.text = text;
        this.recomendaciones = recomendaciones;
        this.zonaGeografica = zonaGeografica;
        this.mediaEstrellas = mediaEstrellas;
    }

    
    
}
