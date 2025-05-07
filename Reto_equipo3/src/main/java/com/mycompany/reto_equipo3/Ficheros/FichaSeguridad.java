/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Ficheros;

import com.mycompany.reto_equipo3.PuntosPeligro;
import com.mycompany.reto_equipo3.Rutas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *
 * @author MiguelIGP-1ºDAM
 */
public class FichaSeguridad {

    /**
     * Metodo estatico que genera un archivo llamado ficha-seguridad_nombreRuta.txt el cual
     * contiene informacion sobre la dificultad, los puntos de peligro y las
     * recomendaciones de una ruta
     * @param ruta
     * @return 
     */
    public static boolean generarFicha(Rutas ruta) {
        boolean generada = false;
        //Creamos la carpeta de fichas en el proyecto si no existe
        File carpeta = new File("fichas");
        carpeta.mkdirs();
        //Guarda la ficha en un archivo con el nombre de la ruta
        File ficha = new File("fichas/ficha-seguridad_"+ruta.getNombre()+".txt");
        //Guardamos los puntos de peligro de la ruta en una lista
        LinkedHashSet<PuntosPeligro> puntosPeligro = ruta.getPuntosPeligro();
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(ficha));) {
            bf.write("\t--FICHA DE SEGURIDAD--");
            bf.newLine();
            //Escribimos fecha y hora de generacion de la ficha
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            bf.write("-Ficha generada -> "+ahora.format(formato));
            bf.newLine();
            bf.write("-Nombre de la ruta: " + ruta.getNombre());
            /**
             * Calcular media de dificultades en tabla valora y añadir al archivo
             */
            bf.newLine();
            bf.write("-Puntos de peligro:");
            bf.newLine();
            //Recorremos sus puntos de peligro y obtenemos los datos
            Iterator<PuntosPeligro> it = puntosPeligro.iterator();
            int cont = 1;
            while (it.hasNext()) {
                PuntosPeligro aux = it.next();
                bf.write("-Punto " + (cont++) + ": " + aux.getNombre());
                bf.newLine();
                bf.write("\tCoordenadas: " + aux.getLatitud() + ", " + aux.getLongitud());
                bf.newLine();
                bf.write("\t-Kilometro de ruta: " + aux.getKilometros());
                bf.newLine();
                bf.write("\tNivel de gravedad [1-5]: " + aux.getGravedad());
                bf.newLine();
                bf.write("\t-Descripcion: " + aux.getDescripcion());
                bf.newLine();
                bf.write("\t-Duracion estimada: " + aux.getTimestamp() + " minutos");
                bf.newLine();
                generada = true;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        return generada;
    }
}
