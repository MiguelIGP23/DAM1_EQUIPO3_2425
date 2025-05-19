/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

/**
 * Clase que representa un punto de peligro de una ruta
 * @author Manuel Mediavilla, JavaDoc por Hugo Fernández   
 */
public class PuntosPeligro {
    private int idPuntospeligro;
    private String nombre;
    private double latitud;
    private double longitud;
    private double elevacion;
    private double kilometro;
    private int gravedad;
    private int posicion;
    private String descripcion;
    private int timestamp;
    private int rutas_idRuta;
    /**
     * Constructor por parámetros, incluye todos los atributos
     * @param idPuntospeligro para darle valor como parámetro al atributo "idPuntospeligro"
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param latitud para darle valor como parámetro al atributo "latitud"
     * @param longitud para darle valor como parámetro al atributo "longitud"
     * @param elevacion para darle valor como parámetro al atributo "elevacion"
     * @param kilometro para darle valor como parámetro al atributo "kilometro"
     * @param gravedad para darle valor como parámetro al atributo "gravedad"
     * @param posicion para darle valor como parámetro al atributo "posicion"
     * @param descripcion para darle valor como parámetro al atributo "descripcion"
     * @param timestamp para darle valor como parámetro al atributo "timestamp"
     * @param rutas_idRuta para darle valor como parámetro al atributo "rutas_idRuta"
     */
   public PuntosPeligro(int idPuntospeligro, String nombre, double latitud, double longitud, double elevacion, double kilometro, int gravedad, int posicion, String descripcion, int timestamp, int rutas_idRuta) {
        this.idPuntospeligro = idPuntospeligro;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion=elevacion;
        this.kilometro = kilometro;
        this.gravedad = gravedad;
        this.posicion = posicion;
        this.descripcion = descripcion;
        this.timestamp = timestamp;
        this.rutas_idRuta = rutas_idRuta;
    }
    /**
     * Constructor por parámetros, sirve para crear un punto de peligro desde la aplicación Swing
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param latitud para darle valor como parámetro al atributo "latitud"
     * @param longitud para darle valor como parámetro al atributo "longitud"
     * @param elevacion para darle valor como parámetro al atributo "elevacion"
     * @param descripcion para darle valor como parámetro al atributo "descripcion"
     */
    public PuntosPeligro(String nombre, double latitud, double longitud, double elevacion, String descripcion) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion=elevacion;
        this.descripcion = descripcion;
    }
    /**
     * Constructor por parámetros, contiene todos los atributos que no pueden ser nulos
     * @param id para darle valor como parámetro al atributo "idPuntospeligro"
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param latitud para darle valor como parámetro al atributo "latitud"
     * @param longitud para darle valor como parámetro al atributo "longitud"
     * @param elevacion para darle valor como parámetro al atributo "elevacion"
     * @param descripcion para darle valor como parámetro al atributo "descripcion"
     */
    public PuntosPeligro(int id, String nombre, double latitud, double longitud, double elevacion, String descripcion) {
        this.idPuntospeligro=id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion=elevacion;
        this.descripcion = descripcion;
    }
    /**
     * Setter del atributo "idPuntospeligro"
     * @param idPuntosinteres que sirve para igualarse al atributo "idPuntospeligro" y cambiarle el valor
     */
    public void setIdPuntosinteres(int idPuntosinteres) {
        this.idPuntospeligro = idPuntosinteres;
    }
    /**
     * Setter del atributo "nombre"
     * @param nombre que sirve para igualarse al atributo "nombre" y cambiarle el valor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Setter del atributo "latitud"
     * @param latitud que sirve para igualarse al atributo "latitud" y cambiarle el valor
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    /**
     * Setter del atributo "longitud"
     * @param longitud que sirve para igualarse al atributo "longitud" y cambiarle el valor
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    /**
     * Setter del atributo "kilometro"
     * @param kilometro que sirve para igualarse al atributo "kilometro" y cambiarle el valor
     */
    public void setKilometro(double kilometro) {
        this.kilometro = kilometro;
    }
    /**
     * Setter del atributo "gravedad"
     * @param gravedad que sirve para igualarse al atributo "gravedad" y cambiarle el valor
     */
    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }
    /**
     * Setter del atributo "posicion"
     * @param posicion que sirve para igualarse al atributo "posicion" y cambiarle el valor
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    /**
     * Setter del atributo "descripcion"
     * @param descripcion que sirve para igualarse al atributo "descripcion" y cambiarle el valor
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Setter del atributo "elevacion"
     * @param elevacion que sirve para igualarse al atributo "elevacion" y cambiarle el valor
     */
    public void setElevacion(double elevacion) {
        this.elevacion = elevacion;
    }
    /**
     * Setter del atributo "timestamp"
     * @param timestamp que sirve para igualarse al atributo "timestamp" y cambiarle el valor
     */
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
    /**
     * Setter del atributo "rutas_idRuta"
     * @param rutas_idRuta que sirve para igualarse al atributo "rutas_idRuta" y cambiarle el valor
     */
    public void setRutas_idRuta(int rutas_idRuta) {
        this.rutas_idRuta = rutas_idRuta;
    }
    /**
     * Setter del atributo "idPuntospeligro"
     * @param idPuntospeligro que sirve para igualarse al atributo "idPuntospeligro" y cambiarle el valor
     */
    public void setIdPuntospeligro(int idPuntospeligro) {
        this.idPuntospeligro = idPuntospeligro;
    }
    /**
     * Getter del atributo "nombre"
     * @return el valor actual del atributo "nombre"
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter del atributo "latitud"
     * @return el valor actual del atributo "latitud"
     */
    public double getLatitud() {
        return latitud;
    }
    /**
     * Getter del atributo "longitud"
     * @return el valor actual del atributo "longitud"
     */
    public double getLongitud() {
        return longitud;
    }
    /**
     * Getter del atributo "kilometro"
     * @return el valor actual del atributo "kilometro"
     */
    public double getKilometro() {
        return kilometro;
    }
    /**
     * Getter del atributo "gravedad"
     * @return el valor actual del atributo "gravedad"
     */
    public int getGravedad() {
        return gravedad;
    }
    /**
     * Getter del atributo "posicion"
     * @return el valor actual del atributo "posicion"
     */
    public int getPosicion() {
        return posicion;
    }
    /**
     * Getter del atributo "descripcion"
     * @return el valor actual del atributo "descripcion"
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Getter del atributo "elevacion"
     * @return el valor actual del atributo "elevacion"
     */
    public double getElevacion() {
        return elevacion;
    }
    /**
     * Getter del atributo "timestamp"
     * @return el valor actual del atributo "timestamp"
     */
    public int getTimestamp() {
        return timestamp;
    }
    /**
     * Getter del atributo "rutas_idRuta"
     * @return el valor actual del atributo "rutas_idRuta"
     */
    public int getRutas_idRuta() {
        return rutas_idRuta;
    }
    /**
     * Getter del atributo "idPuntospeligro"
     * @return el valor actual del atributo "idPuntospeligro"
     */
    public int getIdPuntospeligro() {
        return idPuntospeligro;
    }

    /**
     * Método hashCode para LinkedHashSet de PuntosPeligro
     * @return int comparando el hash igualado a 7 multiplicado por 23 sumado al idPuntospeligro
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idPuntospeligro;
        return hash;
    }
    /**
     * Método equals para LinkedHashSet de PuntosPeligro
     * @param obj Objeto comparado por la misma clase para ver si es igual o no
     * @return booleano si la comparación de other de idPuntospeligro por el this de idPuntospeligro, si son iguales, devuelve true, si no, false, así para comparar entre esos objetos
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PuntosPeligro other = (PuntosPeligro) obj;
        return this.idPuntospeligro == other.idPuntospeligro;
    }
    /**
     * toString de la clase para devolver la información de esta
     * @return una cadena con la información de la clase, a excepción de idPuntospeligro
     */
    @Override
    public String toString() {
        return "PuntosPeligro{" + "nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + ", kilometro=" + kilometro + ", gravedad=" + gravedad + ", posicion=" + posicion + ", descripcion=" + descripcion + ", elevacion=" + elevacion + ", timestamp=" + timestamp + ", rutas_idRuta=" + rutas_idRuta + "\n";
    }
    
    
}
