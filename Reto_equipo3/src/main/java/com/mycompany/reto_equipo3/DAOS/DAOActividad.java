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
 *
 * @author DAM119
 */
public class DAOActividad implements InterfazDAO<Actividad> {

    private Connection conn;

    public DAOActividad() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

    public void insertar(Actividad actividad, Rutas ruta) {
        String sql = "insert into actividad (nombre, rutas_idRuta) values (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, actividad.getNombre());
            pstmt.setInt(2, ruta.getIdRuta());
            if (pstmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creó la actividad");
            }
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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

    public List<Actividad> listar() {
        List<Actividad> actividades = new ArrayList<>();
        String sql = "select nombre from actividad";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Actividad actividad = this.crearActividades(rs);
                if (!actividades.add(actividad)) {
                    throw new Exception("ERROR: la actividad no se ha añadido.");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actividades;
    }

    @Override
    public void eliminar(String nombre) {
        String sql = "delete from actividad where nombre = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            if (pstmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha eliminado la actividad.");
            }
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Actividad buscar(Rutas ruta) {
        Actividad actividad = null;
        String sql = "select nombre from actividad where rutas_idRuta = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ruta.getIdRuta());
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

    private Actividad crearActividades(final ResultSet rs) throws SQLException {
        return new Actividad(rs.getString(2));
    }

    @Override
    public Actividad buscar(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
