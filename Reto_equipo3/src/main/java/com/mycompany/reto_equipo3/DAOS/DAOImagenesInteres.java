/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.ImagenesInteres;
import com.mycompany.reto_equipo3.PuntosInteres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO de ImagenesInteres para las consultas/modificaciones simples de la
 * base de datos
 *
 * @author Manuel Mediavilla y Hugo Fernández, JavaDoc por Hugo Fernández
 */
public class DAOImagenesInteres implements InterfazDAO<DAOImagenesInteres> {

    private Connection conn;

    /**
     * Constructor por defecto, devuelve la conexión de la base de datos desde
     * el atributo "conn" con los métodos de acceso de la clase
     */
    public DAOImagenesInteres() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
    /**
     * Método listar para listar en una colección de List de ImagenesInteres todas las imágenes de interés de la base de datos
     * @param idPuntoInteres parámetro que identifica el punto de interés
     * @return la colección listada en List
     */
    public List<ImagenesInteres> listar(int idPuntoInteres) {
        List<ImagenesInteres> lista = new ArrayList<>();
        ImagenesInteres ii = null;
        String sql = "select idimagenesinteres,url,descripcion  from imagenesinteres where puntosinteres_idPuntosinteres=?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, idPuntoInteres);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    ii = crearImagenesInteres(rs);
                    if (!lista.add(ii)) {
                        throw new Exception("ERROR: la imagen  de interes no se anadio");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    /**
     * Método privado crearImagenesInteres, donde irá creando imágenes de interés recogiéndolas desde la base de datos y luego listarlas en el método de listar
     * @param rs parámetro de recogida por consulta en el método listar
     * @return cada objeto ImagenesInteres encontrado desde el método listar
     * @throws SQLException podría ocurrir un error en el SQL al realizar el rs
     */
    private ImagenesInteres crearImagenesInteres(final ResultSet rs) throws SQLException {
        return new ImagenesInteres(rs.getInt(1), rs.getString(2), rs.getString(3));
    }
    /**
     * Método insertar para insertar a la base de datos una imagen de interés
     * @param imi parámetro que sirve para llamar a dichos getters de la clase ImagenesInteres
     * @param pi parámetro que identificarála id del punto de interés a insertar
     * @return boolean si la imagen de interés fue insertada correctamente
     */
    public boolean insertar(ImagenesInteres imi, int pi) {
        boolean insertado = false;
        String sql = "insert into imagenesinteres (url, descripcion, puntosinteres_idPuntosinteres) values (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, imi.getUrl());
            pstmt.setString(2, imi.getDescripcion());
            pstmt.setInt(3, pi);
            if (pstmt.executeUpdate() != 1) {
                throw new Exception("Error: la imagen de interes no se ha insertado.");
            }
            insertado = true;
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return insertado;
    }
    /**
     * Método eliminar para eliminar una imagen de interés de la base de datos
     * @param idImi parámetro que identificará la id de la imagen de interés para buscar dicha imagen de interés a borrar
     * @return boolean si la imagen de interés se ha eliminado correctamente
     */
    @Override
    public boolean eliminar(int idImi) {
        boolean eliminado = false;
        String sql = "delete into imagenesinteres where idimagenesinteres = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idImi);
            if (pstmt.executeUpdate() != 1) {
                throw new Exception("Error: la imagen de interes no se ha eliminado.");
            }
            eliminado = true;
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return eliminado;
    }
    /**
     * Método modificar recogido de la interfaz DAO
     * @param obj
     * @deprecated método no implementado
     */
    @Deprecated
    @Override
    public void modificar(DAOImagenesInteres obj) {
        //Metodo comun pero no implementado
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * Método buscar recogido de la interfaz DAO
     * @param email
     * @return 
     * @deprecated método no implementado
     */
    @Deprecated
    @Override
    public DAOImagenesInteres buscar(String email) {
        //Metodo comun pero no implementado
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
