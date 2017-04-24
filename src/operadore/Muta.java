/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operadore;

import data.Individuo;
import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Muta {
    
    public static void mutaGenAleatorio(Individuo i){
     Random ran = new Random();
     int pos = ran.nextInt(i.getGenotipo().length);
     
        mutaGen(i, pos);
     
    }
    
    public static void mutaGen(Individuo i,int n){
         if (i.getGenotipo()[n]==0){
           i.getGenotipo()[n]=1;
           i.calcularFitness();
         }else {
           i.getGenotipo()[n]=0;
           i.calcularFitness();
         }
    }
}
