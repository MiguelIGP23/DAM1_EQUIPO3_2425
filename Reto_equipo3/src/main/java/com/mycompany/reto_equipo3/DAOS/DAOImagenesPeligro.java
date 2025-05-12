/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.ImagenesInteres;
import com.mycompany.reto_equipo3.ImagenesPeligro;
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
}
