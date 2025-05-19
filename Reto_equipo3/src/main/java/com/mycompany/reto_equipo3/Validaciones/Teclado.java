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
 * Clase de validación al introducir datos por teclado y control de posibles excepiones
 * @author Saúl García, Manuel Mediavilla, Miguel Inglés, JavaDoc por Hugo Fernández  
 */
public class Teclado {

    /**
     * Método estático de validación de un nombre que empiece con mayúscula y máximo 20 carácteres, minúsculas, mayúsculas y/o acentuadas, aceptando espacios, incluyendo la ñ en todo
     * @param nombre parámetro que identificará el nombre que se añadirá en la aplicación a validar
     * @return boolean si el nombre es válido o no
     */
    public static boolean validanombre(String nombre) {
        return nombre.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,19}");
    }
    /**
     * Método estático de validación de un nombre que empiece con mayúscula y máximo 25 carácteres, minúsculas, mayúsculas y/o acentuadas, aceptando espacios, incluyendo la ñ en todo
     * @param apellido parámetro que identificará el apellido que se añadirá en la aplicación a validar
     * @return boolean si el apellido es válido o no
     */
    public static boolean validaapellido(String apellido) {
        return apellido.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,24}");
    }
    /**
     * Método estático de validación de un nombre que empiece con mayúscula o minúscula y mínimo 3 carácteres y máximo 19, minúsculas, mayúsculas y/o acentuadas, permite números del 0 al 9, aceptando espacios, incluyendo la ñ en todo y acaba siempre en "gmail.com"
     * @param email parámetro que identificará el email que se añadirá en la aplicación a validar
     * @return boolean si el email es válido o no
     */
    public static boolean validaemail(String email) {
        return email.matches("[A-Za-zÑñáéíóúÁÉÍÓÚ0-9 ]{3,19}@gmail.com");
    }
    /**
     * Método estático de validación de una contraseña que empiece con mayúscula o minúscula y mínimo 3 carácteres y máximo 29, minúsculas, mayúsculas y/o acentuadas, permite números del 0 al 9, incluyendo la ñ en todo
     * @param password parámetro que identificará la contraseña que se añadirá en la aplicación a validar
     * @return boolean si la contraseña es válida o no
     */
    public static boolean validapassword(String password) {
        return password.matches("[A-Za-zÑñáéíóúÁÉÍÓÚ0-9]{3,29}");
    }
    /**
     * Método estático de validación de un rol que deba ser de tipo administrador, diseñador, profesor, alumno o nulo de su enum asociado
     * @param roles parámetro que identificará el enum del rol introducido en la aplicación
     * @return boolean si el rol es válido o no
     */
    public static boolean validarol(String roles) {
        boolean valido = false;
        Roles rol = Roles.valueOf(roles);
        if (rol == null || rol == Roles.administrador || rol == Roles.diseñador || rol == Roles.profesor || rol == Roles.alumno) {
            valido = true;
        }
        return valido;
    }
    /**
     * Método estático de validación del nombre de una ruta que empiece con mayúscula, máximo 46 carácteres, minúsculas, mayúsculas y/o acentuadas, aceptando espacios, incluyendo la ñ en todo
     * @param nombre parámetro que identificará el nombre de la ruta que se añadirá en la aplicación a validar
     * @return boolean si el nombre de la ruta es válido o no
     */
    public static boolean validaInicioFinalRuta(String nombre) {
        boolean valido = false;
        if (nombre.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,45}")) {
            valido = true;
        }
        return valido;
    }
    /**
     * Método estático de validación de la latitud y longitud, el String double deberá de ser parseado correctamente a double, sino agarrará una excepción de NumberFormatException, queriendo decir que no fue parseado correctamente
     * @param coordenada parámetro que identificará la latitud/longitud que se añadirá en la aplicación a validar. Luego se parseará a double para comprobar si es correcto
     * @return boolean si la latitud/longitud es válida o no
     */
    public static boolean validaCoordenadas(String coordenada) {
        boolean valido = false;
        try {
            double coor = Double.parseDouble(coordenada);
            valido = true;
        } catch (NumberFormatException e) {
        }
        return valido;
    }
    /**
     * Método estático de validación de la distancia, el String deberá de ser parseado correctamente a double, sino agarrará una excepción de NumberFormatException, queriendo decir que no fue parseado correctamente
     * @param distancia parámetro que identificará la distancia que se añadirá en la aplicación a validar. Luego se parseará a double para comprobar si es correcto
     * @return boolean si la distancia es válida o no
     */
    public static boolean validaDistancia(String distancia) {
        boolean valido = false;
        double dist;
        try {
            dist = Double.parseDouble(distancia);
            if (dist > 0) {
                valido = true;
            }
        } catch (NumberFormatException e) {
        }
        return valido;
    }
    /**
     * Método estático de validación de una duracion, siempre cuando esté formateado al formato de "HH:mm:ss" (horas:minutos:segundos), agarrará una excepción de DateTimeParseException, queriendo decir que la duración no fue formateada correctamente
     * @param fecha parámetro que identificará la duración que se añadirá en la aplicación a validar. Esta se la formateará con DateTimeFormatter y verificar si está bien escrita esa duracion
     * @return boolean si la duración es válida o no
     */
    public static boolean validaDuracion(String fecha) {
        boolean valido = false;
        LocalTime duracion;
        try {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
            duracion = LocalTime.parse(fecha, f);
            valido = true;
        } catch (DateTimeParseException e) {
        }
        return valido;
    }
    /**
     * Método estático de validación de un desnivel, comprueba que sea mayor a 0, sinó agarrará una excepción de NumberFormatException
     * @param desnivel parámetro que identificará el desnivel que se añadirá en la aplicación a validar
     * @return boolean si el desnivel es válido o no
     */
    public static boolean validaDesnivel(String desnivel) {
        boolean valido = false;
        int desn;
        try {
            desn = Integer.parseInt(desnivel);
            if (desn >= 0) {
                valido = true;
            }
        } catch (NumberFormatException e) {
        }
        return valido;
    }
    /**
     * Método estático de validación de una clasificación, válida si es de tipo LINEAL o CIRCULAR de su enum asociado
     * @param clas parámetro que identificará el enum de la clasificación introducido en la aplicación
     * @return boolean si la clasificación es válida o no
     */
    public static boolean validaClasificacion(String clas) {
        boolean valido = false;
        Clasificacion clasif = Clasificacion.valueOf(clas);
        if (clasif == Clasificacion.LINEAL || clasif == Clasificacion.CIRCULAR) {
            valido = true;
        }
        return valido;
    }
    /**
     * Método estático de validación de un valor introducido este entre 1 y 5, sino agarrará una excepción de NumberFormatException
     * @param valor parámetro que identificará el valor que se introducirá en la aplicación a validar
     * @return boolean si el valor es válido o no
     */
    public static boolean validaRango1a5(String valor) {
        boolean valido = false;
        int val;
        try {
            val = Integer.parseInt(valor);
            if (val >= 1 && val <= 5) {
                valido = true;
            }
        } catch (NumberFormatException e) {
        }
        return valido;
    }
    /**
     * Método estático de validación de las temporadas, comprueba que las estaciones introducidas pertenezcan a la lista dada (primavera, verano, otono, invierno
     * @param temporadas parámetro que identificará las temporadas en una colección de Set String que se introducirá en la aplicación a validar
     * @return boolean si las temporadas son válidas o no
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
    /**
     * Metodo estático privado que comprueba que la lista de temporadas este en el orden correcto
     * @param temporadas parámetro que identificará las temporadas en la validación de las temporadas en el método anterior
     * @param ordenCorrecto parámetro que guardarán las temporadas ordenadas
     * @return boolean si las temporadas están ordenadas o no
     */
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
    /**
     * Método estático de validación que comprueba que el texto introducido sea "si" o "no"
     * @param bool parámetro que identificará el texto introducido que se introducirá en la aplicación a validar
     * @return boolean si el texto introducido es válido o no
     */
    public static boolean validaBoolean(String bool) {
        boolean valido = false;
        if (bool == null || bool.equalsIgnoreCase("si") || bool.equalsIgnoreCase("no")) {
            valido = true;
        }
        return valido;
    }
    /**
     * Método estático de validación de una fecha y hora, siempre cuando esté formateado al formato de "yyyy-MM-dd HH:mm" (año-mes-día hora-minuto), agarrará una excepción de DateTimeParseException, queriendo decir que la fecha y hora no fue formateada correctamente
     * @param fechaHora parámetro que identificará la fecha y hora que se añadirá en la aplicación a validar. Esta se la formateará con DateTimeFormatter y verificar si está bien escrita esa fecha y hora
     * @return boolean si la fecha y hora es válida o no
     */
    public static boolean validafechayhora(String fechaHora) {
        boolean valido = false;
        try {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime aux = LocalDateTime.parse(fechaHora, f);
            valido = true;
        } catch (java.time.format.DateTimeParseException ex) {
        }
        return valido;
    }
    /**
     * Método estático de validación de una fecha, siempre cuando esté formateado al formato de "yyyy-MM-dd" (año-mes-día), agarrará una excepción de DateTimeParseException, queriendo decir que la fecha no fue formateada correctamente
     * @param fecha parámetro que identificará la fecha que se añadirá en la aplicación a validar. Esta se la formateará con DateTimeFormatter y verificar si está bien escrita esa fecha
     * @return boolean si la fecha es válida o no
     */
    public static boolean validafecha(String fecha) {
        boolean valido = false;
        try {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate aux = LocalDate.parse(fecha, f);
            valido = true;
        } catch (java.time.format.DateTimeParseException a) {
        }
        return valido;
    }
    /**
     * Método estático de validación de un nombre de una actividad que empiece con mayúscula y máximo 50 carácteres, minúsculas, mayúsculas y/o acentuadas, aceptando espacios, incluyendo la ñ en todo
     * @param nombre parámetro que identificará el nombre de la actividad que se añadirá en la aplicación a validar
     * @return boolean si el nombre de la actividad es válido o no
     */
    public static boolean validanombreactividad(String nombre) {
        boolean valido = false;
        if (nombre.matches("[A-ZÑ][A-Za-zÑñáéíóúÁÉÍÓÚ ]{2,49}")) {
            valido = true;
        }
        return valido;
    }
    /**
     * Método estático de validación de un tipo de un punto de interés, valida si son de tipo area_de_descanso, botanico, cultural, fauna, geologico, historico, mirador, punto_de_agua y alojamiento del enum asociado
     * @param ti parámetro que identificará el enum de tipo introducido en la aplicación
     * @return boolean si el tipo es válido o no
     */
    public static boolean validatipo(String ti) {
        boolean valido = false;
        Tipo tipo = Tipo.valueOf(ti);
        if (tipo == Tipo.area_de_descanso || tipo == Tipo.botanico || tipo == Tipo.cultural || tipo == Tipo.fauna
                || tipo == Tipo.geologico || tipo == Tipo.historico || tipo == Tipo.mirador || tipo == Tipo.punto_de_agua || tipo == Tipo.alojamiento) {
            valido = true;
        }
        return valido;
    }
    /**
     * Método estático de validación de una url, debe tener una dirección con "." y "\\", acabado en jpg o png
     * @param url parámetro que identificará la url introducido en la aplicación
     * @return boolean si la url es válida o no
     */
    public static boolean validaURL(String url){
        boolean valido = false;
        if (url.matches(".*\\.(jpg|png)")) {
            valido = true;
        }
        return valido;
    }
}
