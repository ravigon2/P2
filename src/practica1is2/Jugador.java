/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1is2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Jugador {
    private static int IDJugador = 0;
    private String nombre, demarcacion;
    private int importe;
    private int idEquipo;
    private Equipo e;
    ArrayList <Jugador> ListaJugadores = new ArrayList<Jugador>();
    
    //Constructor con argumentos de la clase Jugador
    public Jugador(int id, String nom, String demar, int imp, int ide){
        IDJugador = id;
        nombre = nom;
        demarcacion = demar;
        importe = imp;
        idEquipo = ide;
    }

    Jugador() {
    }
    
    //Asigna un nombre a la variable nombre
    public void setNombre(String nom){
        nombre = nom;
    }
    
    //Asigna una nombre a la variable demarcacion
    public void setDemarcacion(String dem){
        demarcacion = dem;
    }
    
    //Asigna un entero a la variable importe
    public void setImporte(int imp){
        importe = imp;
    }
    
    //Asigna un entero a la variable identificador del equipo
    public void setidEquipo(int ide){
        idEquipo = ide;
    }
    
    //Devuelve el nombre del jugador
    public String getNombre(){
        return nombre;
    }
    
    //Devuelve el nombre de la demarcacion
    public String getDemarcacion(){
        return demarcacion;
    }
    
    //Devuelve el importe del jugador
    public int getImporte(){
        return importe;
    }
    
    //Devuelve el identificador del equipo
    public int getidEquipo(){
        return idEquipo;
    }
    
    //Funcion que añade un jugador con sus correspondientes datos
    public Jugador addJugador(){
        IDJugador++;
        nombre = JOptionPane.showInputDialog("Nombre del jugador: ");
        demarcacion = JOptionPane.showInputDialog("Posicion del jugador: ");
        importe = Integer.parseInt(JOptionPane.showInputDialog("Importe de su clausula de recision: "));
        idEquipo = Integer.parseInt(JOptionPane.showInputDialog("Equipo al que pertenece: "));
       
        Jugador j = new Jugador(IDJugador, nombre, demarcacion, importe, idEquipo);
        this.ListaJugadores.add(j);
        return j;
    }
    
    //Funcion que muestra los jugadores
    public void MostrarJugadores(Equipo e){
        System.out.println(e.toString(e));
        
        for (int x = 0; x < ListaJugadores.size(); x++) {
            if(e.getIDEquipo() == ListaJugadores.get(x).getidEquipo()){
                System.out.println(toString(ListaJugadores.get(x)));
            } 
        }
    }
    
    //Funcion que devuelve el array de jugadores
    public ArrayList getArrayJugadores(){
        return ListaJugadores;
    }
    
    public String toString(Jugador j){
         return " Nombre: "+j.getNombre();
    }
}
