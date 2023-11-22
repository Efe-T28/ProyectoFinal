/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicesar.igproyecto.logica;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author luism
 */
public interface IAgregarRutas {
    
    void guardarEnArchivo(String origen, String destino, LocalTime hora, LocalDate fechaSalida, Double precio, int codigo);
}
