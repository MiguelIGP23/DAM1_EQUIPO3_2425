/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Enums.Clasificacion;
import com.mycompany.reto_equipo3.Validaciones.TecladoRutas;
import java.time.LocalTime;
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
    private LocalTime duracion;
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
    private Set<String> temporada; 
    private boolean accesibilidad;
    private boolean rutaFamiliar;
    private String text;
    private String recomendaciones;
    private String zonaGeografica;
    private double mediaEstrellas;
    
   

    //Constructor con id y solo atributos obligatorios como parametros
    public Rutas(int idRuta, String nombre, String nombre_inicioruta, String nombre_finalruta, double latitudInicial, double latitudFinal, double longitudInicial, double longitudFinal, double distancia, LocalTime duracion) {
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
    
    //Constructor sin id y solo con atributos obligatorios como parametros
    public Rutas(String nombre, String nombre_inicioruta, String nombre_finalruta, double latitudInicial, double latitudFinal, double longitudInicial, double longitudFinal, double distancia, LocalTime duracion) {
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
    
    
    //Constructor completo con recibe datos por teclado y realiza todas las validaciones
    public Rutas() {
        this.idRuta = 0;
        this.nombre = TecladoRutas.validanombre("Introduce nombre de la ruta:");
        this.nombre_inicioruta = TecladoRutas.validaInicioFinalRuta("Introduce inicio de ruta:");
        this.nombre_finalruta = TecladoRutas.validaInicioFinalRuta("Introduce fin de ruta:");
        this.latitudInicial = TecladoRutas.validaCoordenadas("Introduce latitud inicial:");
        this.latitudFinal = TecladoRutas.validaCoordenadas("Introduce latitud final:");
        this.longitudInicial = TecladoRutas.validaCoordenadas("Introduce longitud inicial:");
        this.longitudFinal = TecladoRutas.validaCoordenadas("Introduce longitud final:");
        this.distancia = TecladoRutas.validaDistancia("Introduce distancia de la ruta:");
        this.duracion = TecladoRutas.validaDuracion("Introduce duracion en formato hh:mm:ss");
        this.desnivelPositivo = TecladoRutas.validaDesnivelPositivo("Introduce desnivel positivo:");
        this.desnivelNegativo = TecladoRutas.validaDesnivelNegativo("Introduce desnivel negativo:");
        this.altitudMax = TecladoRutas.validaCoordenadas("Introduce altitud maxima:");
        this.altitudMin = TecladoRutas.validaCoordenadas("Introduce altitud minima:");
        this.clasificacion = TecladoRutas.validaClasificacion("Elige entre ruta circular o lineal:");
        this.nivelEsfuerzo = TecladoRutas.validaRango1a5("Introduce nivel de esfuerzo [1-5]");
        this.nivelriesgo = TecladoRutas.validaRango1a5("Introduce nivel de riesgo [1-5]");
        this.estadoRuta = TecladoRutas.validaRango1a5("Introduce estado de ruta [1-5]");
        this.tipoterreno = TecladoRutas.validaRango1a5("Introduce tipo de terreno [1-5]");
        this.indicaciones = TecladoRutas.validaRango1a5("Introduce indicaciones[1-5]");
        this.temporada = TecladoRutas.validaTemporada("Introduce una o mas temporadas separadas por comas (primevera,verano,otoño,invierno)");
        this.accesibilidad = TecladoRutas.validaBoolean("Ruta accesible? SI/NO");
        this.rutaFamiliar = TecladoRutas.validaBoolean("Ruta familiar? SI/NO");
        this.text = text;
        this.recomendaciones = recomendaciones;
        this.zonaGeografica = zonaGeografica;
        this.mediaEstrellas = mediaEstrellas;
    } 
    
}
