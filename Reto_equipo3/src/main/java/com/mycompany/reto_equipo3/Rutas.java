/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Enums.Clasificacion;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Clase que representa una ruta
 * @author Miguel Inglés, JavaDoc por Hugo Fernández
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
    private boolean estadoRuta;
    private int tipoterreno;
    private int indicaciones;   //indicar valores de 1 a 5
    private Set<String> temporada;
    private boolean accesibilidad;
    private boolean rutaFamiliar;
    private String archivoGPX;
    private String recomendaciones;
    private String zonaGeografica;
    private double mediaEstrellas;

    private List<PuntosPeligro> puntosPeligro;
    private List<PuntosInteres> puntosInteres;

    /**
     * Constructor por parámetros, con id y solo atributos obligatorios como parametros
     * @param idRuta para darle valor como parámetro al atributo "idRuta"
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param nombre_inicioruta para darle valor como parámetro al atributo "nombre_inicioruta"
     * @param nombre_finalruta para darle valor como parámetro al atributo "nombre_finalruta"
     * @param latitudInicial para darle valor como parámetro al atributo "latitudInicial"
     * @param latitudFinal para darle valor como parámetro al atributo "latitudFinal"
     * @param longitudInicial para darle valor como parámetro al atributo "longitudInicial"
     * @param longitudFinal para darle valor como parámetro al atributo "longitudFinal"
     * @param distancia para darle valor como parámetro al atributo "distancia"
     * @param duracion para darle valor como parámetro al atributo "duracion"
     */
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
        this.puntosPeligro = new ArrayList<>();
        this.puntosInteres = new ArrayList<>();
    }

    /**
     * Constructor por parámetros, sin id y solo con atributos obligatorios como parametros
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param nombre_inicioruta para darle valor como parámetro al atributo "nombre_inicioruta"
     * @param nombre_finalruta para darle valor como parámetro al atributo "nombre_finalruta"
     * @param latitudInicial para darle valor como parámetro al atributo "latitudInicial"
     * @param latitudFinal para darle valor como parámetro al atributo "latitudFinal"
     * @param longitudInicial para darle valor como parámetro al atributo "longitudInicial"
     * @param longitudFinal para darle valor como parámetro al atributo "longitudFinal"
     * @param distancia para darle valor como parámetro al atributo "distancia"
     * @param duracion para darle valor como parámetro al atributo "duracion"
     */
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
        this.puntosPeligro = new ArrayList<>();
        this.puntosInteres = new ArrayList<>();
    }

    /**
     * Constructor por parámetros, incluye todos los atributos
     * @param idRuta para darle valor como parámetro al atributo "idRuta"
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param nombre_inicioruta para darle valor como parámetro al atributo "nombre_inicioruta"
     * @param nombre_finalruta para darle valor como parámetro al atributo "nombre_finalruta"
     * @param latitudInicial para darle valor como parámetro al atributo "latitudInicial"
     * @param latitudFinal para darle valor como parámetro al atributo "latitudFinal"
     * @param longitudInicial para darle valor como parámetro al atributo "longitudInicial"
     * @param longitudFinal para darle valor como parámetro al atributo "longitudFinal"
     * @param distancia para darle valor como parámetro al atributo "distancia"
     * @param duracion para darle valor como parámetro al atributo "duracion"
     * @param desnivelPositivo para darle valor como parámetro al atributo "desnivelPositivo"
     * @param desnivelNegativo para darle valor como parámetro al atributo "desnivelNegativo"
     * @param altitudMax para darle valor como parámetro al atributo "altitudMax"
     * @param altitudMin para darle valor como parámetro al atributo "altitudMin"
     * @param clasificacion para darle valor como parámetro al atributo "clasificacion"
     * @param nivelEsfuerzo para darle valor como parámetro al atributo "nivelEsfuerzo"
     * @param nivelRiesgo para darle valor como parámetro al atributo "nivelRiesgo"
     * @param estadoRuta para darle valor como parámetro al atributo "estadoRuta"
     * @param tipoterreno para darle valor como parámetro al atributo "tipoterreno"
     * @param indicaciones para darle valor como parámetro al atributo "indicaciones"
     * @param temporada para darle valor como parámetro al atributo "temporada"
     * @param accesibilidad para darle valor como parámetro al atributo "accesibilidad"
     * @param rutaFamiliar para darle valor como parámetro al atributo "rutaFamiliar"
     * @param archivoGPX para darle valor como parámetro al atributo "archivoGPX"
     * @param recomendaciones para darle valor como parámetro al atributo "recomendaciones"
     * @param zonaGeografica para darle valor como parámetro al atributo "zonaGeografica"
     * @param mediaEstrellas para darle valor como parámetro al atributo "mediaEstrellas"
     */
    public Rutas(int idRuta, String nombre, String nombre_inicioruta, String nombre_finalruta, double latitudInicial, double latitudFinal,
            double longitudInicial, double longitudFinal, double distancia, LocalTime duracion, int desnivelPositivo, int desnivelNegativo,
            double altitudMax, double altitudMin, Clasificacion clasificacion, int nivelEsfuerzo, int nivelRiesgo, boolean estadoRuta, int tipoterreno,
            int indicaciones, Set<String> temporada, boolean accesibilidad, boolean rutaFamiliar, String archivoGPX, String recomendaciones, 
            String zonaGeografica, double mediaEstrellas) {
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
        this.nivelEsfuerzo=nivelEsfuerzo;
        this.nivelriesgo=nivelRiesgo;
        this.estadoRuta = estadoRuta;
        this.tipoterreno = tipoterreno;
        this.indicaciones = indicaciones;
        this.temporada = temporada;
        this.accesibilidad = accesibilidad;
        this.rutaFamiliar = rutaFamiliar;
        this.archivoGPX = archivoGPX;
        this.recomendaciones = recomendaciones;
        this.zonaGeografica = zonaGeografica;
        this.mediaEstrellas=mediaEstrellas;
    }
    /**
     * Getter del atributo "idRuta"
     * @return el valor actual del atributo "idRuta"
     */
    public int getIdRuta() {
        return idRuta;
    }
    /**
     * Getter del atributo "nombre"
     * @return el valor actual del atributo "nombre"
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter del atributo "nombre_inicioruta"
     * @return el valor actual del atributo "nombre_inicioruta"
     */
    public String getNombre_inicioruta() {
        return nombre_inicioruta;
    }
    /**
     * Getter del atributo "nombre_finalruta"
     * @return el valor actual del atributo "nombre_finalruta"
     */
    public String getNombre_finalruta() {
        return nombre_finalruta;
    }
    /**
     * Getter del atributo "latitudInicial"
     * @return el valor actual del atributo "latitudInicial"
     */
    public double getLatitudInicial() {
        return latitudInicial;
    }
    /**
     * Getter del atributo "latitudFinal"
     * @return el valor actual del atributo "latitudFinal"
     */
    public double getLatitudFinal() {
        return latitudFinal;
    }
    /**
     * Getter del atributo "longitudInicial"
     * @return el valor actual del atributo "longitudInicial"
     */
    public double getLongitudInicial() {
        return longitudInicial;
    }
    /**
     * Getter del atributo "longitudFinal"
     * @return el valor actual del atributo "longitudFinal"
     */
    public double getLongitudFinal() {
        return longitudFinal;
    }
    /**
     * Getter del atributo "distancia"
     * @return el valor actual del atributo "distancia"
     */
    public double getDistancia() {
        return distancia;
    }
    /**
     * Getter del atributo "duracion"
     * @return el valor actual del atributo "duracion"
     */
    public LocalTime getDuracion() {
        return duracion;
    }
    /**
     * Getter del atributo "desnivelPositivo"
     * @return el valor actual del atributo "desnivelPositivo"
     */
    public int getDesnivelPositivo() {
        return desnivelPositivo;
    }
    /**
     * Getter del atributo "desnivelNegativo"
     * @return el valor actual del atributo "desnivelNegativo"
     */
    public int getDesnivelNegativo() {
        return desnivelNegativo;
    }
    /**
     * Getter del atributo "altitudMax"
     * @return el valor actual del atributo "altitudMax"
     */
    public double getAltitudMax() {
        return altitudMax;
    }
    /**
     * Getter del atributo "altitudMin"
     * @return el valor actual del atributo "altitudMin"
     */
    public double getAltitudMin() {
        return altitudMin;
    }
    /**
     * Getter del atributo "clasificacion"
     * @return el valor actual del atributo "clasificacion"
     */
    public Clasificacion getClasificacion() {
        return clasificacion;
    }
    /**
     * Getter del atributo "nivelEsfuerzo"
     * @return el valor actual del atributo "nivelEsfuerzo"
     */
    public int getNivelEsfuerzo() {
        return nivelEsfuerzo;
    }
    /**
     * Getter del atributo "nivelriesgo"
     * @return el valor actual del atributo "nivelriesgo"
     */
    public int getNivelriesgo() {
        return nivelriesgo;
    }
    /**
     * Getter del atributo "estadoRuta"
     * @return el valor actual del atributo "estadoRuta"
     */
    public boolean getEstadoRuta() {
        return estadoRuta;
    }
    /**
     * Getter del atributo "tipoterreno"
     * @return el valor actual del atributo "tipoterreno"
     */
    public int getTipoterreno() {
        return tipoterreno;
    }
    /**
     * Getter del atributo "indicaciones"
     * @return el valor actual del atributo "indicaciones"
     */
    public int getIndicaciones() {
        return indicaciones;
    }
    /**
     * Getter del atributo "temporada"
     * @return los valores actuales en una colección de tipo Set String del atributo "temporada"
     */
    public Set<String> getTemporada() {
        return temporada;
    }
    /**
     * Getter del atributo "accesibilidad"
     * @return el valor actual (true/false) del atributo "accesibilidad"
     */
    public boolean isAccesibilidad() {
        return accesibilidad;
    }
    /**
     * Getter del atributo "rutaFamiliar"
     * @return el valor actual (true/false) del atributo "accesibilidad"
     */
    public boolean isRutaFamiliar() {
        return rutaFamiliar;
    }
    /**
     * Getter del atributo "archivoGPX"
     * @return el valor actual del atributo "archivoGPX"
     */
    public String getText() {
        return archivoGPX;
    }
    /**
     * Getter del atributo "recomendaciones"
     * @return el valor actual del atributo "recomendaciones"
     */
    public String getRecomendaciones() {
        return recomendaciones;
    }
    /**
     * Getter del atributo "zonaGeografica"
     * @return el valor actual del atributo "zonaGeografica"
     */
    public String getZonaGeografica() {
        return zonaGeografica;
    }
    /**
     * Getter del atributo "mediaEstrellas"
     * @return el valor actual del atributo "mediaEstrellas"
     */
    public double getMediaEstrellas() {
        return mediaEstrellas;
    }
    /**
     * Getter del atributo "puntosPeligro"
     * @return los valores actuales en una colección de tipo List PuntosPeligro del atributo "puntosPeligro"
     */
    public List<PuntosPeligro> getPuntosPeligro() {
        return puntosPeligro;
    }
    /**
     * Getter del atributo "puntosInteres"
     * @return los valores actuales en una colección de tipo List PuntosPeligro del atributo "puntosInteres"
     */
    public List<PuntosInteres> getPuntosInteres() {
        return puntosInteres;
    }
    /**
     * Getter del atributo "estadoRuta"
     * @return el valor actual (true/false) del atributo "estadoRuta"
     */
    public boolean isEstadoRuta() {
        return estadoRuta;
    }
    /**
     * Getter del atributo "archivoGPX"
     * @return el valor actual del atributo "archivoGPX"
     */
    public String getArchivoGPX() {
        return archivoGPX;
    }
    /**
     * Setter del atributo "idRuta"
     * @param idRuta que sirve para igualarse al atributo "idRuta" y cambiarle el valor
     */
    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }
    /**
     * Setter del atributo "nombre"
     * @param nombre que sirve para igualarse al atributo "nombre" y cambiarle el valor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Setter del atributo "nombre_inicioruta"
     * @param nombre_inicioruta que sirve para igualarse al atributo "nombre_inicioruta" y cambiarle el valor
     */
    public void setNombre_inicioruta(String nombre_inicioruta) {
        this.nombre_inicioruta = nombre_inicioruta;
    }
    /**
     * Setter del atributo "nombre_finalruta"
     * @param nombre_finalruta que sirve para igualarse al atributo "nombre_finalruta" y cambiarle el valor
     */
    public void setNombre_finalruta(String nombre_finalruta) {
        this.nombre_finalruta = nombre_finalruta;
    }
    /**
     * Setter del atributo "latitudInicial"
     * @param latitudInicial que sirve para igualarse al atributo "latitudInicial" y cambiarle el valor
     */
    public void setLatitudInicial(double latitudInicial) {
        this.latitudInicial = latitudInicial;
    }
    /**
     * Setter del atributo "latitudFinal"
     * @param latitudFinal que sirve para igualarse al atributo "latitudFinal" y cambiarle el valor
     */
    public void setLatitudFinal(double latitudFinal) {
        this.latitudFinal = latitudFinal;
    }
    /**
     * Setter del atributo "longitudInicial"
     * @param longitudInicial que sirve para igualarse al atributo "longitudInicial" y cambiarle el valor
     */
    public void setLongitudInicial(double longitudInicial) {
        this.longitudInicial = longitudInicial;
    }
    /**
     * Setter del atributo "longitudFinal"
     * @param longitudFinal que sirve para igualarse al atributo "longitudFinal" y cambiarle el valor
     */
    public void setLongitudFinal(double longitudFinal) {
        this.longitudFinal = longitudFinal;
    }
    /**
     * Setter del atributo "distancia"
     * @param distancia que sirve para igualarse al atributo "distancia" y cambiarle el valor
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    /**
     * Setter del atributo "duracion"
     * @param duracion que sirve para igualarse al atributo "duracion" y cambiarle el valor
     */
    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }
    /**
     * Setter del atributo "desnivelPositivo"
     * @param desnivelPositivo que sirve para igualarse al atributo "desnivelPositivo" y cambiarle el valor
     */
    public void setDesnivelPositivo(int desnivelPositivo) {
        this.desnivelPositivo = desnivelPositivo;
    }
    /**
     * Setter del atributo "desnivelNegativo"
     * @param desnivelNegativo que sirve para igualarse al atributo "desnivelNegativo" y cambiarle el valor
     */
    public void setDesnivelNegativo(int desnivelNegativo) {
        this.desnivelNegativo = desnivelNegativo;
    }
    /**
     * Setter del atributo "altitudMax"
     * @param altitudMax que sirve para igualarse al atributo "altitudMax" y cambiarle el valor
     */
    public void setAltitudMax(double altitudMax) {
        this.altitudMax = altitudMax;
    }
    /**
     * Setter del atributo "altitudMin"
     * @param altitudMin que sirve para igualarse al atributo "altitudMin" y cambiarle el valor
     */
    public void setAltitudMin(double altitudMin) {
        this.altitudMin = altitudMin;
    }
    /**
     * Setter del atributo "clasificacion"
     * @param clasificacion que sirve para igualarse al atributo "clasificacion" y cambiarle el valor
     */
    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
    /**
     * Setter del atributo "nivelEsfuerzo"
     * @param nivelEsfuerzo que sirve para igualarse al atributo "nivelEsfuerzo" y cambiarle el valor
     */
    public void setNivelEsfuerzo(int nivelEsfuerzo) {
        this.nivelEsfuerzo = nivelEsfuerzo;
    }
    /**
     * Setter del atributo "nivelriesgo"
     * @param nivelriesgo que sirve para igualarse al atributo "nivelriesgo" y cambiarle el valor
     */
    public void setNivelriesgo(int nivelriesgo) {
        this.nivelriesgo = nivelriesgo;
    }
    /**
     * Setter del atributo "estadoRuta"
     * @param estadoRuta que sirve para igualarse al atributo "estadoRuta" y cambiarle el valor (true/false)
     */
    public void setEstadoRuta(boolean estadoRuta) {
        this.estadoRuta = estadoRuta;
    }
    /**
     * Setter del atributo "tipoterreno"
     * @param tipoterreno que sirve para igualarse al atributo "tipoterreno" y cambiarle el valor
     */
    public void setTipoterreno(int tipoterreno) {
        this.tipoterreno = tipoterreno;
    }
    /**
     * Setter del atributo "indicaciones"
     * @param indicaciones que sirve para igualarse al atributo "indicaciones" y cambiarle el valor
     */
    public void setIndicaciones(int indicaciones) {
        this.indicaciones = indicaciones;
    }
    /**
     * Setter del atributo "temporada"
     * @param temporada que sirve para igualarse al atributo "temporada" y cambiarle el valor (Set String)
     */
    public void setTemporada(Set<String> temporada) {
        this.temporada = temporada;
    }
    /**
     * Setter del atributo "accesibilidad"
     * @param accesibilidad que sirve para igualarse al atributo "accesibilidad" y cambiarle el valor (true/false)
     */
    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }
    /**
     * Setter del atributo "rutaFamiliar"
     * @param rutaFamiliar que sirve para igualarse al atributo "rutaFamiliar" y cambiarle el valor (true/false)
     */
    public void setRutaFamiliar(boolean rutaFamiliar) {
        this.rutaFamiliar = rutaFamiliar;
    }
    /**
     * Setter del atributo "text"
     * @param text que sirve para igualarse al atributo "text" y cambiarle el valor
     */
    public void setText(String text) {
        this.archivoGPX = text;
    }
    /**
     * Setter del atributo "recomendaciones"
     * @param recomendaciones que sirve para igualarse al atributo "recomendaciones" y cambiarle el valor
     */
    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
    /**
     * Setter del atributo "zonaGeografica"
     * @param zonaGeografica que sirve para igualarse al atributo "zonaGeografica" y cambiarle el valor
     */
    public void setZonaGeografica(String zonaGeografica) {
        this.zonaGeografica = zonaGeografica;
    }
    /**
     * Setter del atributo "mediaEstrellas"
     * @param mediaEstrellas que sirve para igualarse al atributo "mediaEstrellas" y cambiarle el valor
     */
    public void setMediaEstrellas(double mediaEstrellas) {
        this.mediaEstrellas = mediaEstrellas;
    }
    /**
     * Setter del atributo "archivoGPX"
     * @param archivoGPX que sirve para igualarse al atributo "archivoGPX" y cambiarle el valor
     */
    public void setArchivoGPX(String archivoGPX) {
        this.archivoGPX = archivoGPX;
    }
    /**
     * toString de la clase para devolver la información de esta
     * @return una cadena con la información de la clase, mostrando los atributos que se deben de mostrar
     */
    @Override
    public String toString() {
        return "Rutas{" + "nombre=" + nombre + ", nombre_inicioruta=" + nombre_inicioruta + ", nombre_finalruta=" + nombre_finalruta + ", latitudInicial=" + latitudInicial + ", latitudFinal=" + latitudFinal + ", longitudInicial=" + longitudInicial + ", longitudFinal=" + longitudFinal + ", distancia=" + distancia + ", duracion=" + duracion +", nivel riesgo= "+nivelriesgo+", nivel esfuerzo="+nivelEsfuerzo+"}\n";
    } 
}
