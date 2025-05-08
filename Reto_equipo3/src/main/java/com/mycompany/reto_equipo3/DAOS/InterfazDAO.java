/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;


/**
 *
 * @author DAM123
 * @param <T>
 */
public interface InterfazDAO<T> {
    void modificar(T obj);
    void eliminar(String email) ;
    T buscar(String email);
}
