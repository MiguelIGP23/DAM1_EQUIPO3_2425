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

    public List<PuntosPeligro> listar(int id) {
        List<PuntosPeligro> lista = new ArrayList<>();
        PuntosPeligro P1;
        String sql = "SELECT idPuntospeligro, nombre, latitud, longitud, elevacion, descripcion FROM puntospeligro where rutas_idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    P1 = crearPuntoPeligro(rs);
                    if (!lista.add(P1)) {
                        throw new Exception("ERROR: el punto de peligro no se agrego");
                    }
                }
            }
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
    
    //Metodo listar crear y buscar completos y funcionales usados en fichas
    //Devuelve lista con objetos completos
    public List<PuntosPeligro> listarTodaInfo(Rutas ruta) {
        List<PuntosPeligro> lista = new ArrayList<>();
        PuntosPeligro punto;
        String sql = "SELECT idPuntospeligro, nombre, latitud, longitud, elevacion, kilometros, gravedad, posicion, descripcion, timestamp FROM puntospeligro where rutas_idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, ruta.getIdRuta());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    punto = crearPuntosPeligroTodaInfo(rs, ruta);
                    if (!lista.add(punto)) {
                        throw new Exception("ERROR: el punto de peligro no se anadio");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    
    //Crea el objeto completo
    private PuntosPeligro crearPuntosPeligroTodaInfo(final ResultSet rs, Rutas ruta) throws SQLException {
        return new PuntosPeligro(
                rs.getInt(1),
                rs.getString(2),
                rs.getDouble(3),
                rs.getDouble(4),
                rs.getDouble(5),
                rs.getInt(6),
                rs.getInt(7),
                rs.getInt(8),
                rs.getString(9),
                rs.getInt(10), 
                ruta.getIdRuta()
        );
    }
    
    //Busca por nombre y devuelve objeto completo
    public PuntosPeligro buscarTodaInfo(String nombre, Rutas ruta) {
        PuntosPeligro buscado = null;
        String sql = "SELECT idPuntospeligro, nombre, latitud, longitud, elevacion, kilometros, gravedad, posicion, descripcion, timestamp FROM puntospeligro where nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buscado = crearPuntosPeligroTodaInfo(rs, ruta);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: " + e.getMessage());
        }
        return buscado;
    }
    
    //IInsertar completo
    public void insertarTodaInfo(PuntosPeligro puntopeligro, Rutas ruta) {
        String sql = "INSERT INTO puntospeligro (nombre, latitud, longitud, elevacion, kilometro, gravedad, posicion, descripcion, timestamp, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setDouble(4, puntopeligro.getElevacion());
            stmt.setDouble(5, puntopeligro.getKilometro());
            stmt.setInt(6, puntopeligro.getGravedad());
            stmt.setInt(7, puntopeligro.getPosicion());
            stmt.setString(8, puntopeligro.getDescripcion());
            stmt.setInt(9, puntopeligro.getTimestamp());
            stmt.setInt(10, ruta.getIdRuta());
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
    
    //Modificar completo
    public void modificarTodaInfo(PuntosPeligro puntopeligro) {
        String sql = "UPDATE puntospeligro SET nombre = ?, latitud = ?, longitud = ?, elevacion = ?, kilometro = ?, gravedad = ?, posicion = ?, descripcion = ?, timestamp = ? WHERE idPuntospeligro = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setDouble(4, puntopeligro.getElevacion());
            stmt.setDouble(5, puntopeligro.getKilometro());
            stmt.setInt(6, puntopeligro.getGravedad());
            stmt.setInt(7, puntopeligro.getPosicion());
            stmt.setString(8, puntopeligro.getDescripcion());
            stmt.setInt(9, puntopeligro.getTimestamp());
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
}
