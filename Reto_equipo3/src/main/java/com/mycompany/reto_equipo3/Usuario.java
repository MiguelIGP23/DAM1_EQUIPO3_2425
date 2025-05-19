/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Enums.Roles;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase que representa un usuario
 * @author Saúl García, JavaDoc por Hugo Fernández
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
    /**
     * Constructor por parámetros, recibe la id y todos los atributos
     * @param idUsuario para darle valor como parámetro al atributo "idUsuario"
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param apellido para darle valor como parámetro al atributo "apellido"
     * @param email para darle valor como parámetro al atributo "email"
     * @param password para darle valor como parámetro al atributo "password"
     * @param rol para darle valor como parámetro al atributo "rol"
     */
    public Usuario(int idUsuario, String nombre, String apellido, String email, String password, Roles rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    /**
     * Constructor por parámetros, recibe solo los atributos
     * @param nombre para darle valor como parámetro al atributo "nombre"
     * @param apellido para darle valor como parámetro al atributo "apellido"
     * @param email para darle valor como parámetro al atributo "email"
     * @param password para darle valor como parámetro al atributo "password"
     * @param rol para darle valor como parámetro al atributo "rol"
     */
    public Usuario(String nombre, String apellido, String email, String password, Roles rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    /**
     * Método hashCode para LinkedHashSet de Usuario
     * @return int comparando el hash igualado a 7 multiplicado por 59 sumado al email
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.email);
        return hash;
    }
    /**
     * Método equals para LinkedHashSet de Usuario
     * @param obj Objeto comparado por la misma clase para ver si es igual o no
     * @return booleano si la comparación de other de email por el this de email, si son iguales, devuelve true, si no, false, así para comparar entre esos objetos
     */
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
    /**
     * Método compareTo para comparar un Usuario de esta clase
     * @param U1 representa el objeto en parámetro para comparar
     * @return int si devuelve 0, son iguales, sino, no
     */
    @Override
    public int compareTo(Usuario U1) {
       return this.nombre.compareTo(U1.nombre);
    }
    /**
     * toString de la clase para devolver la información de esta
     * @return una cadena con la información de la clase, mostrando los atributos que se deben de mostrar
     */
    @Override
    public String toString() {
        return "Usuario: nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", rol=" + rol+"\n";
    }
    /**
     * Getter del atributo "idUsuario"
     * @return el valor actual del atributo "idUsuario"
     */
    public int getIdUsuario() {
        return idUsuario;
    }
    /**
     * Getter del atributo "nombre"
     * @return el valor actual del atributo "nombre"
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter del atributo "apellido"
     * @return el valor actual del atributo "apellido"
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Getter del atributo "email"
     * @return el valor actual del atributo "email"
     */
    public String getEmail() {
        return email;
    }
    /**
     * Getter del atributo "password"
     * @return el valor actual del atributo "password"
     */
    public String getPassword() {
        return password;
    }
    /**
     * Getter del atributo "rol"
     * @return el valor actual del atributo "rol"
     */
    public Roles getRol() {
        return rol;
    }
    /**
     * Getter del atributo "rutas"
     * @return los valores de la colección en ArrayList de Rutas actual del atributo "rutas"
     */
    public ArrayList<Rutas> getRutas() {
        return rutas;
    }
    /**
     * Setter del atributo "idUsuario"
     * @param idUsuario que sirve para igualarse al atributo "idUsuario" y cambiarle el valor
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    /**
     * Setter del atributo "nombre"
     * @param nombre que sirve para igualarse al atributo "nombre" y cambiarle el valor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Setter del atributo "apellido"
     * @param apellido que sirve para igualarse al atributo "apellido" y cambiarle el valor
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Setter del atributo "email"
     * @param email que sirve para igualarse al atributo "email" y cambiarle el valor
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Setter del atributo "password"
     * @param password que sirve para igualarse al atributo "password" y cambiarle el valor
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Setter del atributo "rol"
     * @param rol que sirve para igualarse al atributo "rol" y cambiarle el valor
     */
    public void setRol(Roles rol) {
        this.rol = rol;
    }
    /**
     * Setter del atributo "rutas"
     * @param rutas que sirve para igualarse al atributo "rol" y cambiarle el valor (ArrayList Rutas)
     */
    public void setRutas(ArrayList<Rutas> rutas) {
        this.rutas = rutas;
    }
}

