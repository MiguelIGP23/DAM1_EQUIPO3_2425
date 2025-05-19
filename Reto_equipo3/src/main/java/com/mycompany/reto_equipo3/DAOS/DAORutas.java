/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.DAOS;

import com.mycompany.reto_equipo3.Enums.Clasificacion;
import com.mycompany.reto_equipo3.Rutas;
import com.mycompany.reto_equipo3.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Clase DAO de Rutas para las consultas/modificaciones simples de la base de datos
 * @author Miguel Inglés y Saúl García, JavaDoc por Hugo Fernández
 */
public class DAORutas implements InterfazDAO<Rutas> {

    private Connection conn;
    /**
     * Constructor por defecto, devuelve la conexión de la base de datos desde el atributo "conn" con los métodos de acceso de la clase
     */
    public DAORutas() {
        this.conn = AccesoABaseDatos.getInstance().getConnexion();
    }
    /**
     * Método insertar para insertar a la base de datos una ruta
     * @param ruta parámetro que sirve para llamar a dichos getters de la clase Rutas
     * @param usu parámetro que sirve para llamar a dichos getters de la clase Usuario
     * @return boolean si la ruta fue insertada correctamente
     */
    public boolean insertar(Rutas ruta, Usuario usu) {
        boolean valida=false;
        String sql = "INSERT INTO rutas (nombre, nombre_inicioruta,nombre_finalruta,latitudInicial,latitudFinal,longitudInicial,longitudFinal,distancia,duracion,usuario_idUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ruta.getNombre());
            stmt.setString(2, ruta.getNombre_inicioruta());
            stmt.setString(3, ruta.getNombre_finalruta());
            stmt.setDouble(4, ruta.getLatitudInicial());
            stmt.setDouble(5, ruta.getLatitudFinal());
            stmt.setDouble(6, ruta.getLongitudInicial());
            stmt.setDouble(7, ruta.getLongitudFinal());
            stmt.setDouble(8, ruta.getDistancia());
            stmt.setTime(9, Time.valueOf(ruta.getDuracion()));
            stmt.setInt(10, usu.getIdUsuario());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creo la ruta");
            }
            System.out.println("Se creo correctamente");
            valida=true;
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valida;
    }

    /**
     * Método modificar para actualizar una ruta de la base de datos
     * @param ruta parámetro que sirve para llamar a dichos getters de la clase Rutas
     * @return boolean si la ruta fue modificada correctamente
     */
    public boolean modificarr(Rutas ruta) {
        boolean valida=false;
        String sql = "UPDATE rutas set nombre=?, nombre_inicioruta=?,nombre_finalruta=?,latitudInicial=?,latitudFinal=?,longitudInicial=?,longitudFinal=?,distancia=?,duracion=?,estadoRuta=? WHERE idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ruta.getNombre());
            stmt.setString(2, ruta.getNombre_inicioruta());
            stmt.setString(3, ruta.getNombre_finalruta());
            stmt.setDouble(4, ruta.getLatitudInicial());
            stmt.setDouble(5, ruta.getLatitudFinal());
            stmt.setDouble(6, ruta.getLongitudInicial());
            stmt.setDouble(7, ruta.getLongitudFinal());
            stmt.setDouble(8, ruta.getDistancia());
            stmt.setTime(9, Time.valueOf(ruta.getDuracion()));
            stmt.setBoolean(10, ruta.getEstadoRuta());
            stmt.setInt(11, ruta.getIdRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el usuario");
            }
            valida=true;
            System.out.println("Se modifico el usuario");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valida;
    }
    /**
     * Método para aprobar si una ruta es válida o no
     * @param ruta parámetro que sirve para llamar a dichos getters de la clase Rutas
     * @return boolean si la ruta fue aprobada o no
     */
    public boolean aprobarRuta(Rutas ruta) {
        boolean aprobado = false;
        String sql = "UPDATE rutas SET estadoRuta=1 WHERE idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ruta.getIdRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el usuario");
            }
            aprobado = true;
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return aprobado;
    }
    /**
     * Método listar para listar en una colección de List de Actividad las rutas no aprobadas
     * @return la colección listada en List
     */
    public List<Rutas> listarsinaprobar() {
        List<Rutas> lista = new ArrayList<>();
        Rutas R1 = null;
        String sql = "Select idRuta, nombre, nombre_inicioruta,nombre_finalruta,latitudInicial,latitudFinal,longitudInicial,longitudFinal,distancia,duracion from rutas where estadoRuta=0";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                R1 = crearRutas(rs);
                if (!lista.add(R1)) {
                    throw new Exception("ERROR: el usuario no se añadio");
                }
            }
            System.out.println("Se inserto correctamente todoas las rutas no aprobadas");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    /**
     * Método listar para listar en una colección de List de Actividad las rutas aprobadas
     * @return la colección listada en List
     */
    public List<Rutas> listaraprobadas() {
        List<Rutas> lista = new ArrayList<>();
        Rutas R1;
        String sql = "Select idRuta, nombre, nombre_inicioruta,nombre_finalruta,latitudInicial,latitudFinal,longitudInicial,longitudFinal,distancia,duracion from rutas where estadoRuta=1";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                R1 = crearRutas(rs);
                if (!lista.add(R1)) {
                    throw new Exception("ERROR: el usuario no se añadio");
                }
            }
            System.out.println("Se inserto correctamente todas ls rutas aprobadas");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    /**
     * Método privado crearRutas, donde irá creando rutas recogiéndolas desde la base de datos y luego listarlas en los métodos dichos
     * @param rs parámetro de recogida por consulta en el método listar
     * @return cada objeto Rutas encontrado desde los métodos de listar aprobadas y no aprobadas
     * @throws SQLException podría ocurrir un error en el SQL al realizar el rs
     */
    private Rutas crearRutas(final ResultSet rs) throws SQLException {
        return new Rutas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getTime(10).toLocalTime());
    }

    /**
     * Método eliminar para eliminar una ruta de la base de datos
     * @param idRuta parámetro que identificará la id de la ruta para buscar dicha ruta a borrar
     * @return boolean si la ruta se ha eliminado correctamente
     */
    @Override
    public boolean eliminar(int idRuta) {
        boolean valida=false;
        String sql = "DELETE FROM rutas WHERE idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idRuta);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("No se borrado la ruta");
            }
            System.out.println("Se borro la ruta");
            valida=true;
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valida;
    }
    /**
     * Método buscar para buscar una ruta de manera rápida
     * @param nombre parámetro por el que se encontrará desde la consulta select, es decir, con el nombre
     * @return un objeto Rutas, es decir, la ruta encontrada
     */
    @Override
    public Rutas buscar(String nombre) {
        Rutas buscado = null;
        String sql = "Select idRuta, nombre, nombre_inicioruta,nombre_finalruta,latitudInicial,latitudFinal,longitudInicial,longitudFinal,distancia,duracion from rutas where nombre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    buscado = crearRutas(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: " + e.getMessage());
        }
        return buscado;
    }

    //Metodos DAO completos
    
    //Metpdp listar completo
    /**
     * Método buscar para buscar una actividad de manera rápida, a excepción de que recogerá toda la información con el nombre
     * @param nombre parámetro por el que se encontrará desde la consulta select, es decir, con el nombre
     * @return un objeto Rutas, es decir, la ruta encontrada
     */
    public Rutas buscarTodaInfo(String nombre) {
        Rutas buscado = null;
        String sql = "Select idRuta, nombre, nombre_inicioruta, nombre_finalruta, latitudInicial, latitudFinal, longitudInicial, longitudFinal, distancia, duracion,"
                + "desnivelPositivo, desnivelNegativo, altitudMax, altitudMin, clasificacion, nivelEsfuerzo, nivelRiesgo, estadoRuta, tipoTerreno, indicaciones,"
                + "temporadas, accesibilidad, rutaFamiliar, archivoGPX,recomendacionesEquipo, zonaGeografica, mediaEstrellas from rutas where nombre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    buscado = crearRutasTodaInfo(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: " + e.getMessage());
        }
        return buscado;
    }
    /**
     * Método buscar para buscar una actividad de manera rápida, a excepción de que recogerá toda la información con la id
     * @param id parámetro por el que se encontrará desde la consulta select, es decir, con la id
     * @return un objeto Rutas, es decir, la ruta encontrada
     */
    public Rutas buscarTodaInfo(int id) {
        Rutas buscado = null;
        String sql = "Select idRuta, nombre, nombre_inicioruta, nombre_finalruta, latitudInicial, latitudFinal, longitudInicial, longitudFinal, distancia, duracion,"
                + "desnivelPositivo, desnivelNegativo, altitudMax, altitudMin, clasificacion, nivelEsfuerzo, nivelRiesgo, estadoRuta, tipoTerreno, indicaciones,"
                + "temporadas, accesibilidad, rutaFamiliar, archivoGPX,recomendacionesEquipo, zonaGeografica, mediaEstrellas from rutas where idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    buscado = crearRutasTodaInfo(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLERROR: " + e.getMessage());
        }
        return buscado;
    }

    //Crear ruta
    /**
     * Método privado crearRutasTodaInfo, donde irá creando rutas recogiéndolas desde la base de datos y luego listarlas en el método de crearPuntosInteresTodaInfo, a excepción de que es en una colección Set
     * @param rs parámetro de recogida por consulta en el método listar
     * @return cada objeto Rutas encontrado desde los métodos exclusivos de este método
     * @throws SQLException podría ocurrir un error en el SQL al realizar el rs
     */
    private Rutas crearRutasTodaInfo(final ResultSet rs) throws SQLException {
        Set<String> temporada = new HashSet<>();
        String tempstring = rs.getString("temporadas");
        if (tempstring != null && !tempstring.isEmpty()) {
            String[] valores = tempstring.split(",");
            temporada.addAll(List.of(valores));
        }
        Clasificacion clasificacion = Clasificacion.valueOf(rs.getString("clasificacion").toUpperCase());
        return new Rutas(
                rs.getInt("idRuta"),
                rs.getString("nombre"),
                rs.getString("nombre_inicioruta"),
                rs.getString("nombre_finalruta"),
                rs.getDouble("latitudInicial"),
                rs.getDouble("latitudFinal"),
                rs.getDouble("longitudInicial"),
                rs.getDouble("longitudFinal"),
                rs.getDouble("distancia"),
                rs.getTime("duracion").toLocalTime(),
                rs.getInt("desnivelPositivo"),
                rs.getInt("desnivelNegativo"),
                rs.getDouble("altitudMax"),
                rs.getDouble("altitudMin"),
                clasificacion,
                rs.getInt("nivelEsfuerzo"),
                rs.getInt("nivelRiesgo"),
                rs.getBoolean("estadoRuta"),
                rs.getInt("tipoTerreno"),
                rs.getInt("indicaciones"),
                temporada,
                rs.getBoolean("accesibilidad"),
                rs.getBoolean("rutaFamiliar"),
                rs.getString("archivoGPX"),
                rs.getString("recomendacionesEquipo"),
                rs.getString("zonaGeografica"),
                rs.getDouble("mediaEstrellas")
        );
    }

    //Insertar completo
    /**
     * Método insertar para insertar a la base de datos una ruta, a excepción de que es toda su información
     * @param ruta parámetro que sirve para llamar a dichos getters de la clase Rutas
     * @param usu parámetro que sirve para llamar a dichos getters de la clase Usuario
     */
    public void insertarTodaInfo(Rutas ruta, Usuario usu) {
        String sql = "INSERT INTO rutas (nombre, nombre_inicioruta, nombre_finalruta, latitudInicial, latitudFinal, longitudInicial, longitudFinal, distancia, duracion,"
                + "desnivelPositivo, desnivelNegativo, altitudMax, altitudMin, clasificacion, tipoTerreno, indicaciones,"
                + "temporadas, accesibilidad, rutaFamiliar, archivoGPX,recomendacionesEquipo, zonaGeografica, idUsuario) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ruta.getNombre());
            stmt.setString(2, ruta.getNombre_inicioruta());
            stmt.setString(3, ruta.getNombre_finalruta());
            stmt.setDouble(4, ruta.getLatitudInicial());
            stmt.setDouble(5, ruta.getLatitudFinal());
            stmt.setDouble(6, ruta.getLongitudInicial());
            stmt.setDouble(7, ruta.getLongitudFinal());
            stmt.setDouble(8, ruta.getDistancia());
            stmt.setTime(9, Time.valueOf(ruta.getDuracion()));
            stmt.setInt(10, ruta.getDesnivelPositivo());
            stmt.setInt(11, ruta.getDesnivelNegativo());
            stmt.setDouble(12, ruta.getAltitudMax());
            stmt.setDouble(13, ruta.getAltitudMin());
            String clasif = String.valueOf(ruta.getClasificacion());
            stmt.setString(14, clasif);
            stmt.setInt(15, ruta.getTipoterreno());
            stmt.setInt(16, ruta.getIndicaciones());
            String[] temps=ruta.getTemporada().toArray(String[]::new);
            String temporadas=String.join(", ", temps);
            stmt.setString(17, temporadas);
            stmt.setBoolean(18, ruta.isAccesibilidad());
            stmt.setBoolean(19, ruta.isRutaFamiliar());
            stmt.setString(20, ruta.getArchivoGPX());
            stmt.setString(21, ruta.getRecomendaciones());
            stmt.setString(22, ruta.getZonaGeografica());
            stmt.setInt(23, usu.getIdUsuario());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se creo la ruta");
            }
            System.out.println("Se creo correctamente");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Modificar completo
    /**
     * Método modificar para actualizar una ruta de la base de datos, a exceepción de que recogerá toda su información
     * @param ruta parámetro que sirve para llamar a dichos getters de la clase Rutas
     */
    public void modificarTodaInfo(Rutas ruta) {
        String sql = "UPDATE rutas set nombre=?, nombre_inicioruta=?,nombre_finalruta=?,"
                + "latitudInicial=?,latitudFinal=?,longitudInicial=?,longitudFinal=?,distancia=?,duracion=?,"
                + "desnivelPositivo=?, desnivelNegativo=?, altitudMax=?, altitudMin=?, clasificacion=?, "
                + "estadoRuta=?, tipoTerreno=?, indicaciones=?, temporadas=?, accesibilidad=?, rutaFamiliar=?,"
                + "archivoGPX=?, recomendaciones=? WHERE idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ruta.getNombre());
            stmt.setString(2, ruta.getNombre_inicioruta());
            stmt.setString(3, ruta.getNombre_finalruta());
            stmt.setDouble(4, ruta.getLatitudInicial());
            stmt.setDouble(5, ruta.getLatitudFinal());
            stmt.setDouble(6, ruta.getLongitudInicial());
            stmt.setDouble(7, ruta.getLongitudFinal());
            stmt.setDouble(8, ruta.getDistancia());
            stmt.setTime(9, Time.valueOf(ruta.getDuracion()));
            stmt.setInt(10, ruta.getDesnivelPositivo());
            stmt.setInt(11, ruta.getDesnivelNegativo());
            stmt.setDouble(12, ruta.getAltitudMax());
            stmt.setDouble(13, ruta.getAltitudMin());
            String clasif = String.valueOf(ruta.getClasificacion());
            stmt.setString(14, clasif);
            stmt.setInt(15, ruta.getTipoterreno());
            stmt.setInt(16, ruta.getIndicaciones());
            String[] temps=ruta.getTemporada().toArray(String[]::new);
            String temporadas=String.join(", ", temps);
            stmt.setString(17, temporadas);
            stmt.setBoolean(18, ruta.isAccesibilidad());
            stmt.setBoolean(19, ruta.isRutaFamiliar());
            stmt.setString(20, ruta.getArchivoGPX());
            stmt.setString(21, ruta.getRecomendaciones());
            stmt.setString(22, ruta.getZonaGeografica());
            stmt.setInt(23, ruta.getIdRuta());
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el usuario");
            }
            System.out.println("Se modifico el usuario");
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Método modificar para actualizar una ruta de la base de datos, guiándose de la id
     * @param idRutanovalida parámetro que identifica la id de la Ruta a modificar
     * @return boolean si la ruta fue modificada correctamente
     */
    public boolean modificarporid(int idRutanovalida) {
        boolean valido=false;
        String sql = "UPDATE rutas set estadoRuta=1 WHERE idRuta=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idRutanovalida);
            if (stmt.executeUpdate() != 1) {
                throw new Exception("ERROR: no se ha modificado el usuario");
            }
            System.out.println("Se modifico el usuario");
            valido=true;
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return valido;
    }
    /**
     * Método modificar recogido de la interfaz DAO
     * @param obj 
     * @deprecated método no implementado
     */
    @Deprecated
    @Override
    public void modificar(Rutas obj) {
        //Metodo comun pero no implementado
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
