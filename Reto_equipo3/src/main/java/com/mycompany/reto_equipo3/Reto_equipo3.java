/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Validaciones.Teclado;
import com.mycompany.reto_equipo3.DAOS.AccesoABaseDatos;
import com.mycompany.reto_equipo3.DAOS.*;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author DAM123
 */
public class Reto_equipo3 {

    public static void main(String[] args) {
        
        
        //System.out.println(TecladoRutas.validaTemporada());
        //System.out.println(TecladoRutas.validaBoolean("Introduce si o no"));
        //System.out.println(TecladoRutas.validaDuracion("hh:mm:ss"));
        System.out.println(AccesoABaseDatos.getInstance().getConnexion());
        DAOUsuario daousu= new DAOUsuario();
        DAORutas daoruta = new DAORutas();
        DAOValora daovalora= new DAOValora();
        System.out.println(daousu.listar());
        Usuario usu=daousu.buscar("saul@gmail.com");
        System.out.println(daoruta.listaraprobadas());
        System.out.println(daoruta.listarsinaprobar());
        Rutas ruta = daoruta.buscar("paseo por el bosque");
        System.out.println(ruta.toString());
        List<Valora> aaaaaaaaaaaa = daovalora.listar(ruta);
        for(Valora valoracion:aaaaaaaaaaaa){
            System.out.println(valoracion.toString());
        }
    }
}
