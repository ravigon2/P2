
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1is2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Practica1IS2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File archivo;
        Equipo e = new Equipo();
        Jugador j = new Jugador();
        Traspaso t = new Traspaso();
        int numero;
        ArrayList <Equipo> ListaEquipos = new ArrayList<Equipo>();
        ArrayList <Jugador> ListaJugadores= new ArrayList<Jugador>();
        ArrayList <Traspaso> ListaTraspasos = new ArrayList<Traspaso>();
        
        do{
            System.out.println("1.Registrar un nuevo equipo");
            System.out.println("2.Registrar un nuevo jugador");
            System.out.println("3.Registrar un traspaso de jugador");
            System.out.println("4.Listar en pantalla los datos basicos de los equipos registrados");
            System.out.println("5.Listar los jugadores de cada equipo");
            System.out.println("6.Mostrar los traspasos realizados");
            System.out.println("7.Salir del programa");
            
            numero = Integer.parseInt(JOptionPane.showInputDialog("Elija la opcion deseada: "));
        
            switch(numero){
                case 1:
                    e.addEquipo();
                    break;
                case 2:
                    j.addJugador();
                    break;
                case 3:
                    ListaEquipos = e.getArrayEquipos();
                    ListaJugadores = j.getArrayJugadores();
                    t.addTraspaso(ListaEquipos, ListaJugadores);
                    break;
                case 4:
                    e.MostrarEquipos();
                    break;
                case 5:
                    ListaEquipos = e.getArrayEquipos();
                    for(int i = 0; i < ListaEquipos.size(); i++){
                        j.MostrarJugadores(ListaEquipos.get(i));
                    }
                    break;
                case 6:
                    t.MostrarTraspasos();
                    break;
                case 7:
                    String equipos = e.toString();;
                    try{
                        archivo=new File("C:\\IS2\\archivo.txt");
                        FileWriter w = new FileWriter(archivo);
                        BufferedWriter b = new BufferedWriter(w);
                        PrintWriter p = new PrintWriter(b);
                        if(archivo.createNewFile())
                        p.write(equipos);
                            System.out.println("Se ha creado el archivo");
                    }catch(IOException er){
                        System.err.println("No se puede crear el archivo"+er);
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }while(numero != 7);
    }
    
}
