/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Enums.Tipo;

/**
 *
 * @author DAM122
 */
public class PuntosInteres {
    private int idPuntosInteres;
    private String nombre;
    private double latitud;
    private double longitud;
    private String caracteristicas;
    private Tipo tipo;
    private String descripcion;
    private double elevacion;
    private int timestamp;
    private int rutas_idRuta;

    public void setIdPuntosInteres(int idPuntosInteres) {
        this.idPuntosInteres = idPuntosInteres;
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

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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

    public int getIdPuntosInteres() {
        return idPuntosInteres;
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

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public Tipo getTipo() {
        return tipo;
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
}
