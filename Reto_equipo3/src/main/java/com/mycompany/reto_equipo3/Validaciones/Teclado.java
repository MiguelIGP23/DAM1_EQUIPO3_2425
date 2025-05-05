/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Validaciones;

import com.mycompany.reto_equipo3.Enums.Roles;
import java.util.Scanner;

/**
 *
 * @author DAM121
 */
public class Teclado {

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

    public static String validaapellido(String texto) {
        boolean valido = false;
        String apellido = null;
        do {
            try {
                System.out.println(texto);
                apellido = new Scanner(System.in).nextLine();
                if (!apellido.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,24}")) {
                    throw new Exception("Introduce los apellidos validos con maximo 25 caracteres");
                }
                valido = true;

            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return apellido;
    }

    public static String validaemail(String texto) {
        boolean valido = false;
        String email = null;
        do {
            try {
                System.out.println(texto);
                email = new Scanner(System.in).nextLine();
                if (!email.matches("[A-Za-zÑñáéíóúÁÉÍÓÚ0-9 ]{3,25}@gmail.com")) {
                    throw new Exception("Introduce un email valido ");
                }
                valido = true;

            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return email;
    }

    public static String validapassword(String texto) {
        boolean valido = false;
        String email = null;
        do {
            try {

                System.out.println(texto);
                email = new Scanner(System.in).nextLine();
                if (!email.matches("[A-Za-zÑñáéíóúÁÉÍÓÚ0-9 ]{3,25}")) {
                    throw new Exception("Introduce una password valida ");
                }
                valido = true;

            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return email;
    }

    public static Roles validarol(String texto) {
        boolean valido = false;
        String roles = null;
        Roles rol = null;
        do {
            try {

                System.out.println(texto);
                roles = new Scanner(System.in).nextLine().toLowerCase();
                switch (roles) {
                    case "administrador" ->
                        rol = rol.administrador;
                    case "diseñador" ->
                        rol = rol.diseñador;
                    case "profesor" ->
                        rol = rol.profesor;
                    case "alumno" ->
                        rol = rol.alumno;
                    default ->
                        throw new Exception("Introduce un rol valido administrador,diseñador,profesor,alumno");
                }

            } catch (Exception ex) {
                ex.getMessage();
            }
        } while (!valido);
        return rol;
    }
    //Enum de tipos clase PuntosInteres
    public static Tipo validatipo(String texto) {
        boolean valido = false;
        String tipos = null;
        Tipo tipo = null;
        do {
            try {

                System.out.println(texto);
               tipos = new Scanner(System.in).nextLine().toLowerCase();
                switch (tipos) {
                    case "area de descanso" ->
                        tipo = tipo.area_de_descanso;
                    case "botanico" ->
                       tipo=tipo.botanico;
                    case "cultural" ->
                      tipo=tipo.cultural;
                    case "fauna especifica" ->
                       tipo=tipo.fauna_especifica;
                       case "geologico" ->
                       tipo=tipo.geológico;
                    case "historico-arqueologico" ->
                      tipo=tipo.histórico_arqueologico;
                    case "mirador" ->
                       tipo=tipo.mirador;
                       case "naturaleza" ->
                       tipo=tipo.naturaleza;
                    case "puntos de agua" ->
                      tipo=tipo.punto_de_agua;
                    case "refugio o alojamiento" ->
                       tipo=tipo.refugio_o_alojamiento;
                    default ->
                        throw new Exception("Introduce un tipo valido histórico_arqueologico, " +
"    naturaleza, mirador," +
"    area de descanso, punto de agua, refugio o alojamiento, cultural,  geologico, fauna especifica, botanico");
                }

            } catch (Exception ex) {
                ex.getMessage();
            }
        } while (!valido);
        return tipo;
    }
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
     public static int gravedad(int valor) {
        boolean valido = false;
        int gravedad = 0;
        do {
            try {

               
                gravedad= new Scanner(System.in).nextInt();
                if (gravedad>=1 && gravedad<=5) {
                    System.out.println("Gravedad correcta");
                     valido = true;
                }else{
                    System.out.println("Introduce un valor correcto del 1 al 5");
                }
                

            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return gravedad;
    }
     public static String validanombrePuntosInteres(String texto) {
        boolean valido = false;
        String nombre = null;
        do {
            try {
                System.out.println(texto);
                nombre = new Scanner(System.in).nextLine();
                if (!nombre.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,40}")) {
                    throw new Exception("Introduce un nombre valido de maximo de 40caracteres");
                }
                valido = true;

            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return nombre;
    }
     public static int validatimeestamp(int valor) {
         boolean valido = false;
        int tiempo = 0;
        do {
            try {

               
                tiempo= new Scanner(System.in).nextInt();
                if (tiempo>=0) {
                    System.out.println("Tiempo de ruta correcto");
                     valido = true;
                }else{
                    System.out.println("Introduce un valor correcto mayor que 0 en este caso");
                }
                
            }
            catch (InputMismatchException e) {
                System.out.println("Introduce un valor positivo");
            }
            
        } while (!valido);
        return tiempo;
     }
     
}

}
