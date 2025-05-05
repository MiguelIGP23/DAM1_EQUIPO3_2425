/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Validaciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author DAM121
 */
public class TecladoValora {
    // para atributos dificultad,estrellas,interesCultural,belleza
    
    public static int validadificultad(String texto) {
        boolean valido = false;
        int dificultad = 0;
        do {
            try {
                System.out.println(texto);
                dificultad = new Scanner(System.in).nextInt();
                if (!(dificultad>=1&&dificultad<=5)) {
                    throw new Exception("Introduce una dificultad entre 1 y 5 dependiendo de su dificultad ./n ");
                }
                valido = true;
            }catch(java.lang.ArithmeticException a){
                System.out.println("Introduce un numero valido");  
            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return dificultad;
    }
    public static LocalDate validafecha(String texto){
        boolean valido=false;
        LocalDate fecha=null;
        do{
            try{
                System.out.println(texto);
               DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd");
               fecha=LocalDate.parse(new Scanner(System.in).nextLine(),f);
               valido=true;
            }catch(java.time.format.DateTimeParseException a){
                System.out.println("Introduce una fecha valida. Con formato yyyy-MM-dd");
            }
        }while(!valido);
        return fecha;
    }
    // para atributos valoracionTecnica y reseña
    public static String validareseña(String texto){
        return new Scanner(System.in).nextLine();   
    }
}
