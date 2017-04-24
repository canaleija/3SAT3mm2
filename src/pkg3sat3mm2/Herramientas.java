/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3sat3mm2;

import data.Datos;
import data.Individuo;
import data.Poblacion;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Herramientas {
    
    public static Datos obtenerDatos() throws Exception
    {
        int tamañoDelGenotipo = 0;
        int tamañoDeCláusula = 0;
        int númeroDeCláusulas = 0;
        ArrayList<Integer[]> cláusulas = new ArrayList<>();
        JFileChooser seleccionArchivo = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Texto", "txt");
        seleccionArchivo.setFileFilter(filtro);
        seleccionArchivo.showOpenDialog(seleccionArchivo);
        FileReader fr = new FileReader(seleccionArchivo.getSelectedFile());
        BufferedReader br = new BufferedReader(fr);
        String línea = br.readLine();
        String números[] = línea.split(" ");
        tamañoDelGenotipo = Integer.parseInt(números[0]);
        númeroDeCláusulas = Integer.parseInt(números[1]);
        tamañoDeCláusula = Integer.parseInt(números[2]);
        do
        {
            línea = br.readLine();
            if(línea==null)
                break;
            números = línea.split(" ");
            Integer cláusula[] = new Integer[tamañoDeCláusula];
            for(int i=0;i<números.length;i++)
            {
                cláusula[i] = Integer.parseInt(números[i]);
            }
            cláusulas.add(cláusula);
        }while(1>0);
        return new Datos(tamañoDelGenotipo,cláusulas, tamañoDeCláusula);
    }
    public static void guardarPoblación(Poblacion p,String ruta)throws IOException
    {
        FileOutputStream fos = new FileOutputStream(ruta);
        ArrayList<String> individuos = new ArrayList<>();
        for(Individuo i : p.getIndividuos())
        {
            individuos.add(i.getRepresentación());
        }
        String representación = "";
        for(String s : individuos)
        {
            representación += (s+"\n");
        }
        fos.write(representación.getBytes());
    }
    public static Poblacion cargarPoblación(String ruta)throws IOException
    {
        FileInputStream fis = new FileInputStream(ruta);
        byte buffer[] = new byte[8096];
        LinkedList<Individuo> individuos = new LinkedList<>();
        fis.read(buffer);
        String representación = new String(buffer);
        int índice = 0;
        while(representación.charAt(índice)!='}')
        {
            índice++;
        }
        índice--;
        int tamañoDelGenotipo = índice;
        índice = 0;
        int genotipoActual[] = new int[tamañoDelGenotipo];
        int aux = 0;
        while(índice<representación.length())
        {
            if(representación.charAt(índice)=='0'||representación.charAt(índice)=='1')
            {
                genotipoActual[aux] = Integer.parseInt(""+representación.charAt(índice));
                aux++;
            }
            else if(representación.charAt(índice)=='}')
            {
                individuos.add(new Individuo(genotipoActual));
                aux = 0;
                genotipoActual = new int[tamañoDelGenotipo];
            }
            índice++;
        }
        return new Poblacion(individuos);
    }
    
}
