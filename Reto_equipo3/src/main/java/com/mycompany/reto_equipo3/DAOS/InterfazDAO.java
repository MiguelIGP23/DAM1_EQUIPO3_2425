/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

/**
 *
 * @author DAM123
 */
public interface InterfazDAO<T> {
    
    public void crear();
    public void modificar();
    public void listar();
    public void eliminar();
    public void porID();
}
