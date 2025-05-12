/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.Enums.Roles;
import com.mycompany.reto_equipo3.Rutas;
import com.mycompany.reto_equipo3.Valora;
import com.mycompany.reto_equipo3.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MiguelIGP-1ºDAM
 */
public class DAOValora implements InterfazDAO<Valora> {

    private Connection conn;

    public DAOValora() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

    public void insertar(Valora valora, Usuario usu, Rutas ruta) {
        String sql = "INSERT INTO valora (dificultad, fecha, estrellas, interesCultural, belleza, usuario_idUsuario, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, valora.getDificultad());
            stmt.setDate(2, Date.valueOf(valora.getFecha()));
            stmt.setInt(3, valora.getEstrellas());
            stmt.setInt(4, valora.getInteresCultural());
            stmt.setInt(5, valora.getBelleza());
            stmt.setInt(6, usu.getIdUsuario());
            stmt.setInt(7, ruta.getIdRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creo la valoracion");
            }
            System.out.println("Se creo la valoracion");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: ruta ya valorada por el usuario");
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

    public List<Valora> listar(int id) {
        List<Valora> lista = new ArrayList<>();
        Valora v;
        String sql = "SELECT idValora, dificultad, fecha, estrellas, interesCultural, belleza FROM valora where rutas_idRuta = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    v = crearValoracion(rs);
                    if (!lista.add(v)) {
                        throw new Exception("ERROR: la valoracion no se añadio");
                    }
                }
            }
            System.out.println("Se lleno lista con valoraciones");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public Valora crearValoracion(final ResultSet rs) throws Exception {
        return new Valora(rs.getInt(1), rs.getInt(2), rs.getDate(3).toLocalDate(), rs.getInt(4), rs.getInt(5), rs.getInt(6));
    }

    public void eliminar(Usuario usu, Rutas ruta) {
        String sql = "DELETE FROM valora WHERE usuario_idUsuario=? and rutas_idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usu.getIdUsuario());
            stmt.setInt(2, ruta.getIdRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: la valoracion no existe");
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
        String sql = "SELECT idValora, dificultad, fecha, estrellas, interesCultural, belleza FROM valora WHERE idValora = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    buscado = crearValoracion(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: "+e.getMessage());
        } catch (Exception e) {
            System.out.println("awefafafawfaw");
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
