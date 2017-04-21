/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Individuo {
    
    private int[] genotipo;
    private int fitness;
    public static ArrayList<Integer[]> clausulas;

    // aleatorio
    public Individuo(int tamañoGenotipo) {
      this.genotipo = new int[tamañoGenotipo];
      this.fitness = 0;
      crearAletorio();
      calcularFitness();
    }
     public Individuo(int[] genotipo) {
      this.genotipo = genotipo.clone();
      this.fitness = 0;
      calcularFitness();
    }
    

    private void crearAletorio() {
        // las asignacion de 0 y 1
        Random ran = new Random();
        for (int x=0; x < this.genotipo.length;x++){
          this.genotipo[x]=ran.nextInt(2);
        }
    }

    private void calcularFitness() {
       // acumalación de clausulas verdaderas
       // recorrer ñas clausulas
       for (Integer[] clausula: clausulas ){
           boolean resultado = verificarClausula(clausula);
           if (resultado){
           this.fitness++;
           }
       }
    }

    private boolean verificarClausula(Integer[] clausula) {
        // recorremos la clausula
        for (int x=0; x<clausula.length;x++){
            // obtengo el valor 
            int valorClausula = clausula[x];
            int valor = this.genotipo[checarValor(valorClausula)-1];
          if (valorClausula < 0){
             if (valor==0){
               valor =1;
             }else {
             valor = 0;
             }
          }
          if (valor==1){
            return true;
          }
        }
        return false;
    }

    private int checarValor(int valorClausula) {
       if (valorClausula<0){
         valorClausula = valorClausula*-1;
       }
       return valorClausula;
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return fitness;
    }
    
    
    
}
