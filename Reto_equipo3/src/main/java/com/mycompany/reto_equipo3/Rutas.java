/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Enums.Clasificacion;
import com.mycompany.reto_equipo3.Validaciones.Teclado;
import java.time.LocalTime;
import java.util.ArrayList;
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
    
    private ArrayList<PuntosPeligro> puntosPeligro;
    private ArrayList<PuntosInteres> puntosInteres;

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
        this.puntosPeligro=new ArrayList<>();
        this.puntosInteres=new ArrayList<>();
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
        this.puntosPeligro=new ArrayList<>();
        this.puntosInteres=new ArrayList<>();
    }

    //Constructor completo con recibe datos por teclado y realiza todas las validaciones
    public Rutas() {
        this.idRuta = 0;
        this.nombre = Teclado.validanombre("Introduce nombre de la ruta:");
        this.nombre_inicioruta = Teclado.validaInicioFinalRuta("Introduce inicio de ruta:");
        this.nombre_finalruta = Teclado.validaInicioFinalRuta("Introduce fin de ruta:");
        this.latitudInicial = Teclado.validaCoordenadas("Introduce latitud inicial:");
        this.latitudFinal = Teclado.validaCoordenadas("Introduce latitud final:");
        this.longitudInicial = Teclado.validaCoordenadas("Introduce longitud inicial:");
        this.longitudFinal = Teclado.validaCoordenadas("Introduce longitud final:");
        this.distancia = Teclado.validaDistancia("Introduce distancia de la ruta:");
        this.duracion = Teclado.validaDuracion("Introduce duracion en formato hh:mm:ss");
        this.desnivelPositivo = Teclado.validaDesnivelPositivo("Introduce desnivel positivo:");
        this.desnivelNegativo = Teclado.validaDesnivelNegativo("Introduce desnivel negativo:");
        this.altitudMax = Teclado.validaCoordenadas("Introduce altitud maxima:");
        this.altitudMin = Teclado.validaCoordenadas("Introduce altitud minima:");
        this.clasificacion = Teclado.validaClasificacion("Elige entre ruta circular o lineal:");
        this.nivelEsfuerzo = Teclado.validaRango1a5("Introduce nivel de esfuerzo [1-5]");
        this.nivelriesgo = Teclado.validaRango1a5("Introduce nivel de riesgo [1-5]");
        this.estadoRuta = Teclado.validaRango1a5("Introduce estado de ruta [1-5]");
        this.tipoterreno = Teclado.validaRango1a5("Introduce tipo de terreno [1-5]");
        this.indicaciones = Teclado.validaRango1a5("Introduce indicaciones[1-5]");
        this.temporada = Teclado.validaTemporada("Introduce una o mas temporadas separadas por comas (primevera,verano,otoño,invierno)");
        this.accesibilidad = Teclado.validaBoolean("Ruta accesible? SI/NO");
        this.rutaFamiliar = Teclado.validaBoolean("Ruta familiar? SI/NO");
        this.text = text;
        this.recomendaciones = recomendaciones;
        this.zonaGeografica = zonaGeografica;
        this.mediaEstrellas = mediaEstrellas;
        this.puntosPeligro=new ArrayList<>();
        this.puntosInteres=new ArrayList<>();
    }

    //Metodos get
    public int getIdRuta() {
        return idRuta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombre_inicioruta() {
        return nombre_inicioruta;
    }

    public String getNombre_finalruta() {
        return nombre_finalruta;
    }

    public double getLatitudInicial() {
        return latitudInicial;
    }

    public double getLatitudFinal() {
        return latitudFinal;
    }

    public double getLongitudInicial() {
        return longitudInicial;
    }

    public double getLongitudFinal() {
        return longitudFinal;
    }

    public double getDistancia() {
        return distancia;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public int getDesnivelPositivo() {
        return desnivelPositivo;
    }

    public int getDesnivelNegativo() {
        return desnivelNegativo;
    }

    public double getAltitudMax() {
        return altitudMax;
    }

    public double getAltitudMin() {
        return altitudMin;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public int getNivelEsfuerzo() {
        return nivelEsfuerzo;
    }

    public int getNivelriesgo() {
        return nivelriesgo;
    }

    public int getEstadoRuta() {
        return estadoRuta;
    }

    public int getTipoterreno() {
        return tipoterreno;
    }

    public int getIndicaciones() {
        return indicaciones;
    }

    public Set<String> getTemporada() {
        return temporada;
    }

    public boolean isAccesibilidad() {
        return accesibilidad;
    }

    public boolean isRutaFamiliar() {
        return rutaFamiliar;
    }

    public String getText() {
        return text;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public String getZonaGeografica() {
        return zonaGeografica;
    }

    public double getMediaEstrellas() {
        return mediaEstrellas;
    }

    public ArrayList<PuntosPeligro> getPuntosPeligro() {
        return puntosPeligro;
    }

    public ArrayList<PuntosInteres> getPuntosInteres() {
        return puntosInteres;
    }
    
    
    
    //Metodos set
    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre_inicioruta(String nombre_inicioruta) {
        this.nombre_inicioruta = nombre_inicioruta;
    }

    public void setNombre_finalruta(String nombre_finalruta) {
        this.nombre_finalruta = nombre_finalruta;
    }

    public void setLatitudInicial(double latitudInicial) {
        this.latitudInicial = latitudInicial;
    }

    public void setLatitudFinal(double latitudFinal) {
        this.latitudFinal = latitudFinal;
    }

    public void setLongitudInicial(double longitudInicial) {
        this.longitudInicial = longitudInicial;
    }

    public void setLongitudFinal(double longitudFinal) {
        this.longitudFinal = longitudFinal;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public void setDesnivelPositivo(int desnivelPositivo) {
        this.desnivelPositivo = desnivelPositivo;
    }

    public void setDesnivelNegativo(int desnivelNegativo) {
        this.desnivelNegativo = desnivelNegativo;
    }

    public void setAltitudMax(double altitudMax) {
        this.altitudMax = altitudMax;
    }

    public void setAltitudMin(double altitudMin) {
        this.altitudMin = altitudMin;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setNivelEsfuerzo(int nivelEsfuerzo) {
        this.nivelEsfuerzo = nivelEsfuerzo;
    }

    public void setNivelriesgo(int nivelriesgo) {
        this.nivelriesgo = nivelriesgo;
    }

    public void setEstadoRuta(int estadoRuta) {
        this.estadoRuta = estadoRuta;
    }

    public void setTipoterreno(int tipoterreno) {
        this.tipoterreno = tipoterreno;
    }

    public void setIndicaciones(int indicaciones) {
        this.indicaciones = indicaciones;
    }

    public void setTemporada(Set<String> temporada) {
        this.temporada = temporada;
    }

    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public void setRutaFamiliar(boolean rutaFamiliar) {
        this.rutaFamiliar = rutaFamiliar;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public void setZonaGeografica(String zonaGeografica) {
        this.zonaGeografica = zonaGeografica;
    }

    public void setMediaEstrellas(double mediaEstrellas) {
        this.mediaEstrellas = mediaEstrellas;
    }

}
