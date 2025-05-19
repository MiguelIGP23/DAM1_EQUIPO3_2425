/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.Actividad;
import com.mycompany.reto_equipo3.Rutas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO de Actividad para las consultas/modificaciones simples de la base de datos
 * @author Hugo Fernández, JavaDoc por Hugo Fernández  
 */
public class DAOActividad implements InterfazDAO<Actividad> {

    private Connection conn;
    /**
     * Constructor por defecto, devuelve la conexión de la base de datos desde el atributo "conn" con los métodos de acceso de la clase
     */
    public DAOActividad() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
    /**
     * Método insertar para insertar a la base de datos una actividad
     * @param actividad parámetro que sirve para llamar a dichos getters de la clase Actividad
     * @param idRuta parámetro que identificará la id de la ruta a insertar
     * @return boolean si la actividad fue insertada correctamente
     * //@throws SQLException lanzará un mensaje de error en la insercción de una actividad en SQL
     * //@throws Exception Si el executeUpdate no es 1, no se creará la actividad
     */
    public boolean insertar(Actividad actividad, int idRuta) {
        boolean valida=false;
        String sql = "insert into actividad (nombre, rutas_idRuta) values (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, actividad.getNombre());
            pstmt.setInt(2, idRuta);
            if (pstmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creó la actividad");
            }
            valida=true;
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valida;
    }
    /**
     * Método modificar para actualizar una actividad de la base de datos
     * @param actividad parámetro que sirve para llamar a dichos getters de la clase Actividad
     * //@throws SQLException lanzará un mensaje de error en la modificación de una actividad en SQL
     * //@throws Exception Si el executeUpdate no es 1, no se modificará la actividad
     */
    @Override
    public void modificar(Actividad actividad) {
        String sql = "update actividad set nombre = ? where nombre = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, actividad.getNombre());
            pstmt.setString(2, actividad.getNombre());
            if (pstmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado la actividad.");
            }
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Método listar para listar en una colección de List de Actividad todas las actividades de la base de datos
     * @param id parámetro que identifica la id de la ruta
     * @return la colección listada en List
     * //@throws SQLException lanzará un mensaje de error cuando se trató de listar una actividad del SQL
     * //@throws Exception Si el executeUpdate no es 1, no se listará la actividad
     */
    public List<Actividad> listar(int id) {
        List<Actividad> actividades = new ArrayList<>();
        String sql = "select idActividad, nombre from actividad where rutas_idRuta=? ";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("dentritry2");
                while (rs.next()) {
                    System.out.println("dentrowhile");
                    Actividad actividad = this.crearActividades(rs);
                    if (!actividades.add(actividad)) {
                        throw new Exception("ERROR: no se listaron las actividades");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actividades;
    }
    /**
     * Método eliminar para eliminar una actividad de la base de datos
     * @param idActividad parámetro que identificará la id de la actividad para buscar dicha actividad a borrar
     * @return boolean si la actividad se ha eliminado correctamente
     * //@throws SQLException lanzará un mensaje de error en la eliminación de una actividad en SQL
     * //@throws Exception Si el executeUpdate no es 1, no se eliminará la actividad
     */
    @Override
    public boolean eliminar(int idActividad) {
        boolean valido=false;
        String sql = "delete from actividad where idActividad = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idActividad);
            if (pstmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha eliminado la actividad.");
            }
            valido=true;
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valido;
    }
    /**
     * Método buscar para buscar una actividad de manera rápida
     * @param nombre parámetro por el que se encontrará desde la consulta select, es decir, con el nombre
     * @return un objeto Actividad, es decir, la actividad encontrada
     */
    @Override
    public Actividad buscar(String nombre) {
        Actividad actividad = null;
        String sql = "select idActividad, nombre from actividad where nombre=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    actividad = this.crearActividades(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        }
        return actividad;
    }
    /**
     * Método privado crearActividades, donde irá creando actividades recogiéndolas desde la base de datos y luego listarlas en el método de listar
     * @param rs parámetro de recogida por consulta en el método listar
     * @return cada objeto Actividad encontrado desde el método listar
     * @throws SQLException podría ocurrir un error en el SQL al realizar el rs
     */
    private Actividad crearActividades(final ResultSet rs) throws SQLException {
        return new Actividad(rs.getInt(1), rs.getString(2));
    }
}
