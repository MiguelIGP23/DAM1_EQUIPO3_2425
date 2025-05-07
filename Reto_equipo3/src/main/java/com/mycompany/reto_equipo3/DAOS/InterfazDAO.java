/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DAM123
 */
public interface InterfazDAO<T> {
    
    void insertar(T obj) throws SQLException;
    void modificar(T obj) throws SQLException;
    List<T> listar() throws SQLException;
    void eliminar(int id) throws SQLException;
    T porID(int id) throws SQLException;
}
