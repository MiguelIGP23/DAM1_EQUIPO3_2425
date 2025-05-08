package com.mycompany.reto_equipo3.DAOS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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
public class DAOPuntospeligro implements InterfazDAO<PuntosPeligro> {
    private Connection conn;

    public DAOPuntospeligro() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

   
    @Override
    public void insertar(PuntosPeligro puntopeligro) {
        String sql = "INSERT INTO puntospeligro (nombre, latitud, longitud, elevacion, descripcion, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setDouble(4, puntopeligro.getElevacion());
            stmt.setString(5, puntopeligro.getDescripcion());
            stmt.setInt(6, puntopeligro.getRutas_idRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("Se inserto el punto de peligro");
            }
            System.out.println("ERROR: no se inserto el punto de peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(PuntosPeligro puntopeligro) {
        String sql = "UPDATE puntospeligro SET nombre = ?, latitud = ?, longitud = ?, elevacion = ?, descripcion = ? WHERE idPuntosInteres = ?";
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

    @Override
    public List<PuntosPeligro> listar() {
        List<PuntosPeligro> lista = new ArrayList<>();
        PuntosPeligro P1 = null;
        String sql = "SELECT nombre, latitud, longitud, elevacion, descripcion FROM puntospeligro"; 
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                P1 = crearPuntoPeligro(rs);
                if (!lista.add(P1)) {
                    throw new Exception("ERROR: el punto de peligro no se agrego");
                }
            }
            System.out.println("Se insertaron correctamente todos los puntos de peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public PuntosPeligro crearPuntoPeligro(final ResultSet rs) throws SQLException {
        return new PuntosPeligro(rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getString(4)); 
    }

    @Override
    public void eliminar(String nombre) {
        String sql = "DELETE FROM puntospeligro WHERE nombre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se borró el punto de peligro");
            }
            System.out.println("Se borró el punto de peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public PuntosPeligro buscar(String nombre) {
        PuntosPeligro buscado = null;
        String sql = "SELECT nombre, latitud, longitud, elevacion, descripcion FROM puntospeligro WHERE nombre = ?"; 
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buscado = crearPuntoPeligro(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: no se pudo conectar a la BD");
        }
        return buscado;
    }
}
