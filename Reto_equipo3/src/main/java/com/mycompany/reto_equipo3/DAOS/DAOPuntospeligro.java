/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.PuntosPeligro;
import com.mycompany.reto_equipo3.Rutas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO de PuntosPeligro para las consultas/modificaciones simples de la base de datos
 * @author Saúl García, JavaDoc por Hugo Fernández
 */
public class DAOPuntospeligro implements InterfazDAO<PuntosPeligro> {

    private Connection conn;
    /**
     * Constructor por defecto, devuelve la conexión de la base de datos desde el atributo "conn" con los métodos de acceso de la clase
     */
    public DAOPuntospeligro() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
    /**
     * Método insertar para insertar a la base de datos un punto de peligro
     * @param puntopeligro parámetro que sirve para llamar a dichos getters de la clase PuntosPeligro
     * @param ruta parámetro que identificará la id de la ruta a insertar
     * @return boolean si el punto de peligro fue insertado correctamente
     */
    public boolean insertar(PuntosPeligro puntopeligro,int ruta) {
        boolean valida=false;
        String sql = "INSERT INTO puntospeligro (nombre, latitud, longitud, elevacion, descripcion, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setDouble(4, puntopeligro.getElevacion());
            stmt.setString(5, puntopeligro.getDescripcion());
            stmt.setInt(6, ruta);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creo el punto de peligro");
            }
            valida=true;
            System.out.println("El punto se ceo correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valida;
    }
    /**
     * Método modificar para actualizar un punto de peligro de la base de datos
     * @param puntopeligro parámetro que sirve para llamar a dichos getters de la clase PuntosPeligro 
     */
    @Override
    public void modificar(PuntosPeligro puntopeligro) {
        String sql = "UPDATE puntospeligro SET nombre = ?, latitud = ?, longitud = ?, elevacion = ?, descripcion = ? WHERE idPuntospeligro = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setDouble(4, puntopeligro.getElevacion());
            stmt.setString(5, puntopeligro.getDescripcion());
            stmt.setInt(6, puntopeligro.getIdPuntospeligro());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el punto de peligro");
            }
            System.out.println("Se modificó el punto de peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Método listar para listar en una colección de List de PuntosPeligro todos los puntos de peligro de la base de datos
     * @param id parámetro que identifica la id de la ruta
     * @return la colección listada en List
     */
    public List<PuntosPeligro> listar(int id) {
        List<PuntosPeligro> lista = new ArrayList<>();
        PuntosPeligro P1;
        String sql = "SELECT idPuntospeligro, nombre, latitud, longitud, elevacion, descripcion FROM puntospeligro where rutas_idRuta=? ";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()) {
                    P1 = crearPuntoPeligro(rs);
                    if (!lista.add(P1)) {
                        throw new Exception("ERROR: el punto de peligro no se agrego");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    /**
     * Método privado crearPuntoPeligro, donde irá creando puntos de peligro recogiéndolos desde la base de datos y luego listarlos en el método de listar
     * @param rs parámetro de recogida por consulta en el método listar
     * @return cada objeto PuntosPeligro encontrado desde el método listar
     * @throws SQLException podría ocurrir un error en el SQL al realizar el rs
     */
    private PuntosPeligro crearPuntoPeligro(final ResultSet rs) throws SQLException {
        return new PuntosPeligro(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6));
    }

    /**
     * Método eliminar para eliminar un punto de peligro de la base de datos
     * @param idpp parámetro que identificará la id del punto de peligro para buscar dicho punto de peligro a borrar
     * @return boolean si el punto de peligro se ha eliminado correctamente
     */
    @Override
    public boolean eliminar(int idpp) {
        boolean valido=false;
        String sql = "DELETE FROM puntospeligro WHERE idPuntospeligro=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idpp);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se borro el punto de peligro");
            }
            System.out.println("Se borro el punto de peligro");
            valido=true;
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valido;
    }
    /**
     * Método buscar para buscar un punto de peligro de manera rápida
     * @param nombre parámetro por el que se encontrará desde la consulta select, es decir, con el nombre
     * @return un objeto PuntosPeligro, es decir, el punto de peligro encontrado
     */
    @Override
    public PuntosPeligro buscar(String nombre) {
        PuntosPeligro buscado = null;
        String sql = "SELECT idPuntosPeligro, nombre, latitud, longitud, elevacion, descripcion FROM puntospeligro WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buscado = crearPuntoPeligro(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: "+e.getMessage());
        }
        return buscado;
    }
    
    //Metodo listar crear y buscar completos y funcionales usados en fichas
    //Devuelve lista con objetos completos
    /**
     * Método que saca toda la información en una List de PuntosPeligro de los puntos de peligro de la base de datos
     * @param ruta parámetro que sirve para llamar a dichos getters de la clase Rutas
     * @return la colección listada en List
     */
    public List<PuntosPeligro> listarTodaInfo(Rutas ruta) {
        List<PuntosPeligro> lista = new ArrayList<>();
        PuntosPeligro punto;
        String sql = "SELECT idPuntospeligro, nombre, latitud, longitud, elevacion, kilometros, gravedad, posicion, descripcion, timestamp FROM puntospeligro where rutas_idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, ruta.getIdRuta());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    punto = crearPuntosPeligroTodaInfo(rs, ruta);
                    if (!lista.add(punto)) {
                        throw new Exception("ERROR: el punto de peligro no se anadio");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    
    //Crea el objeto completo
    /**
     * Método privado crearPuntosPeligroTodaInfo, donde irá creando puntos de peligro recogiéndolos desde la base de datos y luego listarlos en el método de crearPuntosInteresTodaInfo
     * @param rs parámetro de recogida por consulta en el método listar
     * @param ruta parámetro que sirve para llamar a dichos getters de la clase Rutas
     * @return cada objeto PuntosPeligro encontrado desde el método listarTodaInfo
     * @throws SQLException podría ocurrir un error en el SQL al realizar el rs
     */
    private PuntosPeligro crearPuntosPeligroTodaInfo(final ResultSet rs, Rutas ruta) throws SQLException {
        return new PuntosPeligro(
                rs.getInt(1),
                rs.getString(2),
                rs.getDouble(3),
                rs.getDouble(4),
                rs.getDouble(5),
                rs.getInt(6),
                rs.getInt(7),
                rs.getInt(8),
                rs.getString(9),
                rs.getInt(10), 
                ruta.getIdRuta()
        );
    }
    
    //Busca por nombre y devuelve objeto completo
    /**
     * Método buscar para buscar un punto de peligro de manera rápida, a excepción de que es toda su información
     * @param nombre parámetro por el que se encontrará desde la consulta select, es decir, con el nombre
     * @param ruta parámetro que identifica el objeto ruta
     * @return un objeto PuntosPeligro, es decir, el punto de peligro encontrado
     */
    public PuntosPeligro buscarTodaInfo(String nombre, Rutas ruta) {
        PuntosPeligro buscado = null;
        String sql = "SELECT idPuntospeligro, nombre, latitud, longitud, elevacion, kilometros, gravedad, posicion, descripcion, timestamp FROM puntospeligro where nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buscado = crearPuntosPeligroTodaInfo(rs, ruta);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: " + e.getMessage());
        }
        return buscado;
    }
    
    //IInsertar completo
    /**
     * Método insertar para insertar a la base de datos un punto de peligro, a excepción de que es toda su información
     * @param puntopeligro parámetro que sirve para llamar a dichos getters de la clase PuntosPeligro
     * @param ruta parámetro que sirve para llamar a dichos getters de la clase Rutas
     */
    public void insertarTodaInfo(PuntosPeligro puntopeligro, Rutas ruta) {
        String sql = "INSERT INTO puntospeligro (nombre, latitud, longitud, elevacion, kilometro, gravedad, posicion, descripcion, timestamp, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setDouble(4, puntopeligro.getElevacion());
            stmt.setDouble(5, puntopeligro.getKilometro());
            stmt.setInt(6, puntopeligro.getGravedad());
            stmt.setInt(7, puntopeligro.getPosicion());
            stmt.setString(8, puntopeligro.getDescripcion());
            stmt.setInt(9, puntopeligro.getTimestamp());
            stmt.setInt(10, ruta.getIdRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creo el punto de peligro");
            }
            System.out.println("El punto se ceo correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Modificar completo
    /**
     * Método modificar para actualizar un punto de peligro de la base de datos, a excepción de que es toda su información
     * @param puntopeligro parámetro que sirve para llamar a dichos getters de la clase PuntosPeligro
     */
    public void modificarTodaInfo(PuntosPeligro puntopeligro) {
        String sql = "UPDATE puntospeligro SET nombre = ?, latitud = ?, longitud = ?, elevacion = ?, kilometro = ?, gravedad = ?, posicion = ?, descripcion = ?, timestamp = ? WHERE idPuntospeligro = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntopeligro.getNombre());
            stmt.setDouble(2, puntopeligro.getLatitud());
            stmt.setDouble(3, puntopeligro.getLongitud());
            stmt.setDouble(4, puntopeligro.getElevacion());
            stmt.setDouble(5, puntopeligro.getKilometro());
            stmt.setInt(6, puntopeligro.getGravedad());
            stmt.setInt(7, puntopeligro.getPosicion());
            stmt.setString(8, puntopeligro.getDescripcion());
            stmt.setInt(9, puntopeligro.getTimestamp());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el punto de peligro");
            }
            System.out.println("Se modificó el punto de peligro");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
