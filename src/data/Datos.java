/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Datos {
    
    private int tamañoDelGenotipo;
    private ArrayList<Integer[]> cláusulas;
    private int tamañoDeCláusula;
    public Datos(int tamañoDelGenotipo,ArrayList<Integer[]> cláusulas,int tamañoDeCláusula)
    {
        this.tamañoDelGenotipo = tamañoDelGenotipo;
        this.cláusulas = cláusulas;
        this.tamañoDeCláusula = tamañoDeCláusula;
    }

    /**
     * @return the tamañoDelGenotipo
     */
    public int getTamañoDelGenotipo() {
        return tamañoDelGenotipo;
    }

    /**
     * @return the cláusulas
     */
    public ArrayList<Integer[]> getCláusulas() {
        return cláusulas;
    }

    /**
     * @return the tamañoDeCláusula
     */
    public int getTamañoDeCláusula() {
        return tamañoDeCláusula;
    }
    
}
