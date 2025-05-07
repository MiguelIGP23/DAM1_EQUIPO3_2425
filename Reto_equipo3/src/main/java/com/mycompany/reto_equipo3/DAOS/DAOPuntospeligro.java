package com.mycompany.reto_equipo3.DAOS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.mycompany.reto_equipo3.DAOS.AccesoABaseDatos;
import com.mycompany.reto_equipo3.DAOS.InterfazDAO;
import com.mycompany.reto_equipo3.Enums.Roles;
import com.mycompany.reto_equipo3.PuntosPeligro;
import com.mycompany.reto_equipo3.Rutas;
import com.mycompany.reto_equipo3.Usuario;
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
public class DAOPuntospeligro implements InterfazDAO<PuntosPeligro>{
    private Connection conn;

    public DAOPuntospeligro() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

    
    public void insertar(PuntosPeligro puntopeligro,Rutas ruta) {
       String sql="insert into puntospeligro (nombre,latitud,longitud,descripcion,rutas_idRuta) values (?,?,?,?,?)";
       try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setString(4, puntopeligro.getDescripcion());
            stmt.setInt(5, puntopeligro.getRutas_idRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se creo el punto de peligroo");
            }
            System.out.println("Se creo correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    @Override
    public void modificar(PuntosPeligro puntopeligro) {
     String sql = "UPDATE puntospeligro SET nombre = ?, latitud = ?, longitud = ?, descripcion = ? WHERE idPuntosInteres = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setString(4, puntopeligro.getDescripcion());
            stmt.setInt(6, puntopeligro.getIdPuntosinteres());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se ha modificado el punto de peligro");
            }
            System.out.println("Se modifico el punto de peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    @Override
    public List listar() {
      List<PuntosPeligro> lista = new ArrayList<>();
        PuntosPeligro P1 = null;
        String sql = "SELECT nombre, latitud, longitud, descripcion FROM puntospeligro";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                P1 = crearPuntosPeligro(rs);
                if (!lista.add(P1)) {
                    throw new Exception("Un usuario no se añadio");
                }
            }
            System.out.println("Se inserto correctamente todos los puntos de peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
     public PuntosPeligro crearPuntosPeligro(final ResultSet rs) throws SQLException {
        return new PuntosPeligro(rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getString(4));
    }
    

    @Override
    public void eliminar(String nombre) {
       String sql = "DELETE FROM puntospeligro WHERE nombre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se borrado el punto de peligro");
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
        String sql = "SELECT nombre, latitud,longitud, descripcion FROM puntospeligro WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
           try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                buscado = crearPuntosPeligro(rs);
            }
           }
        } catch (SQLException e) {
            System.out.println("SQLERROR: no se pudo conectar a la BD");
        }
        return buscado;
    }

    
}
