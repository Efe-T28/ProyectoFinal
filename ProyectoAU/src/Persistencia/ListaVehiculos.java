/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class ListaVehiculos  {
    
     private List<ListaVehiculos> vehiculos;

    public ListaVehiculos () {
        vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(ListaVehiculos vehiculo) {
        vehiculos.add(vehiculo);
    }

    public ListaVehiculos consultarVehiculo(int numVeh) {
        for (ListaVehiculos vehiculo : this.vehiculos) {
            if (vehiculo.getNumVeh() == numVeh) {
                return vehiculo;
            }
        }
        return null; // Si no se encuentra el vehículo
    }

    public ArrayList<ListaVehiculos> mostrarVehiculos() {
        return new ArrayList<>(vehiculos);
    }

    private int getNumVeh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
