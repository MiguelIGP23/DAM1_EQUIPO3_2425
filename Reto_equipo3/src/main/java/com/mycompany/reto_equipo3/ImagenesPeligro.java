/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

/**
 * Clase que representa las imágenes de peligro de los puntos de peligro de una ruta
 * @author Manuel Mediavilla, JavaDoc por Hugo Fernández  
 */
public class ImagenesPeligro {
    private int idimagenespeligro;
    private String url;
    private String descripcion;
    /**
     * Constructor por parámetros, incluye todos los atributos
     * @param idimagenespeligro para darle valor como parámetro al atributo "idimagenespeligro"
     * @param url para darle valor como parámetro al atributo "url"
     * @param descripcion para darle valor como parámetro al atributo "descripcion"
     */
    public ImagenesPeligro(int idimagenespeligro, String url, String descripcion) {
        this.idimagenespeligro = idimagenespeligro;
        this.url = url;
        this.descripcion = descripcion;
    }
    /**
     * Constructor por parámetros, sin incluir la id de los puntos de peligro
     * @param url para darle valor como parámetro al atributo "url"
     * @param descripcion para darle valor como parámetro al atributo "descripcion"
     */
    public ImagenesPeligro(String url, String descripcion) {
        this.url = url;
        this.descripcion = descripcion;
    }
    /**
     * Getter del atributo "idimagenespeligro"
     * @return el valor actual del atributo "idimagenespeligro"
     */
    public int getIdimagenespeligro() {
        return idimagenespeligro;
    }
    /**
     * Getter del atributo "url"
     * @return el valor actual del atributo "url"
     */
    public String getUrl() {
        return url;
    }
    /**
     * Getter del atributo "descripcion"
     * @return el valor actual del atributo "descripcion"
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Setter del atributo "idimagenespeligro"
     * @param idimagenespeligro que sirve para igualarse al atributo "idimagenespeligro" y cambiarle el valor
     */
    public void setIdimagenespeligro(int idimagenespeligro) {
        this.idimagenespeligro = idimagenespeligro;
    }
    /**
     * Setter del atributo "url"
     * @param url que sirve para igualarse al atributo "url" y cambiarle el valor
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Setter del atributo "descripcion"
     * @param descripcion que sirve para igualarse al atributo "descripcion" y cambiarle el valor
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }   
}
