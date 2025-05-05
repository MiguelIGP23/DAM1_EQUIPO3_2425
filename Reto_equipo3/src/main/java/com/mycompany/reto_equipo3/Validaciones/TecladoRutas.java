/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Validaciones;

import java.util.Scanner;

/**
 *
 * Clase dedicada a realizar las validaciones de la clase Rutas
 * 
 * @author DAM123
 */
public class TecladoRutas {
    
    //Valida que nombre de ruta tenga 20 caracteres y comience por mayuscula
    public static String validanombre(String texto) {
        boolean valido = false;
        String nombre = null;
        do {
            try {
                System.out.println(texto);
                nombre = new Scanner(System.in).nextLine();
                if (!nombre.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,19}")) {
                    throw new Exception("Introduce un nombre valido de maximo de 20 caracteres");
                }
                valido = true;

            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return nombre;
    }
    
    //Valida que nombre de inicio ruta y final ruta tenga 45 caracteres
    public static String validaInicioFinalRuta(String texto) {
        boolean valido = false;
        String nombre = null;
        do {
            try {
                System.out.println(texto);
                nombre = new Scanner(System.in).nextLine();
                if (!nombre.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,19}")) {
                    throw new Exception("Introduce un nombre valido de maximo de 20 caracteres");
                }
                valido = true;

            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return nombre;
    }
    
    //Comprueba que latitud y longitud sean numericos
    public static double validaCoordenadas(int valor){
        boolean valido=false;
        double latitud=0;
        do{
            try{
                latitud= new Scanner(System.in).nextDouble();
            }catch (ArithmeticException e){
                System.out.println("ERROR: el valor introducido debe ser numerico");
            }
        }while(!valido);
        return latitud;
    }
    
    //
}
