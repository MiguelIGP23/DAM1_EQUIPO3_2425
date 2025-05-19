/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase con la función de dar acceso a la base de datos a otras clases y sólo crear una sesión
 * @author Miguel Inglés, JavaDoc por Hugo Fernández  
 */
public class AccesoABaseDatos {
    
    //Atributo de la conexion
    private static Connection conn = null;

    //Definimos las constantes
    private static final String BD = "mydb";                                    //"mydb"
    private static final String USUARIO = "root";                               //"equipo3"
    private static final String CLAVE = "mysql";                                //"Mysql2024!"
    private static final String URL = "jdbc:mysql://localhost:3307/" + BD;      //"jdbc:mysql://10.0.16.39:3306/" + BD
    /**
     * Constructor por defecto el cuál define las propiedades de la base de datos desde los atributos, el user, password y establece con el DriverManager, da un mensaje si la conexión fue establecida correctamente
     */
    public AccesoABaseDatos() {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", USUARIO);
            properties.setProperty("password", CLAVE);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            conn = (Connection) DriverManager.getConnection(URL, properties);
            if (conn != null) {
                System.out.println("Conexion establecida a: " + URL);
            } else {
                System.out.println("ERROR: no se pudo establecer la conexion a la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        }
    }

    /**
     * Método estático y clase que devuelve la única instancia de AccesoABaseDatos
     * @return de tipo AccesoABaseDatos, la clase AccesoABaseDatosHolder con la instancia
     */
    public static AccesoABaseDatos getInstance() {
        return AccesoABaseDatosHolder.INSTANCE;
    }
    /**
     * Clase estática privada la cuál crea la única instancia de AccesoABaseDatos
     */
    private static class AccesoABaseDatosHolder {
        
        private static final AccesoABaseDatos INSTANCE = new AccesoABaseDatos();
    }

    /**
     * Método públic que cierra la conexión
     * @return boolean si la conexión fue cerrada o no
     */
    public boolean cerrar() {
        boolean cerrada = false;
        try {
            conn.close();
            if (conn.isClosed()) {
                cerrada=true;
            }
        }catch(SQLException e){
            System.out.println("SQLError: "+e.getMessage());
        }
        return cerrada;
    }

    //Metodo que devuelve la conexion
    /**
     * Método público que devuelve la conexión para usarla en demás clases
     * @return el atributo "conn", el cuál representa la conexión actual de la base de datos
     */
    public Connection getConnexion() {
        return conn;
    }
}
