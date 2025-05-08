/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.DAOS.AccesoABaseDatos;
import com.mycompany.reto_equipo3.DAOS.*;
import com.mycompany.reto_equipo3.Enums.Roles;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;
/**
 *
 * @author DAM123
 */
public class Reto_equipo3 {

    public static void main(String[] args) {
        
        
        System.out.println(AccesoABaseDatos.getInstance().getConnexion());
        //Prueba DAO usuario
        DAOUsuario daousu= new DAOUsuario();
        Usuario usu=daousu.buscar("saul@gmail.com");
//        System.out.println(usu);
//        daousu.insertar(new Usuario("nombrePruebaDAO", "apellidoPruebaDAO", "pruebadao@gmail.com","abcd1234", Roles.administrador));
//        System.out.println(daousu.listar());
//        daousu.eliminar("pruebadao@gmail.com");
//        System.out.println(daousu.listar());
//        Usuario usu2 = daousu.encontrarUsuario(usu.getEmail(), usu.getPassword());
//        System.out.println(usu2);
        
        //Prueba DAO rutas
        DAORutas daoruta = new DAORutas();
        Rutas ruta = daoruta.buscar("paseo por el bosque");
        Rutas ruta2=daoruta.buscar("subida al everest");
//        System.out.println(ruta);
//        List<Rutas> aprobadas= daoruta.listaraprobadas();
//        List<Rutas> noaprobadas= daoruta.listarsinaprobar();
//        daoruta.aprobarRuta(ruta);
//        System.out.println("Lista aprobadas:");
//        for(Rutas rutaaaa:aprobadas){
//            System.out.println(rutaaaa.toString());
//        }
//        System.out.println("Lista no aprobadas:");
//        for(Rutas rutbbbb:noaprobadas){
//            System.out.println(rutbbbb.toString());
//        }
//        LocalTime hora= LocalTime.parse("00:26:00");
//        daoruta.insertar(new Rutas("nombreprueba", "inicioRutaPrueba", "finalRutaPrueba", 1.254, 2.365, 20.365, 21.03, 0, hora),usu);
        
//        //Prueba DAO valora
        DAOValora daovalora= new DAOValora();
        Valora valo= daovalora.buscar(1);
        System.out.println(valo);
        LocalDate fecha=LocalDate.parse("2024-05-23");
        daovalora.insertar(new Valora(4,fecha,5, 2,3), usu, ruta2);
        System.out.println(daovalora.listar(ruta));
        List<Valora> aaaaaaaaaaaa = daovalora.listar(ruta);
        for(Valora valoracion:aaaaaaaaaaaa){
            System.out.println(valoracion.toString());
        }
        
    }
}
