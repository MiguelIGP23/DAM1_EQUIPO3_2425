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
 * Clase DAO de Valora para las consultas/modificaciones simples de la base de datos
 * @author Miguel Inglés, JavaDoc por Hugo Fernández
 */
public class DAOValora implements InterfazDAO<Valora> {

    private Connection conn;
    /**
     * Constructor por defecto, devuelve la conexión de la base de datos desde el atributo "conn" con los métodos de acceso de la clase
     */
    public DAOValora() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
    /**
     * Método insertar para insertar a la base de datos una valoración
     * @param valora parámetro que sirve para llamar a dichos getters de la clase Valora
     * @param usu parámetro que sirve para llamar a dichos getters de la clase Usuario
     * @param idRuta parámetro que identifica la id de la ruta
     * @return boolean si la valoración fue insertada correctamente
     */
    public boolean insertar(Valora valora, Usuario usu, int idRuta) {
        boolean valido=false;
        String sql = "INSERT INTO valora (dificultad, fecha, estrellas, interesCultural, belleza, usuario_idUsuario, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, valora.getDificultad());
            stmt.setDate(2, Date.valueOf(valora.getFecha()));
            stmt.setInt(3, valora.getEstrellas());
            stmt.setInt(4, valora.getInteresCultural());
            stmt.setInt(5, valora.getBelleza());
            stmt.setInt(6, usu.getIdUsuario());
            stmt.setInt(7, idRuta);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creo la valoracion");
            }
            System.out.println("Se creo la valoracion");
            valido=true;
        } catch (SQLException e) {
            System.out.println("SQL ERROR: ruta ya valorada por el usuario");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valido;
    }
    /**
     * Método modificar para actualizar una valoración de la base de datos
     * @param valora parámetro que sirve para llamar a dichos getters de la clase Valora
     */
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
    /**
     * Método listar para listar en una colección de List de Valora todas las valoraciones de la base de datos
     * @param id parámetro que identifica la id de la ruta
     * @return la colección listada en List
     */
    public List<Valora> listar(int id) {
        List<Valora> lista = new ArrayList<>();
        Valora v;
        String sql = "SELECT idValora, dificultad, fecha, estrellas, interesCultural, belleza FROM valora where rutas_idRuta = ? ";
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
    /**
     * Método privado crearValoracion, donde irá creando valoraciones recogiéndolas desde la base de datos y luego listarlas en el método de listar
     * @param rs parámetro de recogida por consulta en el método listar
     * @return cada objeto Valora encontrado desde el método listar
     * @throws Exception podría ocurrir un error en el SQL al realizar el rs
     */
    private Valora crearValoracion(final ResultSet rs) throws Exception {
        return new Valora(rs.getInt(1), rs.getInt(2), rs.getDate(3).toLocalDate(), rs.getInt(4), rs.getInt(5), rs.getInt(6));
    }
    /**
     * Método eliminar para eliminar una valoración de la base de datos
     * @param idValora parámetro que identificará la id de la valoración para buscar dicha valoración a borrar
     * @return boolean si la valoración se ha eliminado correctamente
     */
    @Override
    public boolean  eliminar(int idValora) {
        boolean valido=false;
        String sql = "DELETE FROM valora WHERE idValora=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idValora);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: la valoracion no existe");
            }
            valido=true;
            System.out.println("Se elimino la valoracion");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valido;
    }
    /**
     * Método buscar para buscar una valoración de manera rápida
     * @param id parámetro por el que se encontrará desde la consulta select, es decir, con la id de la valoración
     * @return un objeto Valora, es decir, la valoración encontrada
     */
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
    /**
     * Método buscar recogido de la interfaz DAO
     * @param email
     * @return 
     * @deprecated método no implementado
     */
    @Deprecated
    @Override
    public Valora buscar(String email) {
        //Metodo comun pero no implementado
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
