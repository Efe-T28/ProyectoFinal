/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Vehiculo {
     private int numVeh;
    private String numPlaca;
    private int numAsientos;
    private boolean aire;
    private boolean sonido;

    public Vehiculo() {
        this.numAsientos = 4;
    }

    public int getNumVeh() {
        return numVeh;
    }

    public void setNumVeh(int numVeh) {
        this.numVeh = numVeh;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public String getAire() {
        return aire ? "si" : "no";
    }

    public void setAire(boolean aire) {
        this.aire = aire;
    }

    public String getSonido() {
        return sonido ? "si" : "no";
    }

    public void setSonido(boolean sonido) {
        this.sonido = sonido;
    }

    public void transportar() {
        System.out.println("El vehiculo esta transportando a " + numAsientos + " pasajeros.");
    }

    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero del vehiculo:");
        setNumVeh(scanner.nextInt());

        System.out.println("Ingrese el numero de placa:");
        setNumPlaca(scanner.next());

        System.out.println("Ingrese el numero de asientos:");
        setNumAsientos(scanner.nextInt());

        System.out.println("Tiene aire acondicionado? (si/no):");
        setAire(scanner.next().equalsIgnoreCase("si"));

        System.out.println("Tiene sistema de sonido? (si/no):");
        setSonido(scanner.next().equalsIgnoreCase("si"));
    }

        public int getNumero() {
        return numVeh;
        }
}