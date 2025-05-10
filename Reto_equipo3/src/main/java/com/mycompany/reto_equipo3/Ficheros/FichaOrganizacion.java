/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Ficheros;

import com.mycompany.reto_equipo3.Rutas;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MiguelIGP-1ºDAM
 */
public class FichaOrganizacion {

    /**
     * Metodo estatico que genera un archivo llamado ficha-organizacion.txt el
     * cual contiene informacion sobre
     */
    public static boolean generarFicha(Rutas ruta) {
        boolean generada = false;
        //Creamos la carpeta de fichas en el proyecto si no existe
        String nombreRuta = ruta.getNombre().replaceAll("[^a-zA-Z0-9_\\- ]", "_");
        File carpeta = new File("fichas/fichas_"+nombreRuta);
        carpeta.mkdirs();
        //Guarda la ficha en un archivo con el nombre de la ruta
        File ficha = new File("fichas/fichas_"+nombreRuta+"/ficha-organizacion_" + nombreRuta + ".txt");
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(ficha));) {
            bf.write("\t--FICHA DE ORGANIZACION--");
            //Escribimos fecha y hora de generacion de la ficha
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            bf.write("\t\t" + ahora.format(formato));
            bf.newLine();
            bf.newLine();
            bf.write("-Nombre de la ruta: " + ruta.getNombre());
            bf.newLine();
            bf.write("-Coordenadas iniciales: \n\t-Latitud: " + ruta.getLatitudInicial() + "\n\t-Longitud: " + ruta.getLongitudInicial());
            bf.newLine();
            bf.write("-Coordenadas finales: \n\t-Latitud: " + ruta.getLatitudFinal()+ "\n\t-Longitud: " + ruta.getLongitudFinal());
            bf.newLine();
            bf.write("-Dificultad: \n\t-Nivel de riesgo: " + ruta.getNivelriesgo() + "\n\t-Nivel de esfuerzo: " + ruta.getNivelEsfuerzo());
            bf.newLine();
            bf.write("-Inicio de la ruta: " + ruta.getNombre_inicioruta());
            bf.newLine();
            bf.write("-Fin de la ruta: " + ruta.getNombre_finalruta());
            bf.newLine();
            generada = true;
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        return generada;
    }
}
