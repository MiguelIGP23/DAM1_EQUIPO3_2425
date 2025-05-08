/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.Enums.Roles;
import com.mycompany.reto_equipo3.Valora;
import com.mycompany.reto_equipo3.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MiguelIGP-1ºDAM
 */
public class DAOValora implements InterfazDAO<Valora>{

    private Connection conn;

    public DAOValora() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

    @Override
    public void insertar(Valora valora) {
        String sql = "INSERT INTO valora (dificultad, fecha, estrellas, interesCultural, belleza) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, valora.getDificultad());
            stmt.setString(2, valora.getFecha().toString());
            stmt.setInt(3, valora.getEstrellas());
            stmt.setInt(4, valora.getInteresCultural());
            stmt.setInt(5, valora.getBelleza());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creo la valoracion");
            }
            System.out.println("Se creo correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Valora valora) {
        String sql = "UPDATE valora SET dificultad = ?, fecha = ?, estrellas = ?, interesCultural = ?, belleza = ? WHERE idValora = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, valora.getDificultad());
            stmt.setString(2, valora.getFecha().toString());
            stmt.setInt(3, valora.getEstrellas());
            stmt.setInt(4, valora.getInteresCultural());
            stmt.setInt(5, valora.getBelleza());
            stmt.setInt(6, valora.getIdValora());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado la valoracion");
            }
            System.out.println("Se modifico la valoracion");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Valora> listar() {
        List<Valora> lista = new ArrayList<>();
        Valora v = null;
        String sql = "SELECT dificultad, fecha, estrellas, interesCultural, belleza FROM valora";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                v = crearValoracion(rs);
                if (!lista.add(v)) {
                    throw new Exception("ERROR: la valoracion no se añadio");
                }
            }
            System.out.println("Se inserto correctamente todas las valoraciones");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public Valora crearValoracion(final ResultSet rs) throws SQLException {
        return new Valora(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getInt(3), rs.getInt(4), rs.getInt(5));
    }

    
    public void eliminar(int id) {
        String sql = "DELETE FROM valora WHERE idValora=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se elimino la valoracion");
            }
            System.out.println("Se elimino la valoracion");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public Valora buscar(int id) {
        Valora buscado = null;
        String sql = "SELECT dificultad, fecha, estrellas, interesCultural, belleza FROM valora WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery();){
               if (rs.next()) {
                buscado = crearValoracion(rs);
             } 
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: no se pudo conectar a la BD");
        }
        return buscado;
    }

    @Override
    public void eliminar(String email) {
    }

    @Override
    public Valora buscar(String email) {
        return null;
    }

    
}
