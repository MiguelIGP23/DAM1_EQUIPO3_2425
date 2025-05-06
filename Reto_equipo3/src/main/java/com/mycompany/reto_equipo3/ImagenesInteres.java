/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

/**
 *
 * @author DAM122
 */
public class ImagenesInteres {
    private int idimagenesinteres;
    private String url;
    private String descripcion;
    private int puntosinteres_idPuntosinteres;

    public void setIdimagenesinteres(int idimagenesinteres) {
        this.idimagenesinteres = idimagenesinteres;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPuntosinteres_idPuntosinteres(int puntosinteres_idPuntosinteres) {
        this.puntosinteres_idPuntosinteres = puntosinteres_idPuntosinteres;
    }

    public int getIdimagenesinteres() {
        return idimagenesinteres;
    }

    public String getUrl() {
        return url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPuntosinteres_idPuntosinteres() {
        return puntosinteres_idPuntosinteres;
    }

    public ImagenesInteres(int idimagenesinteres, String url, String descripcion, int puntosinteres_idPuntosinteres) {
        this.idimagenesinteres = idimagenesinteres;
        this.url = url;
        this.descripcion = descripcion;
        this.puntosinteres_idPuntosinteres = puntosinteres_idPuntosinteres;
    }
}
