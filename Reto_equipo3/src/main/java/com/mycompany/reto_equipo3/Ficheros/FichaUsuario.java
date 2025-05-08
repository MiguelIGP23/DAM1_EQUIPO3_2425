/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Ficheros;

import com.mycompany.reto_equipo3.PuntosInteres;
import com.mycompany.reto_equipo3.PuntosPeligro;
import com.mycompany.reto_equipo3.Rutas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author MiguelIGP-1ºDAM
 */
public class FichaUsuario {

    /**
     * Metodo estatico que genera un archivo llamado
     * ficha-usuario_nombre_apellido.txt el cual contiene informacion sobre la
     * dificultad, los puntos de peligro y las recomendaciones de una ruta
     *
     * @param ruta objeto ruta sobre la que se genera la ficha
     * @return true/false indicando si se genero la ficha o no
     */
    public static boolean generarFicha(Rutas ruta) {
        boolean generada = false;
        //Creamos la carpeta de fichas en el proyecto si no existe
        File carpeta = new File("fichas");
        carpeta.mkdirs();
        //Guarda la ficha en un archivo con el nombre de la ruta
        File ficha = new File("fichas/ficha-usuario_" + ruta.getNombre() + ".txt");
        //Guardamos las rutas realizadas por el usuario en una lista
        ArrayList<PuntosInteres> puntosInteres = ruta.getPuntosInteres();
        ArrayList<PuntosPeligro> puntosPeligro = ruta.getPuntosPeligro();
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(ficha));) {
            bf.write("\t--FICHA DE USUARIO--");
            bf.newLine();
            //Escribimos fecha y hora de generacion de la ficha
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            bf.write(ahora.format(formato));
            bf.newLine();
            bf.write("-Nombre de ruta: " + ruta.getNombre());
            bf.newLine();
            bf.write("-Nombre inicio ruta: " + ruta.getNombre_inicioruta());
            bf.write("-Nombre final ruta: " + ruta.getNombre_finalruta());
            bf.write("-Coordenadas iniciales: " + ruta.getLatitudInicial() + ", " + ruta.getLongitudInicial());
            bf.write("-Coordenadas finales: " + ruta.getLatitudFinal() + ", " + ruta.getLongitudFinal());
            bf.write("-Distancia : " + ruta.getDistancia());
            bf.write("-Duracion estimada: " + ruta.getDuracion());
            bf.newLine();
            //Pasamos el obejto set<String> a texto con el metodo String.join
            String temporadas = String.join(",", ruta.getTemporada());
            bf.write("\t-Temporadas recomendadas: " + temporadas);
            bf.newLine();
            bf.write("\t-Accesibilidad: " + convierteBoolean(ruta.isAccesibilidad()));
            bf.newLine();
            bf.write("\t-Familiar: " + convierteBoolean(ruta.isRutaFamiliar()));
            bf.newLine();
            bf.write("\t-Recomendaciones: " + ruta.getRecomendaciones());
            bf.newLine();
            bf.write("-Puntos de interes la ruta:");
            bf.newLine();
            //Recorremos sus puntos y obtenemos los datos basicos
            Iterator<PuntosInteres> itPInteres = puntosInteres.iterator();
            int cont = 1;
            while (itPInteres.hasNext()) {
                PuntosInteres aux = itPInteres.next();
                bf.write("-Punto 1 " + (cont++) + ": " + aux.getNombre());
                bf.newLine();
                bf.write("\tCoordenadas: " + aux.getLatitud() + ", " + aux.getLongitud());
                bf.newLine();
                bf.write("\t-Caracteristicas: " + aux.getCaracteristicas());
                bf.newLine();
                bf.write("\t-Tipo: " + aux.getTipo());
                bf.newLine();
                bf.write("\t-Descripcion: " + aux.getDescripcion());
                bf.newLine();
                bf.write("\t-Elevacion: " + aux.getElevacion());
                bf.newLine();
                bf.write("\t-Tiempo de llegada: " + aux.getTimestamp());
                bf.newLine();
            }
            bf.write("\n-Puntos de peligro de la ruta:");
            Iterator<PuntosPeligro> itPPeligro = puntosPeligro.iterator();
            cont = 1;
            while (itPPeligro.hasNext()) {
                PuntosPeligro aux = itPPeligro.next();
                bf.write("-Punto " + (cont++) + ": " + aux.getNombre());
                bf.newLine();
                bf.write("\tCoordenadas: " + aux.getLatitud() + ", " + aux.getLongitud());
                bf.newLine();
                bf.write("\t-Kilometro de ruta: " + aux.getKilometro());
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

    //Metodo privado para convertir booleanos a texto si o no para codigo mas limpio
    private static String convierteBoolean(boolean b) {
        String st = "";
        if (b) {
            st = "si";
        } else if (!b) {
            st = "no";
        }
        return st;
    }
}
