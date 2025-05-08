/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reto_equipo3;

import com.mycompany.reto_equipo3.Validaciones.Teclado;
import com.mycompany.reto_equipo3.DAOS.AccesoABaseDatos;
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
    }
}
