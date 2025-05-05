/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Validaciones;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mycompany.reto_equipo3.Enums.Clasificacion;
import java.util.LinkedHashSet;
import java.util.Set;

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
    public static double validaCoordenadas(String texto) {
        boolean valido = false;
        double latitud = 0;
        do {
            try {
                System.out.println(texto);
                latitud = new Scanner(System.in).nextDouble();
                valido = true;
            } catch (ArithmeticException e) {
                System.out.println("ERROR: el valor introducido debe ser numerico");
            }
        } while (!valido);
        return latitud;
    }

    //Comrpueba que la duracion siga el patron dado {hh:mm:ss}
    public static LocalTime validaDuracion(String texto) {
        boolean valido = false;
        LocalTime duracion = null;
        do {
            try {
                System.out.println(texto);
                DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:mm:ss");
                duracion = LocalTime.parse(new Scanner(System.in).nextLine(), f);
                valido = true;
            } catch (DateTimeParseException e) {
                System.out.println("ERROR: foramto no valido");
            }
        } while (!valido);
        return duracion;
    }

    //Comprueba que el desnivel positivo sea mayor que 0
    public static int validaDesnivelPositivo(String texto) {
        boolean valido = false;
        int desnivelPositivo = 0;
        do {
            try {
                System.out.println(texto);
                desnivelPositivo = new Scanner(System.in).nextInt();
                if (desnivelPositivo <= 0) {
                    throw new Exception("ERROR: el numero debe ser positivo");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: el valor introducido debe ser numerico y entero");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!valido);
        return desnivelPositivo;
    }

    //Comprueba que el desnivel positivo sea mayor que 0
    public static int validaDesnivelNegativo(String texto) {
        boolean valido = false;
        int desnivelNegativo = 0;
        do {
            try {
                System.out.println(texto);
                desnivelNegativo = new Scanner(System.in).nextInt();
                if (desnivelNegativo >= 0) {
                    throw new Exception("ERROR: el numero debe ser negativo");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: el valor introducido debe ser numerico y entero");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!valido);
        return desnivelNegativo;
    }

    //Comprueba que la clasificacion tenga uno de los valores dados en el enum
    public static Clasificacion validaClasificacion(String texto) {
        boolean valido = false;
        Clasificacion clasificacion = null;
        do {
            System.out.println(texto);
            String clas = new Scanner(System.in).nextLine().toLowerCase();
            switch (clas) {
                case "circular" -> {
                    clasificacion = Clasificacion.CIRCULAR;
                }
                case "lineal" -> {
                    clasificacion = Clasificacion.LINEAL;
                }
                default -> {
                    System.out.println("ERROR: valor no valido, elige circular o lineal");
                }
            }
        } while (!valido);
        return clasificacion;
    }

    //Comprueba que el valor introducido este entre 1 y 5
    public static int validaRango1a5(String texto) {
        boolean valido = false;
        int valor = 0;
        do {
            try {
                System.out.println(texto);
                valor = new Scanner(System.in).nextInt();
                if (valor < 1 || valor > 5) {
                    throw new Exception("ERROR: el valor debe estar entre 1 y 5");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: el valor debe ser numerico");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!valido);
        return valor;
    }

    //Buscar como implementar una validacion para la clase Set<String>
    public static Set<String> validaTemporada() {
        Set<String> temporadasValidas = Set.of("primavera", "verano", "otoño", "invierno");
        boolean valido = false;
        Set<String> temporadas = new LinkedHashSet<>();
        System.out.println("Introduce una o mas temporadas separadas por comas (primevera,verano,otoño,invierno)");
        do {
            String temp = new Scanner(System.in).nextLine();
            //Separamos por las comas
            String[] partes = temp.split(",");
            //Lo guardamos en el Set<String>
            for (String parte : partes) {
                temporadas.add(parte.trim().toLowerCase());
            }
            //Copiamos la lista de temporadas a otro Set<String> y eliminamos las estaciones validas
            Set<String> noValidas = new LinkedHashSet<>(temporadas);
            noValidas.removeAll(temporadasValidas);
            //Comprobamos si queda alguna temporada en la lista
            if (noValidas.isEmpty()) {
                valido = true;
            } else {
                System.out.println("ERROR: temporada no valida (primavera,verano,otoño,invierno");
            }
        } while (!valido);
        return temporadas;
    }

}
