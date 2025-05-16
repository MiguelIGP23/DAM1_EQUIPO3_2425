/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.Enums.Clasificacion;
import com.mycompany.reto_equipo3.Enums.Tipo;
import com.mycompany.reto_equipo3.PuntosInteres;
import com.mycompany.reto_equipo3.Rutas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase DAO de PuntosInteres para las consultas/modificaciones simples de la base de datos
 * @author Manuel Mediavilla, JavaDoc por Hugo Fernández
 */
public class DAOPuntosinteres {

    private Connection conn;
    /**
     * Constructor por defecto, devuelve la conexión de la base de datos desde el atributo "conn" con los métodos de acceso de la clase
     */
    public DAOPuntosinteres() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
    /**
     * Método insertar para insertar a la base de datos un punto de interés
     * @param puntointeres parámetro que sirve para llamar a dichos getters de la clase PuntosInteres
     * @param ruta parámetro que identificará la id de la ruta a insertar
     * @return boolean si el punto de interés fue insertado correctamente
     */
    public boolean insertar(PuntosInteres puntointeres, int ruta) {
        boolean valida=false;
        String sql = "INSERT INTO puntosinteres (nombre, latitud, longitud, elevacion, descripcion, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntointeres.getNombre());
            stmt.setDouble(2, puntointeres.getLatitud());
            stmt.setDouble(3, puntointeres.getLongitud());
            stmt.setDouble(4, puntointeres.getElevacion()); // Elevación ahora en el orden correcto
            stmt.setString(5, puntointeres.getDescripcion());
            stmt.setInt(6, ruta);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: No se creo el punto de interes");
            }
            valida=true;
            System.out.println("El punto se creo correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valida;
    }
    /**
     * Método modificar para actualizar un punto de interés de la base de datos
     * @param puntointeres parámetro que sirve para llamar a dichos getters de la clase PuntosInteres
     */
    public void modificar(PuntosInteres puntointeres) {
        String sql = "UPDATE puntosinteres SET nombre = ?, latitud = ?, longitud = ?, elevacion = ?, descripcion = ? WHERE idPuntosInteres = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntointeres.getNombre());
            stmt.setDouble(2, puntointeres.getLatitud());
            stmt.setDouble(3, puntointeres.getLongitud());
            stmt.setDouble(4, puntointeres.getElevacion());
            stmt.setString(5, puntointeres.getDescripcion());
            stmt.setInt(6, puntointeres.getIdPuntosInteres());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: No se ha modificado el punto de interes");
            }
            System.out.println("Se modifico el punto de interes");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Método listar para listar en una colección de List de PuntosInteres todos los puntos de interés de la base de datos
     * @param idRuta parámetro que identifica la id de la ruta
     * @return la colección listada en List
     */
    public List<PuntosInteres> listar(int idRuta) {
        List<PuntosInteres> lista = new ArrayList<>();
        PuntosInteres P1 = null;
        String sql = "SELECT idPuntosinteres, nombre, latitud, longitud, elevacion, descripcion FROM puntosinteres where rutas_idRuta=? ";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, idRuta);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    P1 = crearPuntoInteres(rs);
                    if (!lista.add(P1)) {
                        throw new Exception("ERROR: el punto de interes no se anadio");
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
     * Método privado crearPuntoInteres, donde irá creando puntos de interés recogiéndolos desde la base de datos y luego listarlos en el método de listar
     * @param rs parámetro de recogida por consulta en el método listar
     * @return cada objeto PuntosInteres encontrado desde el método listar
     * @throws SQLException podría ocurrir un error en el SQL al realizar el rs
     */
    private PuntosInteres crearPuntoInteres(final ResultSet rs) throws SQLException {
        return new PuntosInteres(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6));
    }
    /**
     * Método eliminar para eliminar un punto de interés de la base de datos
     * @param idPI parámetro que identificará la id del punto de interés para buscar dicho punto de interés a borrar
     * @return boolean si el punto de interés se ha eliminado correctamente
     */
    public boolean eliminar(int idPI) {
        boolean valido=false;
        String sql = "DELETE FROM puntosinteres WHERE idPuntosinteres=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPI);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se borro el punto de interes");
            }
            valido=true;
            System.out.println("Se borro el punto de interes");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valido;
    }
    /**
     * Método buscar para buscar un punto de interés de manera rápida
     * @param nombre parámetro por el que se encontrará desde la consulta select, es decir, con el nombre
     * @return un objeto PuntosInteres, es decir, el punto de interés encontrado
     */
    public PuntosInteres buscar(String nombre) {
        PuntosInteres buscado = null;
        String sql = "SELECT idPuntosinteres, nombre, latitud, longitud, elevacion, descripcion FROM puntosinteres WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buscado = crearPuntoInteres(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: " + e.getMessage());
        }
        return buscado;
    }

    //Metodo DAO completos
    //Devuelve lista con objetos completos
    /**
     * Método que saca toda la información en una List de PuntosInteres de los puntos de interés de la base de datos
     * @param ruta parámetro que sirve para llamar a dichos getters de la clase Rutas
     * @return la colección listada en List
     */
    public List<PuntosInteres> listarTodaInfo(Rutas ruta) {
        List<PuntosInteres> lista = new ArrayList<>();
        PuntosInteres punto = null;
        String sql = "SELECT idPuntosinteres, nombre, latitud, longitud, elevacion, caracteristicas, tipo, descripcion, timestamp FROM puntosinteres where rutas_idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, ruta.getIdRuta());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    punto = crearPuntosInteresTodaInfo(rs);
                    if (!lista.add(punto)) {
                        throw new Exception("ERROR: el punto de interes no se anadio");
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
     * Método privado crearPuntosInteresTodaInfo, donde irá creando puntos de interés recogiéndolos desde la base de datos y luego listarlos en el método de crearPuntosInteresTodaInfo, a excepción de que es en una colección Set
     * @param rs parámetro de recogida por consulta en el método listar
     * @return cada objeto PuntosInteres encontrado desde el método listarTodaInfo
     * @throws SQLException podría ocurrir un error en el SQL al realizar el rs
     */
    private PuntosInteres crearPuntosInteresTodaInfo(final ResultSet rs) throws SQLException {
        Set<String> tipo = new HashSet<>();
        String tipostring = rs.getString("tipo");
        if (tipostring != null && !tipostring.isEmpty()) {
            String[] valores = tipostring.split(",");
            tipo.addAll(List.of(valores));
        }
        Tipo t = Tipo.valueOf(rs.getString("tipo"));
        return new PuntosInteres(
                rs.getInt(1),
                rs.getString(2),
                rs.getDouble(3),
                rs.getDouble(4),
                rs.getDouble(5),
                rs.getString(6),
                t,
                rs.getString(8),
                rs.getInt(9)
        );
    }

    //Busca por nombre y devuelve objeto completo
    /**
     * Método buscar para buscar un punto de interés de manera rápida, a excepción de que es toda su información
     * @param nombre parámetro por el que se encontrará desde la consulta select, es decir, con el nombre
     * @return un objeto PuntosInteres, es decir, el punto de interés encontrado
     */
    public PuntosInteres buscarTodaInfo(String nombre) {
        PuntosInteres buscado = null;
        String sql = "SELECT idPuntosinteres, nombre, latitud, longitud, elevacion, caracteristicas, tipo, descripcion, timestamp FROM puntosinteres WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    buscado = crearPuntoInteres(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: " + e.getMessage());
        }
        return buscado;
    }

    //Insertar completo
    /**
     * Método insertar para insertar a la base de datos un punto de interés, a excepción de que es toda su información
     * @param puntointeres parámetro que sirve para llamar a dichos getters de la clase PuntosInteres
     * @param ruta parámetro que sirve para llamar a dichos getters de la clase Rutas
     */
    public void insertarTodaInfo(PuntosInteres puntointeres, Rutas ruta) {
        String sql = "INSERT INTO puntosinteres (nombre, latitud, longitud, elevacion, caracteristicas, tipo, descripcion, timestamp, rutas_idRuta) VALUES (?, ?, ?, ?, ?, ?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntointeres.getNombre());
            stmt.setDouble(2, puntointeres.getLatitud());
            stmt.setDouble(3, puntointeres.getLongitud());
            stmt.setDouble(4, puntointeres.getElevacion());
            stmt.setString(5, puntointeres.getCaracteristicas());
            String tipo = String.valueOf(puntointeres.getTipo());
            stmt.setString(6, tipo);
            stmt.setString(7, puntointeres.getDescripcion());
            stmt.setInt(8, puntointeres.getTimestamp());
            stmt.setInt(9, ruta.getIdRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: No se creo el punto de interes");
            }
            System.out.println("El punto se creo correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Modificar completo
    /**
     * Método modificar para actualizar un punto de interés de la base de datos, a excepción de que es toda su información
     * @param puntointeres parámetro que sirve para llamar a dichos getters de la clase PuntosInteres
     */
    public void modificarTodaInfo(PuntosInteres puntointeres) {
        String sql = "UPDATE puntosinteres SET nombre = ?, latitud = ?, longitud = ?, elevacion = ?, caracteristicas = ?, tipo = ?, descripcion = ?, timestamp = ? WHERE idPuntosInteres = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, puntointeres.getNombre());
            stmt.setDouble(2, puntointeres.getLatitud());
            stmt.setDouble(3, puntointeres.getLongitud());
            stmt.setDouble(4, puntointeres.getElevacion());
            stmt.setString(5, puntointeres.getCaracteristicas());
            String tipo = String.valueOf(puntointeres.getTipo());
            stmt.setString(6, tipo);
            stmt.setString(7, puntointeres.getDescripcion());
            stmt.setInt(8, puntointeres.getTimestamp());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: No se ha modificado el punto de interes");
            }
            System.out.println("Se modifico el punto de interes");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
