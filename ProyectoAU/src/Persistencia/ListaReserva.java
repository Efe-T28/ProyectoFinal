/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import entidades.Reserva;
import java.util.ArrayList;
import java.util.List;


import entidades.Reserva;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pana
 */
public class ListaReserva{
    private List<Reserva> listaReserva;
    
    public ListaReserva(){
        this.listaReserva =  new ArrayList();
    }
    
    
    public void agregarReserva(Reserva T){
        this.listaReserva.add(T);
    }
    
    public ArrayList<Reserva> mostrarDatosR(){
        ArrayList<Reserva> ListaU = new ArrayList(this.listaReserva);
        return ListaU;
    }
    
    
    public Reserva consultarUsuario(String infoUsuario){
        Reserva reservaConsultada =null;
        for(Reserva T: this.listaReserva){
            if(T.getInfoRuta() == null ? infoUsuario == null : T.getInfoRuta().equals(infoUsuario)){
                reservaConsultada = T;
                break;
            }
        }
        return reservaConsultada;
    }
}    
