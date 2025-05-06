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
 *
 * @author DAM123
 */
public class AccesoABaseDatos {
    
    //Atributo de la conexion
    private static Connection conn = null;

    //Definimos las constantes
    private static final String BD = "mydb";
    private static final String USUARIO = "root";
    private static final String CLAVE = "mysql";
    private static final String URL = "jdbc:mysql://localhost:3307/" + BD;

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

    //Metodo y clase que crea la unica instancia de AccesoABaseDatos
    public static AccesoABaseDatos getInstance() {
        return AccesoABaseDatosHolder.INSTANCE;
    }

    private static class AccesoABaseDatosHolder {

        private static final AccesoABaseDatos INSTANCE = new AccesoABaseDatos();
    }

    //Metodo que cierra la conexion
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
    public Connection getConnexion() {
        return conn;
    }
}
