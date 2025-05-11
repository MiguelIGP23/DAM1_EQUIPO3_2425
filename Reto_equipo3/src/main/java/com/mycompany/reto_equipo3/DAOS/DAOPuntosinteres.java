/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.PuntosInteres;
import com.mycompany.reto_equipo3.Rutas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAM122
 */
public class DAOPuntosinteres {

    private Connection conn;

    public DAOPuntosinteres() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

    public void insertar(PuntosInteres puntointeres, Rutas ruta) {
        String sql = "INSERT INTO puntosinteres (nombre, latitud, longitud, elevacion, descripcion, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntointeres.getNombre());
            stmt.setDouble(2, puntointeres.getLatitud());
            stmt.setDouble(3, puntointeres.getLongitud());
            stmt.setDouble(4, puntointeres.getElevacion()); // Elevación ahora en el orden correcto
            stmt.setString(5, puntointeres.getDescripcion());
            stmt.setInt(6, ruta.getIdRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: No se creo el punto de interes");
            }
            System.out.println("El punto se creo correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modificar(PuntosInteres puntointeres) {
        String sql = "UPDATE puntosinteres SET nombre = ?, latitud = ?, longitud = ?, elevacion = ?, descripcion = ? WHERE idPuntosInteres = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntointeres.getNombre());
            stmt.setDouble(2, puntointeres.getLatitud());
            stmt.setDouble(3, puntointeres.getLongitud());
            stmt.setDouble(4, puntointeres.getElevacion());
            stmt.setString(5, puntointeres.getDescripcion());
            stmt.setInt(6, puntointeres.getIdPuntosInteres());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: No se ha modificado el punto de interes");
            }
            System.out.println("Se modifico el punto de interes");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<PuntosInteres> listar(int idruta) {
        List<PuntosInteres> lista = new ArrayList<>();
        PuntosInteres P1 = null;
        String sql = "SELECT idPuntosinteres, nombre, latitud, longitud, elevacion, descripcion FROM puntosinteres where rutas_idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, idruta);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    P1 = crearPuntoInteres(rs);
                    if (!lista.add(P1)) {
                        throw new Exception("ERROR: el punto de interes no se anadio");
                    }
                }
            }
            System.out.println("Se listaron todos los puntos de interes");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public PuntosInteres crearPuntoInteres(final ResultSet rs) throws SQLException {
        return new PuntosInteres(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6));
    }

    public void eliminar(String nombre) {
        String sql = "DELETE FROM puntosinteres WHERE nombre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se borro el punto de interes");
            }
            System.out.println("Se borro el punto de interes");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PuntosInteres buscar(String nombre) {
        PuntosInteres buscado = null;
        String sql = "SELECT idPuntosinteres, nombre, latitud, longitud, elevacion, descripcion FROM puntosinteres WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buscado = crearPuntoInteres(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: " + e.getMessage());
        }
        return buscado;
    }
}
