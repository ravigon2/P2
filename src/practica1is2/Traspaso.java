/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1is2;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
//Realiza el traspaso de un jugador de un equipo origen a un equipo destino
public class Traspaso {

    private static int IDTraspaso = 0;
    private String jugador;
    private int importe, equipOrigen, equipDestino;
    private Date fecha;
    ArrayList<Traspaso> ListaTraspasos = new ArrayList<Traspaso>();

    //Constructor con argumentos
    public Traspaso(int id, String ju, int eqO, int eqD, int imp, Date f) {
        IDTraspaso = id;
        jugador = ju;
        equipOrigen = eqO;
        equipDestino = eqD;
        importe = imp;
        fecha = f;
    }

    Traspaso() {
    }

    //Asigna un nombre a la variable jugador
    public void setJugador(String ju) {
        jugador = ju;
    }

    //Asigna un entero a la variable equipo Origen
    public void setEquipoOrigen(int eqO) {
        equipOrigen = eqO;
    }

    //Asigna un entero a la variable equipo Destino
    public void setEquipoDestino(int eqD) {
        equipDestino = eqD;
    }

    //Asigna un entero a la variable importe
    public void setImporte(int imp) {
        importe = imp;
    }

    //Asigna un Date a la variable fecha
    public void setFecha(Date f) {
        fecha = f;
    }

    //Devuelve el nombre del jugador
    public String getJugador() {
        return jugador;
    }

    //Devuelve el entero que corresponde al equipo Origen
    public int getEquipoOrigen() {
        return equipOrigen;
    }

    //Devuelve el entero que corresponde al equipo Destino
    public int getEquipoDestino() {
        return equipDestino;
    }

    //Devuelve el importe del traspaso
    public int getImporte() {
        return importe;
    }

    //Devuelve la fecha en la que se realizó el traspaso
    public Date getFecha() {
        return fecha;
    }

    //Añade un traspaso de un jugador a un determinado equipo
    public Traspaso addTraspaso(ArrayList equipos, ArrayList jugadores) {
        int dia, mes, anyo;
        IDTraspaso++;
        jugador = JOptionPane.showInputDialog("Nombre del jugador: ");
        equipOrigen = Integer.parseInt(JOptionPane.showInputDialog("Equipo de origen: "));
        equipDestino = Integer.parseInt(JOptionPane.showInputDialog("Equipo destino: "));
        importe = Integer.parseInt(JOptionPane.showInputDialog("Importe de la clausula que se ha pagado: "));
        dia = Integer.parseInt(JOptionPane.showInputDialog("Introducir dia: "));
        mes = Integer.parseInt(JOptionPane.showInputDialog("Introducir mes: "));
        anyo = Integer.parseInt(JOptionPane.showInputDialog("Introducir anyo: "));

        Date fecha = new Date(dia, mes, anyo);
        Traspaso traspaso = new Traspaso(IDTraspaso, jugador, equipOrigen, equipDestino, importe, fecha);

        Jugador jugador_aux;
        Equipo equipo_aux, equipo_aux1 = null, equipo_aux2 = null;
        for (int x = 0; x < equipos.size(); x++) {
            equipo_aux = ((Equipo) equipos.get(x));
            if (equipo_aux.getIDEquipo() == equipOrigen) {
                equipo_aux1 = ((Equipo) equipos.get(x));
            }
            if (equipo_aux.getIDEquipo() == equipDestino) {
                equipo_aux2 = ((Equipo) equipos.get(x));
            }
        }
        for (int i = 0; i < jugadores.size(); i++) {
            jugador_aux = ((Jugador) jugadores.get(i));
            if (jugador_aux.getNombre() == jugador) {
                jugador_aux.setidEquipo(getEquipoDestino());
                int aux_importe = equipo_aux1.getImporte();
                equipo_aux1.setImporte(aux_importe + importe);
                int aux_importe_D = equipo_aux2.getImporte();
                equipo_aux2.setImporte(aux_importe - importe);
            }
        }

        this.ListaTraspasos.add(traspaso);
        return traspaso;
    }
    
    //Muestra la lista de traspasos realizados
    public void MostrarTraspasos() {
        for (int i = 0; i < ListaTraspasos.size(); i++) {
            System.out.println(toString(ListaTraspasos.get(i)));
        }
    }

    public String toString(Traspaso t) {
        return (" Nombre: " + t.getJugador() + " Equipo Origen: " + t.getEquipoOrigen() + " Equipo Destino: " + t.getEquipoDestino() + " Importe: " + t.getImporte() + " Fecha: " + t.getFecha());
    }
}
