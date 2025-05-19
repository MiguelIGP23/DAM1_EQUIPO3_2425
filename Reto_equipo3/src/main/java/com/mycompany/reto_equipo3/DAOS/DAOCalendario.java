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
* Calendario para las consultas/modificaciones simples de la base de datos
* @author Saúl García y Miguel Inglés, JavaDoc por Hugo Fernández  
*/
public class DAOCalendario implements InterfazDAO<Calendario>{
    private Connection conn;
    /**
     * Constructor por defecto, devuelve la conexión de la base de datos desde el atributo "conn" con los métodos de acceso de la clase
     */
    public DAOCalendario() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
    /**
     * Método insertar para insertar a la base de datos un calendario
     * @param calendario parámetro que sirve para llamar a dichos getters de la clase Calendario
     * @param usu parámetro que sirve para llamar a dichos getters de la clase Usuario
     * @param idRuta parámetro que identifica el id de la ruta
     * @return boolean si el calendario ha sido insertado o no
     */
    public boolean insertar(Calendario calendario,Usuario usu,int idRuta){
        boolean valido=false;
        String sql="insert into calendario (fecha, detalles, recomendaciones, rutas_idRuta, usuario_idUsuario) values (?, ?, ?, ?, ?)";
        try(PreparedStatement pstm=conn.prepareStatement(sql)){
            pstm.setTimestamp(1, Timestamp.valueOf(calendario.getFecha()));
            pstm.setString(2, calendario.getDetalles());
            pstm.setString(3, calendario.getRecomendaciones());
            pstm.setInt(4, idRuta);
            pstm.setInt(5, usu.getIdUsuario());
            if (pstm.executeUpdate()!=1) {
                throw new Exception("ERROR: no se creó la actividad");
            }
            valido=true;
        }catch(SQLException ex){
            System.out.println("SQLError: " + ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return valido;
    }
    /**
     * Método eliminar para eliminar a la base de datos un calendario
     * @param idCal parámetro que identificará la id del calendario para buscar dicho calendario a borrar
     * @return boolean si el calendario se ha eliminado correctamente
     */
    @Override
    public boolean eliminar(int idCal) {
        boolean valida=false;
      String sql="delete from calendario where idCalendario=?";
      try(PreparedStatement pstm=conn.prepareStatement(sql)){
          pstm.setInt(1, idCal);
          if(pstm.executeUpdate()!=1){
               throw new Exception("ERROR: no se elimino el calendario");
          }
          valida=true;
        }catch(SQLException ex){
            System.out.println("SQLError: " + ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return valida;
    }
    /**
     * Método privado crearCalendario, donde irá creando calendarios recogiéndolos desde la base de datos y luego listarlos en el método de listar
     * @param rs parámetro de recogida por consulta en el método listar
     * @return cada objeto Calendario encontrado desde el método listar
     * @throws SQLException SQLException podría ocurrir un error en el SQL al realizar el rs
     */
     private Calendario crearCalendario(final ResultSet rs) throws SQLException {
        return new Calendario(rs.getInt(1),rs.getTimestamp(2).toLocalDateTime(),rs.getString(3), rs.getString(4));
    }
     /**
     * Método listar para listar en una colección de List de Calendario todos los calendarios de la base de datos
     * @param idRuta parámetro que identifica la id de la ruta
     * @return la colección listada en List
     */
    public List<Calendario> listar(int idRuta){
        List<Calendario>  calendario= new ArrayList<>();
        String sql = "select idCalendario, fecha, detalles, recomendaciones from calendario where usuario_idUsuario=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idRuta);
            try(ResultSet rs=stmt.executeQuery()){
            while (rs.next()) {
                Calendario calenda = crearCalendario(rs);
                if (!calendario.add(calenda)) {
                    throw new Exception("ERROR: el calendario no se ha añadido.");
                }
            }
            }
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return calendario;
    }   
 
    /**
     * Método buscar para buscar un calendario de manera rápida
     * @param cal parámetro para llamar al getter de fecha para encontrar el calendario por su fecha
     * @return un objeto Calendario, es decir, el calendario encontrado
     */
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
    
    /**
     * Método modificar recogido de la interfaz DAO
     * @param obj
     * @deprecated método no implementado
     */
    @Deprecated
    @Override
    public void modificar(Calendario obj) {
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
    public Calendario buscar(String email) {
        //Metodo comun pero no implementado
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}