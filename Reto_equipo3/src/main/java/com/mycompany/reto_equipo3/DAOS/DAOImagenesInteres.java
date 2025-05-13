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
 *
 * @author DAM122
 */
public class DAOImagenesInteres {
  private Connection conn;

    public DAOImagenesInteres() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
    public List<ImagenesInteres> listar(int idPuntoInteres){
        List<ImagenesInteres> lista=new ArrayList<>();
        ImagenesInteres ii=null;
        String sql="select idimagenesinteres,url,descripcion  from imagenesinteres where puntosinteres_idPuntosinteres=?";
        try(PreparedStatement pstm=conn.prepareStatement(sql)){
           pstm.setInt(1, idPuntoInteres);
           try(ResultSet rs=pstm.executeQuery()){
              while(rs.next()){
                  ii=crearImagenesInteres(rs);
                  if (!lista.add(ii)) {
                      throw new Exception("ERROR: la imagen  de interes no se anadio");
                  }
              } 
           }
        }catch(SQLException ex){
           System.out.println("SQL ERROR: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
      return lista;
    }
    public ImagenesInteres crearImagenesInteres(final ResultSet rs)throws SQLException{
        return new ImagenesInteres(rs.getInt(1),rs.getString(2),rs.getString(3));
    }
    public boolean insertar(ImagenesInteres imi, PuntosInteres pi) {
        boolean insertado = false;
        String sql = "insert into imagenesinteres (url, descripcion, puntosinteres_idPuntosinteres) values (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, imi.getDescripcion());
            pstmt.setString(2, imi.getUrl());
            pstmt.setInt(3, pi.getIdPuntosInteres());
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
}


