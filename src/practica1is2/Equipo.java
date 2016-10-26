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
    private int importe, nabonados, gastos_fijos, gastos_var;
    ArrayList <Equipo> ListaEquipos = new ArrayList<Equipo>();
    private ArrayList<Jugador> jugador;
    private Jugador jugadores;
    
    //Constructor con argumentos de la clase equipo
    public Equipo(int id, String nom, int imp,int na, int gf, int gv){
        IDEquipo = id;
        nombre = nom;
        importe = imp;
        nabonados = na;
        gastos_fijos = gf;
        gastos_var = gv;
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
    
    //Asigna un entero a la variable gastos fijos
    public void setGastosFijos(int gf){
        gastos_fijos = gf;
    }
    
    //Asigna un entero a la variable gastos variables
    public void setGastosVariables(int gv){
        gastos_var = gv;
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
    
    //Devuelve los gastos fijos anuales que tiene el equipo
    public int getGastosFijos(){
        return gastos_fijos;
    }
    
    //Devuelve los gastos variables anuales que tiene el equipo
    public int getGastosVariables(){
        return gastos_var;
    }
    
    //Funcion para añadir un equipo, con sus correspondientes datos
    public Equipo addEquipo(){
        IDEquipo++;
        nombre = tryCatchString("Nombre del equipo: ");
        importe = tryCatchEnteros("Importe de caja actual: ");
        nabonados = tryCatchEnteros("Numero de abonados: ");
        gastos_fijos = tryCatchEnteros("Gastos fijos generales anuales: ");
        gastos_var = tryCatchEnteros("Gastos variables generales anuales: ");
        
        Equipo equipo = new Equipo(IDEquipo, nombre, importe, nabonados, gastos_fijos, gastos_var);
        this.ListaEquipos.add(equipo);
        return equipo;
    }
   
    public String toString(Equipo e){
        return(" Nombre: "+e.getNombre()+" Importe: "+e.getImporte()+" Numero Abonados: "+e.getNAbonados()+" Gastos fijos: "+e.getGastosFijos()+" Gastos variables: "+e.getGastosVariables());
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
    
    //Función auxiliar que comprueba si la variable pasada como parámetro es numerica o no
    //En caso de ser númerico devuelve true
    public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }

    //Función auxiliar encargada de hacer el try-catch de variable de tipo string
    public String tryCatchString(String mensaje){
        String variable = null;
        
        do{
            try{
                variable = JOptionPane.showInputDialog(mensaje);
            }catch(Exception e){
                System.out.print("La variable introducida no es de tipo string.");
            }
        }while(isNumeric(variable));

        return variable;
    }
    
    //Función auxiliar encargada de hacer el try-catch de variable de tipo int
    public int tryCatchEnteros(String mensaje){
        String variable = null;
        int conversion;
        
        do{
            try{
                variable = (JOptionPane.showInputDialog(mensaje));
                
            }catch(Exception e){
                System.out.print("La variable introducida no es de tipo entero.");
            }
        }while(!isNumeric(variable));
        
        conversion = Integer.parseInt(variable);
        
        return conversion;
    }
}
