/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.Enums.Roles;
import com.mycompany.reto_equipo3.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

/**
 * Clase DAO de Usuario para las consultas/modificaciones simples de la base de datos
 * @author Miguel Inglés y Saúl García, JavaDoc por Hugo Fernández
 */
public class DAOUsuario implements InterfazDAO<Usuario> {
    private Connection conn;
    /**
     * Constructor por defecto, devuelve la conexión de la base de datos desde el atributo "conn" con los métodos de acceso de la clase
     */
    public DAOUsuario() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
    /**
     * Método insertar para insertar a la base de datos un usuario
     * @param usuario parámetro que sirve para llamar a dichos getters de la clase Usuario
     * @return boolean si el usuario fue insertado correctamente
     */
    public boolean insertar(Usuario usuario) {
        boolean exito=false;
        String sql = "INSERT INTO usuario (nombre, apellido, email, password, rol) VALUES (?, ?, ?, MD5(?), ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getPassword());
            stmt.setString(5, usuario.getRol().toString());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creo el usuario");
            }
            System.out.println("Se creo correctamente");
            exito=true;
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return exito;
    }
    /**
     * Método modificar para actualizar un usuario de la base de datos
     * @param usuario parámetro que sirve para llamar a dichos getters de la clase Usuario
     * @param id parámetro que identifica la id del usuario a modificar
     */
    public void modificar(Usuario usuario, int id) {
        String sql = "UPDATE usuario SET nombre = ?, apellido = ?, email = ?, password = MD5(?), rol = ? WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getPassword());
            stmt.setString(5, usuario.getRol().toString());
            stmt.setInt(6, id);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el usuario");
            }
            System.out.println("Se modifico el usuario");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Método listar para listar en una colección de List de Usuario todos los usuarios de la base de datos
     * @return la colección listada en List
     */
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        Usuario U1;
        String sql = "SELECT idUsuario,nombre, apellido, email, password, rol FROM usuario";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                U1 = crearUsuario(rs);
                if (!lista.add(U1)) {
                    throw new Exception("ERROR: el usuario no se añadio");
                }
            }
            System.out.println("Se inserto correctamente todos los usuarios");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    /**
     * Método privado crearUsuario, donde irá creando usuarios recogiéndolos desde la base de datos y luego listarlos en el método de listar
     * @param rs parámetro de recogida por consulta en el método listar
     * @return cada objeto Usuario encontrado desde el método listar
     * @throws SQLException podría ocurrir un error en el SQL al realizar el rs
     */
    private Usuario crearUsuario(final ResultSet rs) throws SQLException {
        return new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), Roles.valueOf(rs.getString(6)));
    }

    /**
     * Método eliminar para eliminar un usuario de la base de datos
     * @param email parámetro que se utilizará para encontrar el usuario a eliminar, es decir, con el email
     */
    public void eliminar(String email) {
        String sql = "DELETE FROM usuario WHERE email=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se borro el usuario");
            }
            System.out.println("Se borro el usuario");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Método buscar para buscar un usuario de manera rápida
     * @param email parámetro que se utilizará para encontrar el usuario a buscar, es decir, con el email
     * @return un objeto Usuario, es decir, el usuario encontrado
     */
    @Override
    public Usuario buscar(String email) {
        Usuario buscado = null;
        String sql = "SELECT idUsuario, nombre, apellido, email, password, rol FROM usuario WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            try(ResultSet rs = stmt.executeQuery();){
               if (rs.next()) {
                buscado = crearUsuario(rs);
             } 
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: "+e.getMessage());
        }
        return buscado;
    }
    /**
     * Método que comprueba si un usuario existe en la base de datos con su email y la contraseña válidas
     * @param email parámetro email
     * @param password parámetro de la contraseña encriptada en MD5
     * @return un objeto Usuario que si existe le devuelve y sino devuelve nulo
     */
    public Usuario encontrarUsuario(String email, String password) {
        Usuario usu = null;
        String sql = "SELECT idUsuario, nombre, apellido, email, password, rol FROM usuario WHERE email=? and password=MD5(?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                 if (rs.next()) {
                    usu = crearUsuario(rs);
                 }  
            }
        } catch (SQLException sex) {
            System.out.println("SQL ERROR: " + sex.getMessage());
        }
        return usu;
    }
    /**
     * Método modificar recogido de la interfaz DAO
     * @param obj 
     * @deprecated método no implementado
     */
    @Deprecated
    @Override
    public void modificar(Usuario obj) {
        //Metodo comun pero no implementado
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * Método eliminar recogido de la interfaz DAO
     * @param num
     * @return 
     * @deprecated método no implementado
     */
    @Deprecated 
    @Override
    public boolean eliminar(int num) {
        //Metodo comun pero no implementado
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
