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
import java.util.LinkedHashSet;
import java.util.List;
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
    public static boolean validanombre(String nombre) {
        return nombre.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,19}");

    }

    /*
     metodo que sirve para 
     Usuario:apellido
    
     */
    public static boolean validaapellido(String apellido) {
        return apellido.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,24}");
    }

    /*
    metodo que sirve para 
    Usuario:email
    
     */
    public static boolean validaemail(String email) {
        return email.matches("[A-Za-zÑñáéíóúÁÉÍÓÚ0-9 ]{3,19}@gmail.com");
    }

    /*
     metodo que sirve para
    Usuario:password
    
     */
    public static boolean validapassword(String password) {
        return password.matches("[A-Za-zÑñáéíóúÁÉÍÓÚ0-9]{3,29}"); 
    }

    /*
     metodo que sirve para 
    Usuario:rol
     */
    public static boolean validarol(Roles rol) {
        boolean valido = false;
        if (rol == null || rol == Roles.administrador || rol == Roles.diseñador || rol == Roles.profesor || rol == Roles.alumno) {
            valido = true;
        }
        return valido;
    }

    /*
    Valida que nombre de inicio ruta y final ruta tenga 45 caracteres
    Ruta:nombre_incioruta
         nombre_finalruta
     */
    public static boolean validaInicioFinalRuta(String nombre) {
        boolean valido = false;
        if (nombre.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,45}")) {
            valido = true;
        }
        return valido;
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
    Recibe la coordenada como String ya que JTextField de JavaSwing devuelve texto, 
    comprueba que sea un numero haciendo el parseo
     */
    public static boolean validaCoordenadas(String coordenada) {
        boolean valido = false;
        try {
            double coor = Double.parseDouble(coordenada);
            valido = true;
        } catch (NumberFormatException e) {}
        return valido;
    }

    /*
      Comprueba que la distancia sea un numero positivo
      Rutas:distancia
    PuntosPeligro:kilometros
     */
    public static boolean validaDistancia(double distancia) {
        boolean valido = false;
        if (distancia > 0) {
            valido = true;
        }
        return valido;
    }

    /*Comprueba que la duracion siga el patron dado {hh:mm:ss}
    Rutas:duracion
     */
    public static boolean validaDuracion(String fecha) {
        boolean valido = false;
        LocalTime duracion = null;
        try {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
            duracion = LocalTime.parse(fecha, f);
            valido = true;
        } catch (DateTimeParseException e) {}
        return valido;
    }

    /*Comprueba que el desnivel sea mayor que 0
    Rutas:desnivelpositivo
    PuntosInteres:timestamp
    PuntosPeligro:posicion
     */
    public static boolean validaDesnivel(int desnivel) {
        boolean valido = false;
        if (desnivel >= 0) {
            valido = true;
        }
        return valido;
    }


    /*Comprueba que la clasificacion tenga uno de los valores dados en el enum
      Rutas:Clasificacion
     */
    public static boolean validaClasificacion(Clasificacion clas) {
        boolean valido = false;
        if (clas == Clasificacion.LINEAL || clas == Clasificacion.CIRCULAR) {
            valido = true;
        }
        return valido;
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
    public static boolean validaRango1a5(int valor) {
        boolean valido = false;
        if (valor >= 1 && valor <= 5) {
            valido = true;
        }
        return valido;
    }

    /*Comprueba que las estaciones introducidas pertenezcan a la lista dada (primavera, verano, otono, invierno)
    Rutas:temporadas
     */
    public static boolean validaTemporada(Set<String> temporadas) {
        List<String> temporadasValidas = List.of("primavera", "verano", "otoño", "invierno");
        boolean valido = false;
            //Copiamos la lista de temporadas a otro Set<String> y eliminamos las estaciones validas
            Set<String> noValidas = new LinkedHashSet<>(temporadas);
            noValidas.removeAll(temporadasValidas);
            //Comprobamos si queda alguna temporada no valida en la lista
            if (noValidas.isEmpty()) {
                //Si esta correcto, comprobamos su orden con metodo externo
                if (estanOrdenadas(temporadas, temporadasValidas)) {
                    valido = true;
                }
            }
        return valido;
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

    /*Metodo que comprueba que el texto texto introducido sea si o no
    Rutas:accesibilidad
          rutaFamiliar
     */
    public static boolean validaBoolean(String bool) {
        boolean valido = false;
            if (bool==null || bool.equalsIgnoreCase("si") || bool.equalsIgnoreCase("no")){
                valido=true;
            }
        return valido;
    }

    //Metodo que convierte la entrada
   
    /*
    Calendario:fecha
     */
    public static boolean validafechayhora(String fechaHora) {
        boolean valido = false;
            try {
                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime aux = LocalDateTime.parse(fechaHora, f);
                valido = true;
            } catch (java.time.format.DateTimeParseException ex) {}
        return valido;
    }
    
    /*
    Valora:fecha
     */
    public static boolean validafecha(String fecha) {
        boolean valido = false;
            try {
                DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate aux = LocalDate.parse(fecha, f);
                valido = true;
            } catch (java.time.format.DateTimeParseException a) {}
        return valido;
    }

    /*
    Actividad:nombre
    PuntosInteres:nombre
    PuntosPeligro:nombre
     */
    public static boolean validanombreactividad(String nombre) {
        boolean valido = false;
                if (nombre.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,49}")) {
                valido = true;
                }
        return valido;
    }

    /*Enum de tipos clase PuntosInteres
     PuntosInteres:tipo
     */
    public static boolean validatipo(Tipo tipo) {
        boolean valido = false;
        if(tipo==Tipo.area_de_descanso || tipo==Tipo.botanico || tipo==Tipo.cultural || tipo==Tipo.fauna_especifica
                 || tipo==Tipo.geológico || tipo==Tipo.histórico_arqueologico || tipo==Tipo.mirador || tipo==Tipo.naturaleza
                 || tipo==Tipo.punto_de_agua || tipo==Tipo.refugio_o_alojamiento){
            valido=true;
        }
        return valido;
    }
}
