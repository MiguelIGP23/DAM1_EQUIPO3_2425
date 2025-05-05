/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Enums.Roles;
import java.util.Objects;

/**
 *
 * @author DAM121
 */
public class Usuario implements Comparable<Usuario>{
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Roles rol;

    public Usuario(int idUsuario, String nombre, String apellido, String email, String password, Roles rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    
    public Usuario(String nombre, String apellido, String email, String password, Roles rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.email, other.email);
    }
    @Override
    public int compareTo(Usuario U1) {
       return this.nombre.compareTo(U1.nombre);
    }
    @Override
    public String toString() {
        return "Usuario: nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", password=" + password + ", rol=" + rol;
    }
}
