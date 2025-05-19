/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import java.util.List;


/**
 * Interfaz DAO para todas las clases con métodos comunes entre todas las clases DAO
 * @author Miguel Inglés, JavaDoc por Hugo Fernández 
 * @param <T> objeto por defecto genérico
 */
public interface InterfazDAO<T> {
    /**
     * Método modificar genérico
     * @param obj el objeto a modificar
     */
    void modificar(T obj);
    /**
     * Método buscar genérico
     * @param email el email
     * @return el objeto genérico
     */
    T buscar(String email);
    /**
     * Método eliminar genérico
     * @param num representa el id
     * @return boolean para que se elimine ese elemnto de esa id
     */
    boolean eliminar(int num);
}
