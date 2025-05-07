/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Ficheros;

import com.mycompany.reto_equipo3.Rutas;
import com.mycompany.reto_equipo3.Usuario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
/**
 *
 * @author MiguelIGP-1ºDAM
 */
public class FichaUsuario {

    /**
     * Metodo estatico que genera un archivo llamado ficha-seguridad.txt el cual
     * contiene informacion sobre la dificultad, los puntos de peligro y las
     * recomendaciones de una ruta
     */
    public static boolean generarFicha(Usuario usuario) {
        boolean generada = false;
        //Creamos la carpeta de fichas en el proyecto si no existe
        File carpeta = new File("fichas");
        carpeta.mkdirs();
        //Guarda la ficha en un archivo con el nombre de la ruta
        File ficha = new File("fichas/ficha-usuario" + usuario.getNombre() + "_" + usuario.getApellido() + ".txt");
        //Guardamos las rutas realizadas por el usuario en una lista
        ArrayList<Rutas> rutas = usuario.getRutas();
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(ficha));) {
            bf.write("\t--FICHA DE USUARIO--");
            bf.newLine();
            //Escribimos fecha y hora de generacion de la ficha
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            bf.write(ahora.format(formato));
            bf.newLine();
            bf.write("-Nombre del usuario: " + usuario.getNombre());
            bf.newLine();
            bf.write("-Apellido del usuario: " + usuario.getApellido());
            bf.newLine();
            bf.write("-Email del usuario: " + usuario.getEmail());
            bf.newLine();
            bf.write("-Rutas realizadas:");
            bf.newLine();
            //Recorremos sus rutas realizadas y obtenemos los datos basicos
            Iterator<Rutas> it = rutas.iterator();
            int cont = 1;
            while (it.hasNext()) {
                Rutas aux = it.next();
                bf.write("-Ruta " + (cont++) + ": " + aux.getNombre());
                bf.newLine();
                bf.write("\tCoordenadas iniciales: " + aux.getLatitudInicial() + ", " + aux.getLongitudInicial());
                bf.newLine();
                bf.write("\tCoordenadas finales: " + aux.getLatitudFinal() + ", " + aux.getLongitudFinal());
                bf.newLine();
                bf.write("\t-Distancia: " + aux.getDistancia());
                bf.newLine();
                bf.write("\tDesnivel -> Positivo: " + aux.getDesnivelPositivo() + " -- Negativo: " + aux.getDesnivelNegativo());
                bf.newLine();
                bf.write("\tAltitud -> Maxima: " + aux.getAltitudMax() + " -- Minima: " + aux.getAltitudMin());
                bf.newLine();
                bf.write("\t-Nivel de esfuerzo: " + aux.getNivelEsfuerzo());
                bf.newLine();
                bf.write("\t-Nivel de riesgo: " + aux.getNivelriesgo());
                bf.newLine();
                bf.write("\t-Estado de la ruta: " + aux.getEstadoRuta());
                bf.newLine();
                bf.write("\t-Tipo de terreno: " + aux.getNivelriesgo());
                bf.newLine();
                //Pasamos el obejto set<String> a texto con el metodo String.join
                String temporadas = String.join(",", aux.getTemporada());
                bf.write("\t-Temporadas recomendadas: " + temporadas);
                bf.newLine();
                bf.write("\t-Accesibilidad: " + convierteBoolean(aux.isAccesibilidad()));
                bf.newLine();
                bf.write("\t-Familiar: " + convierteBoolean(aux.isRutaFamiliar()));
                bf.newLine();
                bf.write("\t-Recomendaciones: " + aux.getRecomendaciones());
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
