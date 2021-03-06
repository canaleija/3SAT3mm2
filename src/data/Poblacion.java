/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Poblacion {
    
    // lista de individuos 
    private LinkedList<Individuo> individuos;
    private int tamPob;
    private Individuo mejor;
    private Individuo peor;
    private int fitnessPoblacion;
    
    public Poblacion (){
        this.tamPob = 0;
        this.individuos = new LinkedList<>();
    }
    
    // por defecto / aleatorio
    public Poblacion(int tamPob){
        this.tamPob = tamPob;
        this.individuos = new LinkedList<>();
        for (int x=0; x < tamPob;x++){
           this.individuos.add(new Individuo());
        }
   
    }
     public Poblacion(Poblacion pob){
        this.tamPob = pob.getTamPob();
        this.individuos = clonarPoblacion(pob.getIndividuos());
        for (int x=0; x < tamPob;x++){
           this.individuos.add(new Individuo());
        }
    
    }
     public Poblacion (LinkedList<Individuo> individuos){
         this.tamPob = individuos.size();
         this.individuos = clonarPoblacion(individuos);
     }

    /**
     * @return the individuos
     */
    public LinkedList<Individuo> getIndividuos() {
        return individuos;
    }

    /**
     * @return the tamPob
     */
    public int getTamPob() {
        return tamPob;
    }

    /**
     * @return the mejor
     */
    public Individuo getMejor() {
             calcularMejoryPeor();
        return mejor;
    }

    /**
     * @return the peor
     */
    public Individuo getPeor() {
             calcularMejoryPeor();
        return peor;
    }

    private LinkedList<Individuo> clonarPoblacion(LinkedList<Individuo> individuos) {
        LinkedList<Individuo> aux = new LinkedList<>();
        for (Individuo i:individuos){
         aux.add(new Individuo(i));
        }
        return aux;
    }
    
    private void calcularMejoryPeor(){
       
        if (!this.individuos.isEmpty()){
          // buscamos
         this.mejor = this.individuos.get(0);
         this.peor = this.individuos.get(0);
         for (int x=0; x < this.individuos.size();x++){
            if (this.individuos.get(x).getFitness()>mejor.getFitness()){
              this.mejor = this.individuos.get(x);
            }
            if (this.individuos.get(x).getFitness()<peor.getFitness()){
             this.peor = this.individuos.get(x);
            }
         }          
        }
    
    }
     public void agregarHabitante(Individuo ind) {
        this.individuos.add(new Individuo(ind));
        this.tamPob++;
    }

    /**
     * @return the fitnessPoblacion
     */
    public int getFitnessPoblacion() {
        int acum =0;
        for (Individuo ind: individuos){
        acum+=ind.getFitness();
        }
        this.fitnessPoblacion = acum;
        return fitnessPoblacion;
    }
    
}
