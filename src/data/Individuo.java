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

    public Individuo() {
       this.genotipo = new int[100];
      this.fitness = 0;
      crearAletorio();
      calcularFitness();
    }

    
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

    public Individuo(Individuo i) {
        this.genotipo = i.getGenotipo().clone();
        this.fitness = i.getFitness();
    }
     
    

    private void crearAletorio() {
        // las asignacion de 0 y 1
        Random ran = new Random();
        for (int x=0; x < this.getGenotipo().length;x++){
          this.genotipo[x]=ran.nextInt(2);
        }
    }

    public void calcularFitness() {
       // acumalación de clausulas verdaderas
       // recorrer ñas clausulas
       this.fitness = 0;
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
            int valor = this.getGenotipo()[checarValor(valorClausula)-1];
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

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }
    
    public String getRepresentación()
    {
        String representación = "{";
        for(int i=0;i<this.genotipo.length;i++)
        {
            representación += this.genotipo[i];
        }
        return representación+"}";
    }
    
    
}
