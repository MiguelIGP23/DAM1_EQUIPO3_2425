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
}
