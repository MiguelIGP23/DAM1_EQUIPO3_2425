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

    public ImagenesPeligro(int idimagenespeligro, String url, String descripcion) {
        this.idimagenespeligro = idimagenespeligro;
        this.url = url;
        this.descripcion = descripcion;
    }

    //Metodos get
    public int getIdimagenespeligro() {
        return idimagenespeligro;
    }

    public String getUrl() {
        return url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    //Metodos set
    public void setIdimagenespeligro(int idimagenespeligro) {
        this.idimagenespeligro = idimagenespeligro;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }   
}
