/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Enums.Tipo;

/**
 * Clase que representa un punto de interés de una ruta
 * @author Manuel Mediavilla, JavaDoc por Hugo Fernández    
 */
public class PuntosInteres {
    private int idPuntosInteres;
    private String nombre;
    private double latitud;
    private double longitud;
    private double elevacion;
    private String caracteristicas;
    private Tipo tipo;
    private String descripcion;
    private int timestamp;
    private int rutas_idRuta;
    /**
     * Constructor por parámetros, sin incluir la id de ruta
     * @param idPuntosInteres para darle valor como parámetro al atributo "idPuntosInteres"
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param latitud para darle valor como parámetro al atributo "latitud"
     * @param longitud para darle valor como parámetro al atributo "longitud"
     * @param elevacion para darle valor como parámetro al atributo "elevacion"
     * @param caracteristicas para darle valor como parámetro al atributo "caracteristicas"
     * @param tipo para darle valor como parámetro al atributo "tipo"
     * @param descripcion para darle valor como parámetro al atributo "descripcion"
     * @param timestamp para darle valor como parámetro al atributo "timestamp"
     */
    public PuntosInteres(int idPuntosInteres, String nombre, double latitud, double longitud, double elevacion, String caracteristicas, Tipo tipo, String descripcion, int timestamp) {
        this.idPuntosInteres = idPuntosInteres;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion=elevacion;
        this.caracteristicas = caracteristicas;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.timestamp = timestamp;
    }
    /**
     * Constructor por parámetros, sirve para crear un punto de interés desde la aplicación Swing
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param latitud para darle valor como parámetro al atributo "latitud"
     * @param longitud para darle valor como parámetro al atributo "longitud"
     * @param elevacion para darle valor como parámetro al atributo "elevacion"
     * @param descripcion para darle valor como parámetro al atributo "descripcion"
     */
    public PuntosInteres(String nombre, double latitud, double longitud, double elevacion, String descripcion) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion=elevacion;
        this.descripcion = descripcion;
    }
    /**
     * Constructor por parámetros, contiene todos los atributos que no pueden ser nulos
     * @param id para darle valor como parámetro al atributo "idPuntosInteres"
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param latitud para darle valor como parámetro al atributo "latitud"
     * @param longitud para darle valor como parámetro al atributo "longitud"
     * @param elevacion para darle valor como parámetro al atributo "elevacion"
     * @param descripcion para darle valor como parámetro al atributo "descripcion"
     */
    public PuntosInteres(int id, String nombre, double latitud, double longitud, double elevacion, String descripcion) {
        this.idPuntosInteres=id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.elevacion=elevacion;
        this.descripcion = descripcion;
    }
    /**
     * Setter del atributo "idPuntosInteres"
     * @param idPuntosInteres que sirve para igualarse al atributo "idPuntosInteres" y cambiarle el valor
     */
    public void setIdPuntosInteres(int idPuntosInteres) {
        this.idPuntosInteres = idPuntosInteres;
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
     * Setter del atributo "caracteristicas"
     * @param caracteristicas que sirve para igualarse al atributo "caracteristicas" y cambiarle el valor
     */
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    /**
     * Setter del atributo "tipo"
     * @param tipo que sirve para igualarse al atributo "tipo" y cambiarle el valor
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
     * Getter del atributo "idPuntosInteres"
     * @return el valor actual del atributo "idPuntosInteres"
     */
    public int getIdPuntosInteres() {
        return idPuntosInteres;
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
     * Getter del atributo "caracteristicas"
     * @return el valor actual del atributo "caracteristicas"
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }
    /**
     * Getter del atributo "tipo"
     * @return el valor actual del atributo "tipo"
     */
    public Tipo getTipo() {
        return tipo;
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
     * Método hashCode para LinkedHashSet de PuntosInteres
     * @return int comparando el hash igualado a 7 multiplicado por 61 sumado al idPuntosInteres
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idPuntosInteres;
        return hash;
    }
    /**
     * Método equals para LinkedHashSet de PuntosInteres
     * @param obj Objeto comparado por la misma clase para ver si es igual o no
     * @return booleano si la comparación de other de idPuntosInteres por el this de idPuntosInteres, si son iguales, devuelve true, si no, false, así para comparar entre esos objetos
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
        final PuntosInteres other = (PuntosInteres) obj;
        return this.idPuntosInteres == other.idPuntosInteres;
    }
    /**
     * toString de la clase para devolver la información de esta
     * @return una cadena con la información de la clase, mostrando todos los atributos, a excepción de las IDs
     */
    @Override
    public String toString() {
        return "PuntosInteres{" + "nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + ", caracteristicas=" + caracteristicas + ", tipo=" + tipo + ", descripcion=" + descripcion + ", elevacion=" + elevacion + ", timestamp=" + timestamp + "}\n";
    } 
}
