/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.ImagenesInteres;
import com.mycompany.reto_equipo3.ImagenesPeligro;
import com.mycompany.reto_equipo3.PuntosPeligro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salsa
 */
public class DAOImagenesPeligro {
    private Connection conn;

    public DAOImagenesPeligro() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
     public List<ImagenesPeligro> listar(int idPuntoPeligro){
        List<ImagenesPeligro> lista=new ArrayList<>();
        ImagenesPeligro ip=null;
        String sql="select idimagenespeligro,url,descripcion  from imagenespeligro where puntospeligro_idPuntosinteres=?";
        try(PreparedStatement pstm=conn.prepareStatement(sql)){
           pstm.setInt(1, idPuntoPeligro);
           try(ResultSet rs=pstm.executeQuery()){
              while(rs.next()){
                  ip=crearImagenesPeligro(rs);
                  if (!lista.add(ip)) {
                      throw new Exception("ERROR: la imagen  de peligro no se anadio");
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
    public ImagenesPeligro crearImagenesPeligro(final ResultSet rs)throws SQLException{
        return new ImagenesPeligro(rs.getInt(1),rs.getString(2),rs.getString(3));
    }
    public boolean insertar(ImagenesPeligro imp, int pp) {
        boolean insertado = false;
        String sql = "insert into imagenespeligro (url, descripcion, puntospeligro_idPuntospeligro) values (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, imp.getUrl());
            pstmt.setString(2, imp.getDescripcion());
            pstmt.setInt(3, pp);
            if (pstmt.executeUpdate() != 1) {
                throw new Exception("Error: la imagen de peligro no se ha insertado.");
            }
            insertado = true;
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return insertado;
    }
    public boolean eliminar(int idImp) {
        boolean eliminado = false;
        String sql = "delete from imagenespeligro where idimagenespeligro = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idImp);
            if (pstmt.executeUpdate() != 1) {
                throw new Exception("Error: la imagen de peligro no se ha eliminado");
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
