/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.ImagenesInteres;
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
public class DAOImagenesInteres {
  


  private Connection conn;

    public DAOImagenesInteres() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }

    // Obtener imágenes por ID de punto de interés
    public List<ImagenesInteres> listarPorPuntoInteres(int idPuntoInteres) {
        List<ImagenesInteres> lista = new ArrayList<>();
        String sql = "SELECT * FROM imagenesinteres WHERE puntosinteres_idPuntosinteres = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPuntoInteres);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ImagenesInteres img = new ImagenesInteres(
                    rs.getInt("idimagenesinteres"),
                    rs.getString("url"),
                    rs.getString("descripcion"),
                    rs.getInt("puntosinteres_idPuntosinteres")
                );
                lista.add(img);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //obtener imágenes por ID de ruta
    public List<ImagenesInteres> listarPorRuta(int idRuta) {
        List<ImagenesInteres> lista = new ArrayList<>();
        String sql = """
            SELECT i.*
            FROM imagenesinteres i
            JOIN puntosinteres p ON i.puntosinteres_idPuntosinteres = p.idPuntosInteres
            WHERE p.rutas_idRuta = ?
            """;

        try (
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idRuta);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ImagenesInteres img = new ImagenesInteres(
                    rs.getInt("idimagenesinteres"),
                    rs.getString("url"),
                    rs.getString("descripcion"),
                    rs.getInt("puntosinteres_idPuntosinteres")
                );
                lista.add(img);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}


