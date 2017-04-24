/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3sat3mm2;

import data.Datos;
import data.Individuo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Datos datos = Herramientas.obtenerDatos();
            Individuo.clausulas = datos.getCláusulas();
            GeneticoV1 gen = new GeneticoV1(35, 100000, 0.35);
            gen.evolucionar();
            System.out.println();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
