/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.Enums.Clasificacion;
import com.mycompany.reto_equipo3.Enums.Tipo;
import com.mycompany.reto_equipo3.PuntosInteres;
import com.mycompany.reto_equipo3.Rutas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<PuntosInteres> listar(Rutas ruta) {
        List<PuntosInteres> lista = new ArrayList<>();
        PuntosInteres P1 = null;
        String sql = "SELECT idPuntosinteres, nombre, latitud, longitud, elevacion, descripcion FROM puntosinteres where rutas_idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, ruta.getIdRuta());
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

    //Metodo usado para la generacion de la ficha 
    public List<PuntosInteres> listarTodaInfo(Rutas ruta) {
        List<PuntosInteres> lista = new ArrayList<>();
        PuntosInteres P1 = null;
        String sql = "SELECT idPuntosinteres, nombre, latitud, longitud, elevacion, caracteristicas, tipo, descripcion, timestamp FROM puntosinteres where rutas_idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, ruta.getIdRuta());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    P1 = crearPuntosInteresTodaInfo(rs);
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

    //Metodo usado para la generacion de las fichas
    public PuntosInteres crearPuntosInteresTodaInfo(final ResultSet rs) throws SQLException {
        Set<String> tipo = new HashSet<>();
        String tipostring = rs.getString("tipo");
        if (tipostring != null && !tipostring.isEmpty()) {
            String[] valores = tipostring.split(",");
            tipo.addAll(List.of(valores));
        }
        Tipo t = Tipo.valueOf(rs.getString("tipo").toUpperCase());
        return new PuntosInteres(
                rs.getInt("idPuntosinteres"),
                rs.getString("nomvre"),
                rs.getDouble("latitud"),
                rs.getDouble("longitud"),
                rs.getDouble("elevacion"),
                rs.getString("caracteristicas"),
                t,
                rs.getString("descripcion"),
                rs.getInt("timestamp")
        );
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
    
    
    //Metodo usado para la generacion de las fichas
    public PuntosInteres buscarTodaInfo(String nombre) {
        PuntosInteres buscado = null;
        String sql = "SELECT idPuntosinteres, nombre, latitud, longitud, elevacion, caracteristicas, tipo, descripcion, timestamp FROM puntosinteres WHERE nombre = ?";
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
