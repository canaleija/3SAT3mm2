/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3sat3mm2;

import data.Individuo;
import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int genotipo[] = new int[]{1,0,0,1,1};
        ArrayList<Integer[]> cla = new ArrayList<>();
        Integer[] c1 = new Integer[]{1,3,4};
        Integer[] c2 = new Integer[]{-1,2,3};
        Integer[] c3 = new Integer[]{-3,4,1};
        cla.add(c1);
        cla.add(c2);
        cla.add(c3);
        Individuo.clausulas = cla;
        Individuo i = new Individuo(genotipo);
        System.out.println(i.getFitness());

    }
    
}
