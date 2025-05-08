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
    private int idPuntospeligro;
    private String nombre;
    private double latitud;
    private double longitud;
    private double kilometro;
    private int gravedad;
    private int posicion;
    private String descripcion;
    private double elevacion;
    private int timestamp;
    private int rutas_idRuta;

   public PuntosPeligro(int idPuntospeligro, String nombre, double latitud, double longitud, double kilometro, int gravedad, int posicion, String descripcion, double elevacion, int timestamp, int rutas_idRuta) {
        this.idPuntospeligro = idPuntospeligro;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.kilometro = kilometro;
        this.gravedad = gravedad;
        this.posicion = posicion;
        this.descripcion = descripcion;
        this.elevacion = elevacion;
        this.timestamp = timestamp;
        this.rutas_idRuta = rutas_idRuta;
    }
    public PuntosPeligro(String nombre, double latitud, double longitud, String descripcion) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
    }

    //Metodos set
    public void setIdPuntosinteres(int idPuntosinteres) {
        this.idPuntospeligro = idPuntosinteres;
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

    public void setKilometro(double kilometro) {
        this.kilometro = kilometro;
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

    public void setIdPuntospeligro(int idPuntospeligro) {
        this.idPuntospeligro = idPuntospeligro;
    }

    //Metodos get
    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getKilometro() {
        return kilometro;
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

    public int getIdPuntospeligro() {
        return idPuntospeligro;
    }

    //Metodos equals y hashcode para el LinkedHashSet<PuntosPeligro>
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idPuntospeligro;
        return hash;
    }

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
}
