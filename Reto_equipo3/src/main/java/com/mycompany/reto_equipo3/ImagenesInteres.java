/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

/**
 * Clase que representa las imágenes de interés de los puntos de interés de una ruta
 * @author Saúl García, JavaDoc por Hugo Fernández    
 */
public class ImagenesInteres {
    private int idimagenesinteres;
    private String url;
    private String descripcion;
    private int puntosinteres_idPuntosinteres;
    /**
     * Constructor por parámetros, sin incluir la id de los puntos de interés
     * @param idimagenesinteres para darle valor como parámetro al atributo "idimagenesinteres"
     * @param url para darle valor como parámetro al atributo "url"
     * @param descripcion para darle valor como parámetro al atributo "descripcion"
     */
    public ImagenesInteres(int idimagenesinteres, String url, String descripcion) {
        this.idimagenesinteres = idimagenesinteres;
        this.url = url;
        this.descripcion = descripcion;

    }
    /**
     * Constructor por parámetros, recibe la url y descripción de la imagen de interés
     * @param url para darle valor como parámetro al atributo "url"
     * @param descripcion para darle valor como parámetro al atributo "descripcion"
     */
    public ImagenesInteres(String url, String descripcion) {
        this.url = url;
        this.descripcion = descripcion;
    }
    /**
     * Getter del atributo "idimagenesinteres"
     * @return el valor actual del atributo "idimagenesinteres"
     */
    public int getIdimagenesinteres() {
        return idimagenesinteres;
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
     * Getter del atributo "puntosinteres_idPuntosinteres"
     * @return el valor actual del atributo "puntosinteres_idPuntosinteres"
     */
    public int getPuntosinteres_idPuntosinteres() {
        return puntosinteres_idPuntosinteres;
    }
    /**
     * Setter del atributo "idimagenesinteres"
     * @param idimagenesinteres que sirve para igualarse al atributo "idimagenesinteres" y cambiarle el valor
     */
    public void setIdimagenesinteres(int idimagenesinteres) {
        this.idimagenesinteres = idimagenesinteres;
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
    /**
     * Setter del atributo "puntosinteres_idPuntosinteres"
     * @param puntosinteres_idPuntosinteres que sirve para igualarse al atributo "puntosinteres_idPuntosinteres" y cambiarle el valor
     */
    public void setPuntosinteres_idPuntosinteres(int puntosinteres_idPuntosinteres) {
        this.puntosinteres_idPuntosinteres = puntosinteres_idPuntosinteres;
    } 
}
