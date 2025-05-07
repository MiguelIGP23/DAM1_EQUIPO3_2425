/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import java.util.Objects;

/**
 *
 * @author DAM122
 */
public class PuntosPeligro {
    private int idPuntosinteres;
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

   public PuntosPeligro(int idPuntosinteres, String nombre, double latitud, double longitud, double kilometros, int gravedad, int posicion, String descripcion, double elevacion, int timestamp, int rutas_idRuta) {
        this.idPuntosinteres = idPuntosinteres;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.kilometro = kilometros;
        this.gravedad = gravedad;
        this.posicion = posicion;
        this.descripcion = descripcion;
        this.elevacion = elevacion;
        this.timestamp = timestamp;
        this.rutas_idRuta = rutas_idRuta;
    }
    public PuntosPeligro(String nombre, double latitud, double longitud,  String descripcion) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
    }

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
        this.kilometro = kilometros;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idPuntosinteres;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.latitud) ^ (Double.doubleToLongBits(this.latitud) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.longitud) ^ (Double.doubleToLongBits(this.longitud) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.kilometro) ^ (Double.doubleToLongBits(this.kilometro) >>> 32));
        hash = 89 * hash + this.gravedad;
        hash = 89 * hash + this.posicion;
        hash = 89 * hash + Objects.hashCode(this.descripcion);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.elevacion) ^ (Double.doubleToLongBits(this.elevacion) >>> 32));
        hash = 89 * hash + this.timestamp;
        hash = 89 * hash + this.rutas_idRuta;
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
        if (this.idPuntosinteres != other.idPuntosinteres) {
            return false;
        }
        if (Double.doubleToLongBits(this.latitud) != Double.doubleToLongBits(other.latitud)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitud) != Double.doubleToLongBits(other.longitud)) {
            return false;
        }
        if (Double.doubleToLongBits(this.kilometro) != Double.doubleToLongBits(other.kilometro)) {
            return false;
        }
        if (this.gravedad != other.gravedad) {
            return false;
        }
        if (this.posicion != other.posicion) {
            return false;
        }
        if (Double.doubleToLongBits(this.elevacion) != Double.doubleToLongBits(other.elevacion)) {
            return false;
        }
        if (this.timestamp != other.timestamp) {
            return false;
        }
        if (this.rutas_idRuta != other.rutas_idRuta) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }

    
    
}
