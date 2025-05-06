/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

/**
 *
 * @author DAM123
 */
public class ImagenesPeligro {
    private int idimagenespeligro;
    private String url;
    private String descripcion;
    private int puntospeligro_idPuntospeligro;

    public void setIdimagenespeligro(int idimagenespeligro) {
        this.idimagenespeligro = idimagenespeligro;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPuntospeligro_idPuntospeligro(int puntospeligro_idPuntospeligro) {
        this.puntospeligro_idPuntospeligro = puntospeligro_idPuntospeligro;
    }

    public int getIdimagenespeligro() {
        return idimagenespeligro;
    }

    public String getUrl() {
        return url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPuntosinteres_idPuntosinteres() {
        return puntospeligro_idPuntospeligro;
    }

    public ImagenesPeligro(int idimagenespeligro, String url, String descripcion, int puntospeligro_idPuntospeligro) {
        this.idimagenespeligro = idimagenespeligro;
        this.url = url;
        this.descripcion = descripcion;
        this.puntospeligro_idPuntospeligro = puntospeligro_idPuntospeligro;
    }
}
