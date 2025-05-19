/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.DAOS.AccesoABaseDatos;
import com.mycompany.reto_equipo3.DAOS.*;
import com.mycompany.reto_equipo3.Enums.Roles;
import com.mycompany.reto_equipo3.Ficheros.FichaOrganizacion;
import com.mycompany.reto_equipo3.Ficheros.FichaSeguridad;
import com.mycompany.reto_equipo3.Ficheros.FichaUsuario;
import com.mycompany.reto_equipo3.Ficheros.ControlFichas;
import com.mycompany.reto_equipo3.Swing.SwingPrincipal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.List;

/**
 * Clase principal la cuál ejecuta la aplicación
 * @author Miguel Inglés, JavaDoc por Hugo Fernández
 * @see <a href="https://github.com/MiguelIGP23/DAM1_EQUIPO3_2425.git">Dirección de GitHub</a>
 */
public class Reto_equipo3 {

    public static void main(String[] args) {

        System.out.println(AccesoABaseDatos.getInstance().getConnexion() + "\n");

        //Prueba swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            new SwingPrincipal().setVisible(true);
        });
//
//        //Prueba DAO usuario                  ---- FUNCIONA
//        DAOUsuario daousu = new DAOUsuario();
//        Usuario usu = daousu.buscar("saul@gmail.com");
//        Usuario usu2 = daousu.buscar("miguel@gmail.com");
////        System.out.println(usu);
////        daousu.insertar(new Usuario("nombrePruebaDAO", "apellidoPruebaDAO", "pruebadao@gmail.com","abcd1234", Roles.administrador));
////        System.out.println(daousu.listar());
////        daousu.eliminar("pruebadao@gmail.com");
////        System.out.println(daousu.listar());
////        Usuario usu3 = daousu.encontrarUsuario("miguel@gmail.com", "abcd1234");
////        System.out.println(usu3);
//
//        //Prueba DAO rutas                    ---- FUNCIONA
//        DAORutas daoruta = new DAORutas();
//        Rutas ruta = daoruta.buscarTodaInfo("paseo por el bosque");
//        Rutas ruta2 = daoruta.buscarTodaInfo("Subida al everest");
////        System.out.println(ruta.toString());
////        System.out.println(ruta2.toString());
////        List<Rutas> aprobadas= daoruta.listaraprobadas();
////        List<Rutas> noaprobadas= daoruta.listarsinaprobar();
////        daoruta.aprobarRuta(ruta);
////        System.out.println("Lista aprobadas:");
////        System.out.println(daoruta.listaraprobadas());
////        System.out.println("Lista no aprobadas:");
////        System.out.println(daoruta.listarsinaprobar());
////        LocalTime hora= LocalTime.parse("00:26:00");
////        daoruta.insertar(new Rutas("nombreprueba", "inicioRutaPrueba", "finalRutaPrueba", 1.254, 2.365, 20.365, 21.03, 0, hora),usu);
//
////        //Prueba DAO valora                   ---- FUNCIONA
//        DAOValora daovalora = new DAOValora();
//        Valora valo = daovalora.buscar(1);
////        System.out.println(valo);
////        LocalDate fecha = LocalDate.parse("2023-11-13");
////        daovalora.insertar(new Valora(2, fecha, 2, 5, 5), usu2, ruta2);
////        if (ruta != null) {
////            List<Valora> aaaaaaaaaaaa = daovalora.listar(ruta);
////            for (Valora valoracion : aaaaaaaaaaaa) {
////                System.out.println(valoracion.toString());
////            }
////        }else{
////            System.out.println("La ruta no existe");
////        }
////        daovalora.eliminar(usu, ruta);
////        if (ruta != null) {
////            List<Valora> aaaaaaaaaaaa = daovalora.listar(ruta);
////            for (Valora valoracion : aaaaaaaaaaaa) {
////                System.out.println(valoracion.toString());
////            }
////        }else{
////            System.out.println("La ruta no existe");
////        }
//
////          //Prueba DAO actividad              ---- FUNCIONA
//        DAOActividad daoact = new DAOActividad();
//        Actividad act = daoact.buscar("buceo");
////        System.out.println(act);
////        System.out.println(daoact.listar());
////        daoact.insertar(new Actividad("buceo"), ruta);
////        System.out.println(daoact.listar());
////        daoact.eliminar("escalada");
////        System.out.println(daoact.listar());
//
//        //Prueba DAO calendario               ---- FUNCIONA
//        DAOCalendario daocal = new DAOCalendario();
//        LocalDate fech = LocalDate.of(2026, 5, 23);
////        Calendario cal= daocal.buscarPorFecha(fech);
////        System.out.println(cal);
////        System.out.println(daocal.listar());
////        LocalDateTime f=LocalDateTime.of(2025, 8, 13, 17, 30);
////        daocal.insertar(new Calendario(f, "dia de playa", "ponte crema"), usu2, ruta);
////        System.out.println(daocal.listar());
////        daocal.eliminar(2);
////        System.out.println(daocal.listar());
//
//        //Prueba DAO puntos interes           ---- FUNCIONA
//        DAOPuntosinteres daopi = new DAOPuntosinteres();
//        PuntosInteres pi = daopi.buscar("Mirador de patos");
////        System.out.println(pi);
////        System.out.println(daopi.listar(ruta));
////        daopi.insertar(new PuntosInteres("parque", 3.6543, 1.2564, 90, "hay bancos y fuentes"), ruta);
////        System.out.println(daopi.listar(ruta));
////        daopi.eliminar("parque");
////        System.out.println(daopi.listar(ruta));
//
//        //Prueba DAO puntos peligro           ---- FUNCIONA
//        DAOPuntospeligro daopp = new DAOPuntospeligro();
//        PuntosPeligro pp = daopp.buscar("barranco");
////        System.out.println(pp);
////        System.out.println(daopp.listar(ruta));
////        daopp.insertar(new PuntosPeligro("hielo", 3.6543, 1.2564, 90, "cuidado con resbalones"), ruta);
////        System.out.println(daopi.listar(ruta));
////        daopp.eliminar("aaaaaa");
////        System.out.println(daopp.listar(ruta2));
////
//        //Prueba de creacion de fichas    ---- FUNCIONA
//       // ControlFichas.generarFichas(ruta);
//       // ControlFichas.generarFichas(ruta2);
    }
}
