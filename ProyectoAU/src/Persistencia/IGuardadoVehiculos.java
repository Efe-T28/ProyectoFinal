/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Vehiculo;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public interface IGuardadoVehiculos {
    Vehiculo consultarVehiculos(String numVeh);
    ArrayList<Vehiculo> mostrarVehiculos();

 }
