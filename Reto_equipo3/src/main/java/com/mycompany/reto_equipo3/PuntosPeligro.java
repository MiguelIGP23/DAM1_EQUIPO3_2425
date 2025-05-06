/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

/**
 *
 * @author DAM122
 */
public class PuntosPeligro {
    private int idPuntosinteres;
    private String nombre;
    private double latitud;
    private double longitud;
    private double kilometros;
    private int gravedad;
    private int posicion;
    private String descripcion;
    private double elevacion;
    private int timestamp;
    private int rutas_idRuta;

    public void setIdPuntosinteres(int idPuntosinteres) {
        this.idPuntosinteres = idPuntosinteres;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setElevacion(double elevacion) {
        this.elevacion = elevacion;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setRutas_idRuta(int rutas_idRuta) {
        this.rutas_idRuta = rutas_idRuta;
    }

    public int getIdPuntosinteres() {
        return idPuntosinteres;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getKilometros() {
        return kilometros;
    }

    public int getGravedad() {
        return gravedad;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getElevacion() {
        return elevacion;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getRutas_idRuta() {
        return rutas_idRuta;
    }

    public PuntosPeligro(int idPuntosinteres, String nombre, double latitud, double longitud, double kilometros, int gravedad, int posicion, String descripcion, double elevacion, int timestamp, int rutas_idRuta) {
        this.idPuntosinteres = idPuntosinteres;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.kilometros = kilometros;
        this.gravedad = gravedad;
        this.posicion = posicion;
        this.descripcion = descripcion;
        this.elevacion = elevacion;
        this.timestamp = timestamp;
        this.rutas_idRuta = rutas_idRuta;
    }
}
