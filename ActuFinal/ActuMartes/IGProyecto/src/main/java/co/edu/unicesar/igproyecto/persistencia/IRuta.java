/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicesar.igproyecto.persistencia;

import co.edu.unicesar.igproyecto.entidades.Ruta;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public interface IRuta {
    List<Ruta> cargarRutas();
    void guardarRutas(List<Ruta> rutas);
}
