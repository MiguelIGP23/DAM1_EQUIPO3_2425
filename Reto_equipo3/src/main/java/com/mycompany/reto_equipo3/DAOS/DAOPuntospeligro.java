/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.PuntosPeligro;
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
public class DAOPuntospeligro implements InterfazDAO<PuntosPeligro> {

    private Connection conn;

    public DAOPuntospeligro() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

    public void insertar(PuntosPeligro puntopeligro, Rutas ruta) {
        String sql = "INSERT INTO puntospeligro (nombre, latitud, longitud, elevacion, descripcion, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setDouble(4, puntopeligro.getElevacion());
            stmt.setString(5, puntopeligro.getDescripcion());
            stmt.setInt(6, ruta.getIdRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creo el punto de peligro");
            }
            System.out.println("El punto se ceo correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(PuntosPeligro puntopeligro) {
        String sql = "UPDATE puntospeligro SET nombre = ?, latitud = ?, longitud = ?, elevacion = ?, descripcion = ? WHERE idPuntospeligro = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setDouble(4, puntopeligro.getElevacion());
            stmt.setString(5, puntopeligro.getDescripcion());
            stmt.setInt(6, puntopeligro.getIdPuntospeligro());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el punto de peligro");
            }
            System.out.println("Se modificó el punto de peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<PuntosPeligro> listar(int idRuta) {
        List<PuntosPeligro> lista = new ArrayList<>();
        PuntosPeligro P1 = null;
        String sql = "SELECT idPuntospeligro, nombre, latitud, longitud, elevacion, descripcion FROM puntospeligro where rutas_idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, idRuta);
            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    P1 = crearPuntoPeligro(rs);
                    if (!lista.add(P1)) {
                        throw new Exception("ERROR: el punto de peligro no se agrego");
                    }
                }
            }
            System.out.println("Se listaron todos los puntos de peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public PuntosPeligro crearPuntoPeligro(final ResultSet rs) throws SQLException {
        return new PuntosPeligro(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6));
    }

    @Override
    public void eliminar(String nombre) {
        String sql = "DELETE FROM puntospeligro WHERE nombre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se borro el punto de peligro");
            }
            System.out.println("Se borro el punto de peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public PuntosPeligro buscar(String nombre) {
        PuntosPeligro buscado = null;
        String sql = "SELECT idPuntosPeligro, nombre, latitud, longitud, elevacion, descripcion FROM puntospeligro WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buscado = crearPuntoPeligro(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: "+e.getMessage());
        }
        return buscado;
    }
}
