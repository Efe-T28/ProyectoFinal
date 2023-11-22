/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import Persistencia.ListaUsuario;
import java.util.ArrayList;

public class Conductor extends Usuario {

    @Override
    public boolean inicioSesion() {
     ListaUsuario listaUsuario = new ListaUsuario();
        ArrayList<Usuario> listaUsuarios = listaUsuario.mostrarDatosUsuarios();

        // Obtener los datos del conductor actual.
        String usernameConductor = getUsername();
        String contraseñaConductor = getContraseña();

        // Verifica las credenciales del conductor en la lista de usuarios.
        boolean inicioSesionExitoso = false;
        for (Usuario usuario : listaUsuarios) {
            if (usuario instanceof Conductor) {
                Conductor conductor = (Conductor) usuario;
                // Verificar las credenciales del conductor.
                if (conductor.getUsername().equals(usernameConductor) && conductor.getContraseña().equals(contraseñaConductor)) {
                    inicioSesionExitoso = true;
                    break;
                }
            }
        }

        if (inicioSesionExitoso) {
            System.out.println("Inicio de sesión exitoso Conductor .");
        } else {
            System.out.println("Inicio de sesión fallido. Verifica tu nombre de usuario y contraseña.");
        }
        return false;
    }
    
    @Override
    public String toString() {
        return null ;
    }
        @Override
    public String infoUsuario() {
         ListaUsuario listaUsuario = new ListaUsuario();
        ArrayList<Usuario> listaUsuarios = listaUsuario.mostrarDatosUsuarios();

        // Iterar a través de la lista de usuarios para encontrar un cliente
        for (Usuario usuario : listaUsuarios) {
            // Verificar si el usuario es una instancia de Cliente
            if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                
                // Mostrar la información del cliente 
                System.out.println("Información del Cliente:");
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("CC: " + cliente.getCedula());
                System.out.println("Dirección: " + cliente.getDireccion());
                System.out.println("Teléfono: " + cliente.getTelefono());
            }
        }
        return null;
    
    }

}
