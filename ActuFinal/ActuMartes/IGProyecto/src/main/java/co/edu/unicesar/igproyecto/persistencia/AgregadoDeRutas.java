/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.igproyecto.persistencia;

import co.edu.unicesar.igproyecto.logica.IAgregarRutas;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author luism
 */
public class AgregadoDeRutas implements IAgregarRutas{

    @Override
    public void guardarEnArchivo(String origen, String destino, LocalTime hora, LocalDate fechaSalida, Double precio, int codigo) {
        try {
            FileWriter writer = new FileWriter("ruta.txt", true);
            writer.write(origen + ";" + destino + ";" + hora + ";" + fechaSalida + ";" + precio + ";" + codigo + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
