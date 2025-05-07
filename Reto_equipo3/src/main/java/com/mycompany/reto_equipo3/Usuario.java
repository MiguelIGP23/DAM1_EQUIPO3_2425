/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Enums.Roles;
import java.util.ArrayList;
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
    
    //Lista de rutas realizadas por el usuario
    ArrayList<Rutas> rutas=new ArrayList<>();
    
    //Constructor por defecto

    public Usuario() {
        
    }
    
    
   // Constructor que recibe la id y todos los atributos
    public Usuario(int idUsuario, String nombre, String apellido, String email, String password, Roles rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    // Constructor que recibe solo los atributos
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Roles getRol() {
        return rol;
    }

    public ArrayList<Rutas> getRutas() {
        return rutas;
    }
    
    //Metodos set

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public void setRutas(ArrayList<Rutas> rutas) {
        this.rutas = rutas;
    }
    
    
}

