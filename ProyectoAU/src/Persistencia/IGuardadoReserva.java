/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Reserva;
import java.util.ArrayList;


public interface IGuardadoReserva {
    public ArrayList<Reserva> mostrarDatosReserva();
    public Reserva consultarReservas(String infoUsuario);
}

