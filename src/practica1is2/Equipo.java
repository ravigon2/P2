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
public class Equipo {
    private static int IDEquipo = 0;
    private String nombre;
    private int importe, nabonados;
    ArrayList <Equipo> ListaEquipos = new ArrayList<Equipo>();
    private ArrayList<Jugador> jugador;
    private Jugador jugadores;
    
    //Constructor con argumentos de la clase equipo
    public Equipo(int id, String nom, int imp,int na){
        IDEquipo = id;
        nombre = nom;
        importe = imp;
        nabonados = na;  
    }

    Equipo() {}
    
    //Devuelve el identificador del equipo
    public int getIDEquipo(){
        return IDEquipo;
    }
    
    //Asigna un string nom a la variable nombre
    public void setNombre(String nom){
        nombre = nom;
    }
    
    //Asigna un entero a la variable importe
    public void setImporte(int imp){
        importe = imp;
    }
    
    //Asigna un entero a la variable nabonados
    public void setNAbonados(int nabo){
        nabonados = nabo;
    }
    
    //Devuelve el nombre del equipo
    public String getNombre(){
        return nombre;
    }
    
    //Devuelve el importe que tiene un equipo
    public int getImporte(){
        return importe;
    }
    
    //Devuelve el numero de abonados que tiene el equipo
    public int getNAbonados(){
        return nabonados;
    }
    
    //Funcion para añadir un equipo, con sus correspondientes datos
    public Equipo addEquipo(){
        IDEquipo++;
        nombre = JOptionPane.showInputDialog("Nombre del equipo: ");
        importe = Integer.parseInt(JOptionPane.showInputDialog("Importe de caja actual: "));
        nabonados = Integer.parseInt(JOptionPane.showInputDialog("Numero de abonados: "));
        
        Equipo equipo = new Equipo(IDEquipo, nombre, importe, nabonados);
        this.ListaEquipos.add(equipo);
        return equipo;
    }
   
    public String toString(Equipo e){
        return(" Nombre: "+e.getNombre()+" Importe: "+e.getImporte()+" Numero Abonados: "+e.getNAbonados());
    }
    
    //Funcion que muestra la lista de equipos
    public void MostrarEquipos(){
        for(int i = 0; i < ListaEquipos.size(); i++){
            System.out.println(toString(ListaEquipos.get(i)));
        }
    }
    
    //Funcion que devuelve el array de equipos
    public ArrayList getArrayEquipos(){
        return ListaEquipos;
    }
    
    //Funcion que añade un jugador al equipo
    public void addJugador(Jugador jug){
        jugador.add(jug);
    }
}
