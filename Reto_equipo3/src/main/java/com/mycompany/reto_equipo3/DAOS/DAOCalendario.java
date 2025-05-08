import com.mycompany.reto_equipo3.Calendario;
import com.mycompany.reto_equipo3.DAOS.AccesoABaseDatos;
import com.mycompany.reto_equipo3.DAOS.InterfazDAO;
import com.mycompany.reto_equipo3.Rutas;
import com.mycompany.reto_equipo3.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
        String sql="insert into calendario (fecha,detalles,rutas_idRuta,usuario_idUsuario) values ( ?, ?, ?, ?)";
        try(PreparedStatement pstm=conn.prepareStatement(sql)){
            pstm.setTimestamp(1, Timestamp.valueOf(calendario.getFecha()));
            pstm.setString(2, calendario.getDetalles());
            pstm.setInt(3, ruta.getIdRuta());
            pstm.setInt(4, usu.getIdUsuario());
            if (pstm.executeUpdate()!=1) {
                throw new Exception("ERROR: no se creó la actividad");
            }
        }catch(SQLException ex){
            System.out.println("SQLError: " + ex.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void eliminar(int id) {
      String sql="delete from calendario where idCalendario=?";
      try(PreparedStatement pstm=conn.prepareStatement(sql)){
          pstm.setInt(1, id);
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
        return new Calendario(rs.getInt(1),rs.getTimestamp(2).toLocalDateTime(),rs.getString(3));
    }  
    public List<Calendario> listar(){
        List<Calendario>  calendario= new ArrayList<>();
        String sql = "select idCalendario,fecha,detalles from calendario ";
        try (Statement stmt = conn.createStatement();ResultSet rs=stmt.executeQuery(sql)) {
            while (rs.next()) {
                Calendario calenda = crearCalendario(rs);
                if (!calendario.add(calenda)) {
                    throw new Exception("ERROR: la actividad no se ha añadido.");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return calendario;
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