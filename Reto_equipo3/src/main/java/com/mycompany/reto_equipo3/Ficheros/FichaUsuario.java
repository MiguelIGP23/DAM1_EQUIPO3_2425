/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Ficheros;

import com.mycompany.reto_equipo3.DAOS.DAOPuntosinteres;
import com.mycompany.reto_equipo3.DAOS.DAOPuntospeligro;
import com.mycompany.reto_equipo3.Enums.Tipo;
import com.mycompany.reto_equipo3.PuntosInteres;
import com.mycompany.reto_equipo3.PuntosPeligro;
import com.mycompany.reto_equipo3.Rutas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Iterator;

/**
 * Clase que crea un fichero con datos de la ruta para ver los datos de usuario
 * @author Miguel Inglés, JavaDoc por Hugo Fernández 
 */

public class FichaUsuario {

    /**
     * Método que genera un archivo llamado ficha-usuario_nombre_apellido.txt el cual contiene la información de los datos de usuario de la ruta
     * @param ruta parámetro que se utiliza para llamar métodos de la clase Rutas
     * @return boolean si el fichero ha sido generado o no
     */
    public  boolean generarFicha(Rutas ruta) {
        boolean generada = false;
        //Creamos la carpeta de fichas en el proyecto si no existe
        String nombreRuta = ruta.getNombre().replaceAll("[^a-zA-Z0-9_\\- ]", "_");
        File carpeta = new File("fichas/fichas_" + nombreRuta);
        carpeta.mkdirs();
        //Guarda la ficha en un archivo con el nombre de la ruta
        File ficha = new File("fichas/fichas_" + nombreRuta + "/ficha-usuario_" + nombreRuta + ".txt");
        //Guardamos las rutas realizadas por el usuario en una lista
        DAOPuntosinteres daopi = new DAOPuntosinteres();
        DAOPuntospeligro daopp = new DAOPuntospeligro();
        List<PuntosInteres> puntosInteres = daopi.listarTodaInfo(ruta);
        List<PuntosPeligro> puntosPeligro = daopp.listarTodaInfo(ruta);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(ficha));) {
            bf.write("\t--FICHA DE USUARIO--");
            //Escribimos fecha y hora de generacion de la ficha
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            bf.write("\t\t" + ahora.format(formato) + "\n");
            bf.newLine();
            bf.write("-Nombre de ruta: " + ruta.getNombre());
            bf.newLine();
            bf.write("-Inicio de la ruta: " + ruta.getNombre_inicioruta());
            bf.newLine();
            bf.write("-Fin de la ruta: " + ruta.getNombre_finalruta());
            bf.newLine();
            bf.write("-Coordenadas iniciales: \n\t-Latitud: " + ruta.getLatitudInicial() + "\n\t-Longitud: " + ruta.getLongitudInicial());
            bf.newLine();
            bf.write("-Coordenadas finales: \n\t-Latitud: " + ruta.getLatitudFinal() + "\n\t-Longitud: " + ruta.getLongitudFinal());
            bf.newLine();
            String st = "-Duracion estimada: ";
            int horas = ruta.getDuracion().getHour();
            int minutos = ruta.getDuracion().getMinute();
            if (horas == 0) {
                st += minutos + " min";
            } else {
                st += +horas + " h, " + minutos + " min";
            }
            bf.write(st);
            bf.newLine();
            bf.write("-Distancia : " + ruta.getDistancia() + " km");
            bf.newLine();
            bf.write("-Temporadas: ");
            //Pasamos el set<String> temporadas a un Array de Strings que contiene los valores
            String[] temps= ruta.getTemporada().toArray(length -> new String[length]);    
            //String.join junta los campos de la lista separados por el delimitador ", "
            String temporadas=String.join(", ", temps);
            bf.write(temporadas);

//            //Obtener String del set<String> sin programacion funcional
//            int tam=ruta.getTemporada().size();
//            String[] temps= ruta.getTemporada().toArray(new String[tam]);
//            String temporadas="-Temporadas: ";
//            for(int i=0; i<temps.length; i++){
//                temporadas+=temps[i];
//                if(i<temps.length-1){
//                    temporadas+=", ";
//                }
//            }
//            bf.write(temporadas);

            bf.newLine();
            bf.write("-Accesible: " + convierteBoolean(ruta.isAccesibilidad()));
            bf.newLine();
            bf.write("-Familiar: " + convierteBoolean(ruta.isRutaFamiliar()));
            bf.newLine();
            String recom = ruta.getRecomendaciones();
            if (recom == null) {
                bf.write("-Recomendaciones: ninguna recomendacion");
            } else {
                bf.write("-Recomendaciones: " + recom);
            }
            bf.newLine();
            bf.newLine();
            bf.write("-- PUNTOS DE INTERES --");
            bf.newLine();
            bf.newLine();
            //Recorremos sus puntos y obtenemos los datos basicos
            Iterator<PuntosInteres> itPInteres = puntosInteres.iterator();
            int cont = 1;
            while (itPInteres.hasNext()) {
                PuntosInteres aux = itPInteres.next();
                bf.write("*Punto " + cont + ": " + aux.getNombre());
                cont++;
                bf.newLine();
                bf.write("\t-Coordenadas: \n\t\t-Latitud: " + aux.getLatitud() + "\n\t\t-Longitud: " + aux.getLongitud());
                bf.newLine();
                String carac = aux.getCaracteristicas();
                if (carac == null) {
                    bf.write("\t-Caracteristicas: ninguna indicada");
                } else {
                    bf.write("\t-Caracteristicas: " + carac);
                }
                bf.newLine();
                Tipo tipo = aux.getTipo();
                String tp;
                if (tipo == null) {
                    tp = "\t-Tipo: no indicado";
                } else {
                    tp = "\t-Tipo: " + String.valueOf(tipo);
                }
                bf.write(tp);
                bf.newLine();
                bf.write("\t-Descripcion: " + aux.getDescripcion());
                bf.newLine();
                bf.write("\t-Elevacion: " + aux.getElevacion() + " metros");
                bf.newLine();
                int timestamp = aux.getTimestamp();
                String ts = String.valueOf(timestamp);
                if (timestamp == 0) {
                    ts = "\t-Llegada aproximada: no indicado";
                } else {
                    ts = "\t-Llegada aproximada: " + ts + " min";
                }
                bf.write(ts);
                bf.newLine();
                bf.newLine();
            }
            bf.newLine();
            bf.write("-- PUNTOS DE PELIGRO --");
            bf.newLine();
            bf.newLine();
            Iterator<PuntosPeligro> itPPeligro = puntosPeligro.iterator();
            cont = 1;
            while (itPPeligro.hasNext()) {
                PuntosPeligro aux = itPPeligro.next();
                bf.write("-Punto " + (cont++) + ": " + aux.getNombre());
                bf.newLine();
                bf.write("\t-Coordenadas: \n\t\t->Latitud: " + aux.getLatitud() + "\n\t\t->Longitud: " + aux.getLongitud());
                bf.newLine();
                double km = aux.getKilometro();
                bf.newLine();
                String kilo;
                if (km == 0) {
                    kilo = "sin especificar";
                } else {
                    kilo = String.valueOf(aux.getKilometro());
                }
                bf.write("\t-Longitud de la ruta: " + kilo + " km");
                bf.newLine();
                int grav = aux.getGravedad();
                String gr;
                if (grav == 0) {
                    gr = "sin especificar";
                } else {
                    gr = String.valueOf(aux.getGravedad());
                }
                bf.write("\t-Nivel de gravedad [1-5]: " + gr);
                bf.newLine();
                bf.write("\t-Descripcion: " + aux.getDescripcion());
                bf.newLine();
                bf.write("\t-Duracion estimada: " + aux.getTimestamp() + " minutos");
                bf.newLine();
            }
            generada = true;
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        return generada;
    }
    /**
     * Metodo privado para convertir booleanos a texto si o no para código mas limpio
     * @param b parámetro booleano a transformar
     * @return String, un "si" o un "no"
     */
    private String convierteBoolean(boolean b) {
        String st = "";
        if (b) {
            st = "si";
        } else if (!b) {
            st = "no";
        }
        return st;
    }
}
