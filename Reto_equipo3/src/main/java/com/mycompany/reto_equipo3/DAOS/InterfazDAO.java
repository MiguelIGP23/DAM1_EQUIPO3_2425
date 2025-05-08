/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import java.util.List;

/**
 *
 * @author DAM123
 * @param <T>
 */
public interface InterfazDAO<T> {
    void insertar(T obj);
    void modificar(T obj);
    List<T> listar();
    void eliminar(String email) ;
    T buscar(String email);
}
