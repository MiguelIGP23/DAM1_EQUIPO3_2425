/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Ficheros;

import com.mycompany.reto_equipo3.PuntosPeligro;
import com.mycompany.reto_equipo3.Rutas;
import com.mycompany.reto_equipo3.DAOS.DAOPuntospeligro;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Clase que crea un fichero con datos de la ruta para ver la seguridad
 * @author Miguel Inglés, JavaDoc por Hugo Fernández 
 */
public class FichaSeguridad{   
    /**
     * Método que genera un archivo llamado ficha-seguridad_nombreRuta.txt el cual contiene la información de los datos de seguridad de la ruta
     * @param ruta parámetro que se utiliza para llamar métodos de la clase Rutas
     * @return boolean si el fichero ha sido generado o no
     */
    public boolean generarFicha(Rutas ruta) {
        boolean generada = false; //Creamos la carpeta de fichas en el proyecto si no existe
        String nombreRuta = ruta.getNombre().replaceAll("[^a-zA-Z0-9_\\- ]", "_");
        File carpeta = new File("fichas/fichas_" + nombreRuta);
        carpeta.mkdirs();
        //Guarda la ficha en un archivo con el nombre de la ruta
        File ficha = new File("fichas/fichas_" + nombreRuta + "/ficha-seguridad_" + nombreRuta + ".txt");
        //Guardamos los puntos de peligro de la ruta en una lista
        DAOPuntospeligro daopp = new DAOPuntospeligro();
        List<PuntosPeligro> puntosPeligro = daopp.listarTodaInfo(ruta);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(ficha));) {
            bf.write("\t--FICHA DE SEGURIDAD--");
            //Escribimos fecha y hora de generacion de la ficha
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            bf.write("\t\t" + ahora.format(formato));
            bf.newLine();
            bf.newLine();
            bf.write("-Nombre de la ruta: " + ruta.getNombre());
            bf.newLine();
            String reco = ruta.getRecomendaciones();
            if (reco == null) {
                bf.write("-Recomendaciones: ninguna recomendacion");
            } else {
                bf.write("-Recomendaciones: " + reco);
            }
            bf.newLine();
            int nRiesgo = ruta.getNivelriesgo();
            String nr;
            int nEsf = ruta.getNivelEsfuerzo();
            String ne;
            if (nRiesgo == 0) {
                nr = "sin especificar";
            } else {
                nr = String.valueOf(ruta.getNivelriesgo());
            }
            if (nEsf == 0) {
                ne = "sin especificar";
            } else {
                ne = String.valueOf(ruta.getNivelEsfuerzo());
            }
            bf.write("-Dificultad: \n\t-Nivel de riesgo: " + nr + "\n\t-Nivel de esfuerzo: " + ne);
            bf.newLine();
            bf.newLine();
            bf.write("-- PUNTOS DE PELIGRO --");
            bf.newLine();
            bf.newLine();
            //Recorremos sus puntos de peligro y obtenemos los datos
            Iterator<PuntosPeligro> it = puntosPeligro.iterator();
            int cont = 1;
            while (it.hasNext()) {
                PuntosPeligro aux = it.next();
                bf.write("-Punto " + (cont++) + ": " + aux.getNombre());
                bf.newLine();
                String lat=String.format(Locale.US, "%.4f", aux.getLatitud());
                String lon=String.format(Locale.US, "%.4f", aux.getLongitud());
                bf.write("\t-Coordenadas: \n\t\t->Latitud: " +lat+ "\n\t\t->Longitud: " + lon);
                bf.newLine();
                double km = aux.getKilometro();
                String kilo;
                bf.newLine();
                if (km == 0) {
                    kilo = "sin especificar";
                } else {
                    kilo = String.valueOf(aux.getKilometro());
                }
                bf.write("\t-Kilometro de ruta: " + kilo);
                int grav = aux.getGravedad();
                bf.newLine();
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
                bf.newLine();
            }
            generada = true;
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        return generada;
    }
}