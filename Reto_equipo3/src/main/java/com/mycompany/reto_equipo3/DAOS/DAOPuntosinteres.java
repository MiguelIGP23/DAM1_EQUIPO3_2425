/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.PuntosInteres;
import com.mycompany.reto_equipo3.PuntosPeligro;
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
 * @author DAM122
 */
public class DAOPuntosinteres {
    private Connection conn;

    public DAOPuntosinteres() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

    public void insertar(PuntosInteres puntointeres, Rutas ruta) {
        String sql = "INSERT INTO puntospeligro (nombre, latitud, longitud, elevacion, descripcion, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntointeres.getNombre());
            stmt.setDouble(2, puntointeres.getLatitud());
            stmt.setDouble(3, puntointeres.getLongitud());
            stmt.setDouble(4, puntointeres.getElevacion()); // Elevación ahora en el orden correcto
            stmt.setString(5, puntointeres.getDescripcion());
            stmt.setInt(6, puntointeres.getRutas_idRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se creó el punto de interés");
            }
            System.out.println("Se creó correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modificar(PuntosInteres puntointeres) {
        String sql = "UPDATE puntospeligro SET nombre = ?, latitud = ?, longitud = ?, elevacion = ?, descripcion = ? WHERE idPuntosInteres = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntointeres.getNombre());
            stmt.setDouble(2, puntointeres.getLatitud());
            stmt.setDouble(3, puntointeres.getLongitud());
            stmt.setDouble(4, puntointeres.getElevacion()); // Elevación ahora en el orden correcto
            stmt.setString(5, puntointeres.getDescripcion());
            stmt.setInt(6, puntointeres.getIdPuntosInteres());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se ha modificado el punto de interés");
            }
            System.out.println("Se modificó el punto de interés");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<PuntosInteres> listar() {
        List<PuntosInteres> lista = new ArrayList<>();
        PuntosInteres P1 = null;
        String sql = "SELECT nombre, latitud, longitud, elevacion, descripcion FROM puntosinteres"; // Agregada la elevación aquí
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                P1 = crearPuntosInteres(rs);
                if (!lista.add(P1)) {
                    throw new Exception("Un punto de interés no se añadió");
                }
            }
            System.out.println("Se insertaron correctamente todos los puntos de interés");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public PuntosInteres crearPuntosInteres(final ResultSet rs) throws SQLException {
        return new PuntosInteres(rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5));
    }

    public void eliminar(String nombre) {
        String sql = "DELETE FROM puntosinteres WHERE nombre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se borró el punto de interés");
            }
            System.out.println("Se borró el punto de interés");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PuntosInteres buscar(String nombre) {
        PuntosInteres buscado = null;
        String sql = "SELECT nombre, latitud, longitud, elevacion, descripcion FROM puntospeligro WHERE nombre = ?"; // Elevación agregada
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buscado = crearPuntosInteres(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: no se pudo conectar a la BD");
        }
        return buscado;
    }
}

