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
 *
 *
 * @author DAM119
 *
 */
public class DAOActividad implements InterfazDAO<Actividad> {

    private Connection conn;

    public DAOActividad() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

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

    private Actividad crearActividades(final ResultSet rs) throws SQLException {
        return new Actividad(rs.getInt(1), rs.getString(2));
    }

    @Override
    public void eliminar(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
