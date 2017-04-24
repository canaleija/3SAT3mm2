/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3sat3mm2;

import data.Individuo;
import data.Poblacion;
import operadore.Cruza;
import operadore.Mascaras;
import operadore.Muta;
import operadore.Seleccion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class GeneticoV1 {
 
  
    private int tamano_poblacion;
    private int epocas;
    private double prob_muta;
    private Poblacion poblacion;
    private int e;
    private boolean runnable;
   
    public GeneticoV1(int tamano_poblacion, int epocas, double prob_muta) {
        
        this.tamano_poblacion = tamano_poblacion;
        this.epocas = epocas;
        this.prob_muta = prob_muta;
        this.poblacion = new Poblacion(tamano_poblacion);
      
    }
  
   public void evolucionar (){
       // crear un proceso iterativo para simular las epocas
     
        for ( int e = 0; e < this.epocas;e++){
            // garantizar la creación de una nueva población
            Poblacion nuevaP = new Poblacion(); 
            // tenemos que iterar para construir la nueva generacion
            for(int i=0; i < this.tamano_poblacion;i++){
               // proceso de seleccion de padre y madre
               Individuo padre = Seleccion.selccionarMejor(this.poblacion);
               Individuo madre = Seleccion.seleccionRuleta(this.poblacion);
               // ejecutamos la cruza y obtenemos al hijo
               Individuo hijo;
             
               hijo = Cruza.cruzaConMascara(madre, padre, Mascaras.generarMascaraMitadYMitad(madre.getGenotipo().length));
               // dependiendo de una prob. muta se cambia el hijo
               if (Math.random()<=this.prob_muta){
               Muta.mutaGenAleatorio(hijo);
               }
// agrega el hijo a la nueva poblacion
             
               nuevaP.agregarHabitante(hijo);
            }
            // actualizamos la población 
            this.poblacion = new Poblacion(nuevaP);
            Individuo mejor =  this.poblacion.getMejor();
             
         
          System.out.println(e +" - fitness de: "+mejor.getFitness());
        
          

            
        }
        
    }

 
    
    
}

    
    
