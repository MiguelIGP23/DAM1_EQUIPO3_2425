/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.Calendario; 
import com.mycompany.reto_equipo3.Rutas;
import com.mycompany.reto_equipo3.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
/**
*
* @author DAM121
*/
public class DAOCalendario implements InterfazDAO<Calendario>{
    private Connection conn;
    public DAOCalendario() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
    public void insertar(Calendario calendario,Usuario usu,Rutas ruta){
        String sql="insert into calendario (fecha, detalles, recomendaciones, rutas_idRuta, usuario_idUsuario) values (?, ?, ?, ?, ?)";
        try(PreparedStatement pstm=conn.prepareStatement(sql)){
            pstm.setTimestamp(1, Timestamp.valueOf(calendario.getFecha()));
            pstm.setString(2, calendario.getDetalles());
            pstm.setString(3, calendario.getRecomendaciones());
            pstm.setInt(4, ruta.getIdRuta());
            pstm.setInt(5, usu.getIdUsuario());
            if (pstm.executeUpdate()!=1) {
                throw new Exception("ERROR: no se creó la actividad");
            }
        }catch(SQLException ex){
            System.out.println("SQLError: " + ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void eliminar(Calendario cal) {
      String sql="delete from calendario where idCalendario=?";
      try(PreparedStatement pstm=conn.prepareStatement(sql)){
          pstm.setInt(1, cal.getIdCalendario());
          if(pstm.executeUpdate()!=1){
               throw new Exception("ERROR: no se elimino el calendario");
          }
        }catch(SQLException ex){
            System.out.println("SQLError: " + ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
     private Calendario crearCalendario(final ResultSet rs) throws SQLException {
        return new Calendario(rs.getInt(1),rs.getTimestamp(2).toLocalDateTime(),rs.getString(3), rs.getString(4));
    }  
    public List<Calendario> listar(){
        List<Calendario>  calendario= new ArrayList<>();
        String sql = "select idCalendario, fecha, detalles, recomendaciones from calendario ";
        try (Statement stmt = conn.createStatement();ResultSet rs=stmt.executeQuery(sql)) {
            while (rs.next()) {
                Calendario calenda = crearCalendario(rs);
                if (!calendario.add(calenda)) {
                    throw new Exception("ERROR: el calendario no se ha añadido.");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return calendario;
    }   
 
    
    public Calendario buscar(Calendario cal) {
        Calendario buscado = null;
        LocalDate fec=cal.getFecha().toLocalDate();
        String sql = "SELECT idCalendario, fecha, detalles, recomendaciones FROM calendario WHERE DATE(fecha) = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(fec));
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    buscado = crearCalendario(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: "+e.getMessage());
        }
        return buscado;
    }
    
    
    @Override
    public void modificar(Calendario obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Calendario buscar(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}