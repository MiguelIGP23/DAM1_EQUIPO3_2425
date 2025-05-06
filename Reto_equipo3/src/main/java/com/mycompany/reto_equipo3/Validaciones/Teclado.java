/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto_equipo3.Validaciones;

import com.mycompany.reto_equipo3.Enums.Clasificacion;
import com.mycompany.reto_equipo3.Enums.Roles;
import com.mycompany.reto_equipo3.Enums.Tipo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author DAM121
 */
public class Teclado {

    /* 
    Nombre que empiece con mayusculas y maximo 20 caracteres
    Usuario:nombre
    Rutas:nombre
     */
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

    /*
     metodo que sirve para 
     Usuario:apellido
    
     */
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

    /*
    metodo que sirve para 
    Usuario:email
    
     */
    public static String validaemail(String texto) {
        boolean valido = false;
        String email = null;
        do {
            try {
                System.out.println(texto);
                email = new Scanner(System.in).nextLine();
                if (!email.matches("[A-Za-zÑñáéíóúÁÉÍÓÚ0-9 ]{3,19}@gmail.com")) {
                    throw new Exception("Introduce un email valido ");
                }
                valido = true;
            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return email;
    }
    /*
     metodo que sirve para
    Usuario:password
    
     */
    public static String validapassword(String texto) {
        boolean valido = false;
        String email = null;
        do {
            try {
                System.out.println(texto);
                email = new Scanner(System.in).nextLine();
                if (!email.matches("[A-Za-zÑñáéíóúÁÉÍÓÚ0-9 ]{3,29}")) {
                    throw new Exception("Introduce una password valida ");
                }
                valido = true;
            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return email;
    }

    /*
     metodo que sirve para 
    Usuario:rol
     */
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

    /*
    Valida que nombre de inicio ruta y final ruta tenga 45 caracteres
    Ruta:nombre_incioruta
         nombre_finalruta
    
     */
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

    /*Comprueba que latitud y longitud sean numericos
    Rutas:latitudInicial
          latitudFinal
          longitudInicial
          longitudFinal
          altitudMax
          altitudMin
    PuntosInteres:latitud
                  longitud
                  elevacion
    PuntosPeligro:latitud
                  longitud
                  elevacion
    
     */
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

    /*
      Comprueba que la distancia sea un numero positivo
      Rutas:distancia
    PuntosPeligro:kilometros
     */
    public static double validaDistancia(String texto) {
        boolean valido = false;
        double distacia = 0;
        do {
            try {
                System.out.println(texto);
                distacia = new Scanner(System.in).nextDouble();
                if (distacia <= 0) {
                    throw new Exception("ERROR: la distancia no puede ser negativa");
                } 
                    valido = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: la distancia debe ser numerica");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!valido);
        return distacia;
    }

    /*Comrpueba que la duracion siga el patron dado {hh:mm:ss}
    Rutas:duracion
     */
    public static LocalTime validaDuracion(String texto) {
        boolean valido = false;
        LocalTime duracion = null;
        do {
            try {
                System.out.println(texto);
                DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
                duracion = LocalTime.parse(new Scanner(System.in).nextLine(), f);
                valido = true;
            } catch (DateTimeParseException e) {
                System.out.println("ERROR: foramto no valido usando el formato HH:mm:ss");
            }
        } while (!valido);
        return duracion;
    }

    /*Comprueba que el desnivel positivo sea mayor que 0
    Rutas:desnivelpositivo
    PuntosInteres:timestamp
    PuntosPeligro:posicion
     */

    public static int validaDesnivelPositivo(String texto) {
        boolean valido = false;
        int desnivelPositivo = 0;
        do {
            try {
                System.out.println(texto);
                desnivelPositivo = new Scanner(System.in).nextInt();
                if (desnivelPositivo <= 0) {
                    throw new Exception("ERROR: el numero debe ser positivo");
                }
                   valido = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: el valor introducido debe ser numerico y entero");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!valido);
        return desnivelPositivo;
    }

    /*Comprueba que el desnivel positivo sea mayor que 0
     Rutas:desnivelNegativo
     */

    public static int validaDesnivelNegativo(String texto) {
        boolean valido = false;
        int desnivelNegativo = 0;
        do {
            try {
                System.out.println(texto);
                desnivelNegativo = new Scanner(System.in).nextInt();
                if (desnivelNegativo >= 0) {
                    throw new Exception("ERROR: el numero debe ser negativo");
                } 
                    valido = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: el valor introducido debe ser numerico y entero");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!valido);
        return desnivelNegativo;
    }

    /*Comprueba que la clasificacion tenga uno de los valores dados en el enum
      Rutas:Clasificacion
     */
    public static Clasificacion validaClasificacion(String texto) {
        boolean valido = true;
        Clasificacion clasificacion = null;
        String clas=null;
        do {
            try{
            System.out.println(texto);
             clas = new Scanner(System.in).nextLine().toLowerCase();
            switch (clas) {
                case "circular" -> 
                    clasificacion = Clasificacion.CIRCULAR;
                case "lineal" -> 
                    clasificacion = Clasificacion.LINEAL;
                default -> 
                    throw new Exception("ERROR: valor no valido, elige circular o lineal");
            }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        } while (!valido);
        return clasificacion;
    }

    /*Comprueba que el valor introducido este entre 1 y 5
    Rutas:nivelEsfuerzo
          nivelRiesgo
          estadoRuta
          tipoTerreno
          indicaciones
    Valora:dificultad
           estrellas
           interesCultural
           belleza
    PuntosPeligro:gravedad
     */
    public static int validaRango1a5(String texto) {
        boolean valido = false;
        int valor = 0;
        do {
            try {
                System.out.println(texto);
                valor = new Scanner(System.in).nextInt();
                if (valor < 1 || valor > 5) {
                    throw new Exception("ERROR: el valor debe estar entre 1 y 5");
                } 
                    valido = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: el valor debe ser numerico");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!valido);
        return valor;
    }

    /*Comprueba que las estaciones introducidas pertenezcan a la lista dada (primavera, verano, otono, invierno)
    Rutas:temporadas
     */
    public static Set<String> validaTemporada(String texto) {
        List<String> temporadasValidas = List.of("primavera", "verano", "otoño", "invierno");
        boolean valido = false;
        Set<String> temporadas = new LinkedHashSet<>();
        do {
            String temp = new Scanner(System.in).nextLine();
            //Vaciamos el Set<String> anterior, previene fallos recursivos
            temporadas.clear();
            //Separamos por las comas
            String[] partes = temp.split(",");
            //Lo guardamos en el Set<String>, quitando espacios y poniendo en minuscula
            for (String parte : partes) {
                temporadas.add(parte.trim().toLowerCase());
            }
            //Copiamos la lista de temporadas a otro Set<String> y eliminamos las estaciones validas
            Set<String> noValidas = new LinkedHashSet<>(temporadas);
            noValidas.removeAll(temporadasValidas);
            //Comprobamos si queda alguna temporada no valida en la lista
            if (noValidas.isEmpty()) {
                //Si esta correcto, comprobamos su orden con metodo externo
                if (estanOrdenadas(temporadas, temporadasValidas)) {
                    valido = true;
                } else {
                    System.out.println("ERROR: debes introducir las temporadas en orden");
                }
            } else {
                System.out.println("ERROR: temporada no valida (primavera,verano,otono,invierno)");
            }
        } while (!valido);
        return temporadas;
    }

    //Metodo privado que comprueba que la lista de temporadas este en el orden correcto
    private static boolean estanOrdenadas(Set<String> temporadas, List<String> ordenCorrecto) {
        int posicionAnterior = -1;
        boolean ordenado = true;
        for (String temporada : temporadas) {
            int posicionActual = ordenCorrecto.indexOf(temporada);
            if (posicionActual < posicionAnterior) {
                ordenado = false;
            }
            posicionAnterior = posicionActual;
        }
        return ordenado;
    }
    
    /*Metodo que comprueba que el valor de un booleano sea si o no y lo traduce a true o false
    Rutas:accesibilidad
          rutaFamiliar
    
    */
public static boolean validaBoolean(String texto){
        boolean valido=false;
        boolean resultado=false;
        do{
            System.out.println(texto);
            String opcion=new Scanner(System.in).nextLine();
            if(opcion.equalsIgnoreCase("si")){
                resultado=true;
                valido=true;
            }else if(opcion.equalsIgnoreCase("no")){
                resultado=false;
                valido=true;
            }else{
                System.out.println("ERROR: introduce si o no");
            }
        }while(!valido);
        return resultado;
    }
/* para atributos valoracionTecnica y reseña
Rutas:archivoGPX
      recomendaciones
      zonaGeografica
Calendario:detalles
           recomendaciones
Valora:valoracionTecnica
       Reseña
PuntosInteres:descripcion
              caracteristicas
PuntosPeligro:descripcion
ImagenesInteres:url
                descripcion
ImagenesPeligro:url
                descripcion
*/

    public static String validareseña(String texto){
        return new Scanner(System.in).nextLine();   
    }
    /*
    Calendario:fecha
    */
    public static LocalDateTime validafechayhora(String texto){
       boolean valido=false;
       LocalDateTime fecha=null;
        do{
           try{
               System.out.println(texto);
               DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
               fecha=LocalDateTime.parse(new Scanner(System.in).nextLine(),f);
               valido=true;
           }catch(java.time.format.DateTimeParseException ex){
               System.out.println("Introduce una fecha valida con el formato yyyy-MM-dd HH:mm");
           }
       }while(!valido);
        return fecha;
    }
    /*
    Valora:fecha
    */
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
    /*
    Actividad:nombre
    PuntosInteres:nombre
    PuntosPeligro:nombre
    */
     public static String validanombreactividad(String texto) {
        boolean valido = false;
        String nombre = null;
        do {
            try {
                System.out.println(texto);
                nombre = new Scanner(System.in).nextLine();
                if (!nombre.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,49}")) {
                    throw new Exception("Introduce un nombre de actividad valido de maximo de 50 caracteres");
                }
                valido = true;
            } catch (Exception a) {
                System.out.println(a.getMessage());
            }
        } while (!valido);
        return nombre;
    }
    /*Enum de tipos clase PuntosInteres
     PuntosInteres:tipo
     */
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
                        tipo = tipo.botanico;
                    case "cultural" ->
                        tipo = tipo.cultural;
                    case "fauna especifica" ->
                        tipo = tipo.fauna_especifica;
                    case "geologico" ->
                        tipo = tipo.geológico;
                    case "historico-arqueologico" ->
                        tipo = tipo.histórico_arqueologico;
                    case "mirador" ->
                        tipo = tipo.mirador;
                    case "naturaleza" ->
                        tipo = tipo.naturaleza;
                    case "puntos de agua" ->
                        tipo = tipo.punto_de_agua;
                    case "refugio o alojamiento" ->
                        tipo = tipo.refugio_o_alojamiento;
                    default ->
                        throw new Exception("Introduce un tipo valido histórico_arqueologico, "
                                + "    naturaleza, mirador,"
                                + "    area de descanso, punto de agua, refugio o alojamiento, cultural,  geologico, fauna especifica, botanico");
                }
            } catch (Exception ex) {
                ex.getMessage();
            }
        } while (!valido);
        return tipo;
    }
}
