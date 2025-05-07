/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.Rutas;
import com.mycompany.reto_equipo3.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MiguelIGP-1ºDAM
 */
public class DAORutas implements InterfazDAO<Rutas> {
    private Connection conn;

    public DAORutas() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

    public void insertar(Rutas ruta,Usuario usu) {
        String sql = "INSERT INTO rutas (nombre, nombre_inicioruta,nombre_finalruta,latitudInicial,latitudFinal,longitudInicial,longitudFinal,distancia,duracion,usuario_idUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ruta.getNombre());
            stmt.setString(2, ruta.getNombre_inicioruta());
            stmt.setString(3, ruta.getNombre_finalruta());
            stmt.setDouble(4, ruta.getLatitudInicial());
            stmt.setDouble(5, ruta.getLatitudFinal());
            stmt.setDouble(6, ruta.getLongitudInicial());
            stmt.setDouble(7, ruta.getLongitudFinal());
            stmt.setDouble(8, ruta.getDistancia());
            stmt.setTime(9, Time.valueOf(ruta.getDuracion()));
            stmt.setInt(10, usu.getIdUsuario());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se creo la ruta");
            }
            System.out.println("Se creo correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Rutas ruta) {
        String sql = "UPDATE rutas set nombre=?, nombre_inicioruta=?,nombre_finalruta=?,latitudInicial=?,latitudFinal=?,longitudInicial=?,longitudFinal=?,distancia=?,duracion=? WHERE idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ruta.getNombre());
            stmt.setString(2, ruta.getNombre_inicioruta());
            stmt.setString(3, ruta.getNombre_finalruta());
            stmt.setDouble(4, ruta.getLatitudInicial());
            stmt.setDouble(5, ruta.getLatitudFinal());
            stmt.setDouble(6, ruta.getLongitudInicial());
            stmt.setDouble(7, ruta.getLongitudFinal());
            stmt.setDouble(8, ruta.getDistancia());
            stmt.setTime(9, Time.valueOf(ruta.getDuracion()));
            stmt.setInt(10, ruta.getIdRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se ha modificado el usuario");
            }
            System.out.println("Se modifico el usuario");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Rutas> listar() {
        List<Rutas> lista = new ArrayList<>();
        Rutas R1 = null;
        String sql = "Select nombre, nombre_inicioruta,nombre_finalruta,latitudInicial,latitudFinal,longitudInicial,longitudFinal,distancia,duracion from rutas";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                R1 = crearRutas(rs);
                if (!lista.add(R1)) {
                    throw new Exception("Un usuario no se añadio");
                }
            }
            System.out.println("Se inserto correctamente todos los usuarios");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public Rutas crearRutas(final ResultSet rs) throws SQLException {
        return new Rutas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getTime(9).toLocalTime());
    }

    @Override
    public void eliminar(String nombre) {
        String sql = "DELETE FROM rutas WHERE nombre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se borrado la ruta");
            }
            System.out.println("Se borro la ruta");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Rutas buscar(String nombre) {
        Rutas buscado = null;
        String sql = "Select nombre, nombre_inicioruta,nombre_finalruta,latitudInicial,latitudFinal,longitudInicial,longitudFinal,distancia,duracion from rutas where nombre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try(ResultSet rs = stmt.executeQuery();){
              if (rs.next()) {
              buscado = crearRutas(rs);
            }
           }
        } catch (SQLException e) {
            System.out.println("SQLERROR: no se pudo conectar a la BD");
        }
        return buscado;
    }
}
